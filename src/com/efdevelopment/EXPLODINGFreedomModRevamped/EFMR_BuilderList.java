package com.efdevelopment.EXPLODINGFreedomModRevamped;

import com.efdevelopment.EXPLODINGFreedomModRevamped.World.EFMR_BuilderWorld;
import java.io.File;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import com.google.common.collect.Sets;
import me.StevenLawson.TotalFreedomMod.Config.TFM_Config;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.util.FileUtil;

public class EFMR_BuilderList
{
    private static final Map<UUID, EFMR_Builder> builderList;
    private static final Set<UUID> builderUUIDs;
    private static final Set<String> builderIps;

    static
    {
        builderList = new HashMap<UUID, EFMR_Builder>();
        builderUUIDs = new HashSet<UUID>();
        builderIps = new HashSet<String>();
    }

    private EFMR_BuilderList()
    {
        throw new AssertionError();
    }

    public static Set<UUID> getBuilderUUIDs()
    {
        return Collections.unmodifiableSet(builderUUIDs);
    }

    public static Set<String> getBuilderIps()
    {
        return Collections.unmodifiableSet(builderIps);
    }

    public static Set<String> getBuilderNames()
    {
        final Set<String> names = new HashSet<String>();

        for (EFMR_Builder admin : builderList.values())
        {
            if (!admin.isActivated())
            {
                continue;
            }

            names.add(admin.getLastLoginName());
        }

        return Collections.unmodifiableSet(names);
    }

    public static Set<String> getLowerSuperNames()
    {
        final Set<String> names = new HashSet<String>();

        for (EFMR_Builder admin : builderList.values())
        {
            if (!admin.isActivated())
            {
                continue;
            }

            names.add(admin.getLastLoginName().toLowerCase());
        }

        return Collections.unmodifiableSet(names);
    }

    public static Set<EFMR_Builder> getAllAdmins()
    {
        return Sets.newHashSet(builderList.values());
    }

    public static void load()
    {
        builderList.clear();

        final TFM_Config config = new TFM_Config(TotalFreedomMod.plugin, EFMR.BUILDER_FILE, true);
        config.load();

        // Parse old donors
        if (config.isConfigurationSection("builders"))
        {
            parseOldConfig(config);
        }

        if (!config.isConfigurationSection("Builders"))
        {
            TFM_Log.warning("Missing builders section in builder.yml.");
            return;
        }

        final ConfigurationSection section = config.getConfigurationSection("Builders");

        for (String uuidString : section.getKeys(false))
        {
            if (!TFM_Util.isUniqueId(uuidString))
            {
                TFM_Log.warning("Invalid Unique ID: " + uuidString + " in builder.yml, ignoring");
                continue;
            }

            final UUID uuid = UUID.fromString(uuidString);

            final EFMR_Builder builder = new EFMR_Builder(uuid, section.getConfigurationSection(uuidString));
            builderList.put(uuid, builder);
        }

        updateIndexLists();

        TFM_Log.info("Loaded " + builderList.size() + " builders (" + builderUUIDs.size() + " active) and " + builderIps.size() + " IPs.");
    }

    public static void createBackup()
    {
        final File oldYaml = new File(TotalFreedomMod.plugin.getDataFolder(), EFMR.BUILDER_FILE);
        final File newYaml = new File(TotalFreedomMod.plugin.getDataFolder(), EFMR.BUILDER_FILE + ".bak");
        FileUtil.copy(oldYaml, newYaml);
    }

    public static void updateIndexLists()
    {
        builderUUIDs.clear();
        
        builderIps.clear();

        for (EFMR_Builder admin : builderList.values())
        {
            if (!admin.isActivated())
            {
                continue;
            }

            final UUID uuid = admin.getUniqueId();

           builderUUIDs.add(uuid);

            for (String ip : admin.getIps())
            {
                builderIps.add(ip);
            }

        EFMR_BuilderWorld.getInstance().wipeAccessCache();
    }
    }
    private static void parseOldConfig(TFM_Config config)
    {
        TFM_Log.info("Old builder configuration found, parsing...");

        final ConfigurationSection section = config.getConfigurationSection("builders");

        int counter = 0;
        int errors = 0;

        for (String admin : config.getConfigurationSection("builders").getKeys(false))
        {
            final OfflinePlayer player = Bukkit.getOfflinePlayer(admin);

            if (player == null || player.getUniqueId() == null)
            {
                errors++;
                TFM_Log.warning("Could not convert admin " + admin + ", UUID could not be found!");
                continue;
            }

            final String uuid = player.getUniqueId().toString();

            config.set("builders." + uuid + ".last_login_name", player.getName());
            config.set("builders." + uuid + ".is_activated", section.getBoolean(admin + ".is_activated"));
            config.set("builders." + uuid + ".last_login", section.getString(admin + ".last_login"));
            config.set("builders." + uuid + ".custom_login_message", section.getString(admin + ".custom_login_message"));
            config.set("builders." + uuid + ".ips", section.getStringList(admin + ".ips"));

            counter++;
        }

        config.set("builders", null);
        config.save();

        TFM_Log.info("Done! " + counter + " builders parsed, " + errors + " errors");
    }

    public static void save()
    {
        final TFM_Config config = new TFM_Config(TotalFreedomMod.plugin, EFMR.BUILDER_FILE, true);
        config.load();

        Iterator<Entry<UUID, EFMR_Builder>> it = builderList.entrySet().iterator();
        while (it.hasNext())
        {
            Entry<UUID, EFMR_Builder> pair = it.next();

            UUID uuid = pair.getKey();
            EFMR_Builder builder = pair.getValue();

            config.set("builders." + uuid + ".last_login_name", builder.getLastLoginName());
            config.set("builders." + uuid + ".is_activated", builder.isActivated());
            config.set("builders." + uuid + ".last_login", TFM_Util.dateToString(builder.getLastLogin()));
            config.set("builders." + uuid + ".custom_login_message", builder.getCustomLoginMessage());
            config.set("builders." + uuid + ".ips", TFM_Util.removeDuplicates(builder.getIps()));
        }

        config.save();
    }

    public static EFMR_Builder getEntry(Player player)
    {
        final UUID uuid = player.getUniqueId();

        if (Bukkit.getOnlineMode())
        {
            if (builderList.containsKey(uuid))
            {
                return builderList.get(uuid);
            }
        }

        return getEntryByIp(TFM_Util.getIp(player));
    }

    public static EFMR_Builder getEntry(UUID uuid)
    {
        return builderList.get(uuid);
    }

    @Deprecated
    public static EFMR_Builder getEntry(String name)
    {
        for (UUID uuid : builderList.keySet())
        {
            if (builderList.get(uuid).getLastLoginName().equalsIgnoreCase(name))
            {
                return builderList.get(uuid);
            }
        }
        return null;
    }

    public static EFMR_Builder getEntryByIp(String ip)
    {
        return getEntryByIp(ip, false);
    }

    public static EFMR_Builder getEntryByIp(String needleIp, boolean fuzzy)
    {
        Iterator<Entry<UUID, EFMR_Builder>> it = builderList.entrySet().iterator();
        while (it.hasNext())
        {
            final Entry<UUID, EFMR_Builder> pair = it.next();
            final EFMR_Builder builder = pair.getValue();

            if (fuzzy)
            {
                for (String haystackIp : builder.getIps())
                {
                    if (TFM_Util.fuzzyIpMatch(needleIp, haystackIp, 3))
                    {
                        return builder;
                    }
                }
            }
            else
            {
                if (builder.getIps().contains(needleIp))
                {
                    return builder;
                }
            }
        }
        return null;
    }

    public static void updateLastLogin(Player player)
    {
        final EFMR_Builder admin = getEntry(player);
        if (admin == null)
        {
            return;
        }
        admin.setLastLogin(new Date());
        admin.setLastLoginName(player.getName());
        save();
    }

    public static boolean isSuperBuilder(CommandSender sender)
    {
        if (!(sender instanceof Player))
        {
            return true;
        }

        if (Bukkit.getOnlineMode() && builderUUIDs.contains(((Player) sender).getUniqueId()))
        {
            return true;
        }

        if (builderIps.contains(TFM_Util.getIp((Player) sender)))
        {
            return true;
        }

        return false;
    }

    public static boolean isIdentityMatched(Player player)
    {
        if (!isSuperBuilder(player))
        {
            return false;
        }

        if (Bukkit.getOnlineMode())
        {
            return true;
        }

        final EFMR_Builder entry = getEntry(player);
        if (entry == null)
        {
            return false;
        }

        return entry.getUniqueId().equals(player.getUniqueId());
    }

    @Deprecated
    public static boolean checkPartialSuperadminIp(String ip, String name)
    {
        ip = ip.trim();

        if (builderIps.contains(ip))
        {
            return true;
        }

        try
        {
            String matchIp = null;
            for (String testIp : builderIps)
            {
                if (TFM_Util.fuzzyIpMatch(ip, testIp, 3))
                {
                    matchIp = testIp;
                    break;
                }
            }

            if (matchIp != null)
            {
                final EFMR_Builder entry = getEntryByIp(matchIp);

                if (entry == null)
                {
                    return true;
                }

                if (entry.getLastLoginName().equalsIgnoreCase(name))
                {
                    if (!entry.getIps().contains(ip))
                    {
                        entry.addIp(ip);
                    }
                    save();
                }
                return true;

            }
        }
        catch (Exception ex)
        {
            TFM_Log.severe(ex);
        }

        return false;
    }

    public static boolean isAdminImpostor(Player player)
    {
        if (builderUUIDs.contains(player.getUniqueId()))
        {
            return !isSuperBuilder(player);
        }

        return false;
    }

    public static void addSuperadmin(OfflinePlayer player)
    {
        final UUID uuid = player.getUniqueId();
        final String ip = TFM_Util.getIp(player);

        if (builderList.containsKey(uuid))
        {
            final EFMR_Builder builder = builderList.get(uuid);
            builder.setActivated(true);

            if (player instanceof Player)
            {
                builder.setLastLogin(new Date());
                builder.addIp(ip);
            }
            save();
            updateIndexLists();
            return;
        }

        if (ip == null)
        {
            TFM_Log.severe("Cannot add Builder: " + TFM_Util.formatPlayer(player));
            TFM_Log.severe("Could not retrieve IP!");
            return;
        }

        final EFMR_Builder builder = new EFMR_Builder(
                uuid,
                player.getName(),
                new Date(),
                "",
                false,
                false,
                true);
        builder.addIp(ip);

        builderList.put(uuid, builder);

        save();
        updateIndexLists();
    }

    public static void removeSuperadmin(OfflinePlayer player)
    {
        final UUID uuid = player.getUniqueId();

        if (!builderList.containsKey(uuid))
        {
            TFM_Log.warning("Could not remove admin: " + TFM_Util.formatPlayer(player));
            TFM_Log.warning("Player is not an admin!");
            return;
        }

        final EFMR_Builder builder = builderList.get(uuid);
       builder.setActivated(false);

        save();
        updateIndexLists();
    }

    public static void cleanSuperbuilderList(boolean verbose)
    {
        Iterator<Entry<UUID, EFMR_Builder>> it = builderList.entrySet().iterator();
        while (it.hasNext())
        {
            final Entry<UUID, EFMR_Builder> pair = it.next();
            final EFMR_Builder builder = pair.getValue();

            if (!builder.isActivated())
            {
                continue;
            }

            final Date lastLogin = builder.getLastLogin();
            final long lastLoginHours = TimeUnit.HOURS.convert(new Date().getTime() - lastLogin.getTime(), TimeUnit.MILLISECONDS);

        }

        save();
        updateIndexLists();
    }
}