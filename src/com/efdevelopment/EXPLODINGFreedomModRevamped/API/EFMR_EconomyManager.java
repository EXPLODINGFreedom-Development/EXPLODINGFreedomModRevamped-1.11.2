package com.efdevelopment.EXPLODINGFreedomModRevamped.API;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class EFMR_EconomyManager
{
    public static Double GetBalance(String player_name)
    {
        Double Balance = Double.valueOf(EFMR_EcoConfigManager.getBalanceConfig().getDouble(player_name));
        return Balance;
    }

    public static String Format(Double amount)
    {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        String Format = formatter.format(amount);
        return Format.replace("($", "$-").replace(")", "");
    }

    public static boolean Isinfile(String player_name)
    {
        File file = new File("plugins//" + StringManager.PluginName + "//balances.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (!cfg.contains(player_name))
        {
            return false;
        }
        return true;
    }

    public static boolean SetBalance(String player_name, Double amount)
    {
        File file = new File("plugins//" + StringManager.PluginName + "//balances.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (!Isinfile(player_name))
        {
            return false;
        }
        cfg.set(player_name, amount);
        try
        {
            cfg.save(file);
            StringManager.CInfo("Saved balances file");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean New(String player_name)
    {
        File file = new File("plugins//" + StringManager.PluginName + "//balances.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set(player_name, TFM_ConfigEntry.FIRSTJOINAMOUNT.getInteger());
        try
        {
            cfg.save(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean AddBalance(String player_name, Double amount)
    {
        File file = new File("plugins//" + StringManager.PluginName + "//balances.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (!Isinfile(player_name))
        {
            return false;
        }
        Double CurrentBalance = Double.valueOf(cfg.getDouble(player_name));
        cfg.set(player_name, Double.valueOf(CurrentBalance.doubleValue() + amount.doubleValue()));
        try
        {
            cfg.save(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean RemoveBalance(String player_name, Double amount)
    {
        File file = new File("plugins//" + StringManager.PluginName + "//balances.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (!Isinfile(player_name))
        {
            return false;
        }
        Double CurrentBalance = Double.valueOf(cfg.getDouble(player_name));
        cfg.set(player_name, Double.valueOf(CurrentBalance.doubleValue() - amount.doubleValue()));
        try
        {
            cfg.save(file);
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean ResetBalance(String player_name)
    {
        File file = new File("plugins//" + StringManager.PluginName + "//balances.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (!Isinfile(player_name))
        {
            return false;
        }
        Double ResetBalance = Double.valueOf(TFM_ConfigEntry.FIRSTJOINAMOUNT.getInteger());
        cfg.set(player_name, ResetBalance);
        try
        {
            cfg.save(file);
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
