package com.efdevelopment.EXPLODINGFreedomModRevamped.API;

import com.google.common.base.Charsets;
import com.google.common.io.ByteStreams;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class EFMR_PlayerData
{
    private final JavaPlugin plugin;
    private File configFile;
    private FileConfiguration fileConfiguration;

    public EFMR_PlayerData(String fileName, JavaPlugin plugin)
    {
        if (plugin == null)
        {
            throw new IllegalArgumentException("Plugin cannot be null");
        }
        this.plugin = plugin;
        if (!plugin.getDataFolder().exists())
        {
            plugin.getDataFolder().mkdir();
        }
        File dataFolder = new File(plugin.getDataFolder().getPath() + File.separator + "Players");
        this.configFile = new File(dataFolder, fileName);
        if (!dataFolder.exists())
        {
            dataFolder.mkdir();
        }
        if (!this.configFile.exists())
        {
        }
        saveDefaultYaml();
    }

    public void reloadYaml()
    {
        this.fileConfiguration = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defConfigStream = this.plugin.getResource(this.configFile.getPath());
        if (defConfigStream == null)
        {
            return;
        }
        YamlConfiguration defConfig = new YamlConfiguration();
        try
        {
            byte[] contents = ByteStreams.toByteArray(defConfigStream);
        }
        catch (IOException e)
        {
            byte[] contents;
            this.plugin.getLogger().log(Level.SEVERE, "Unexpected failure reading config.yml", e);
            return;
        }
        byte[] contents = null;
        String text = new String(contents, Charset.defaultCharset());
        if (!text.equals(new String(contents, Charsets.UTF_8)))
        {
            this.plugin.getLogger().warning("Default system encoding may have misread config.yml from plugin jar");
        }
        try
        {
            defConfig.loadFromString(text);
        }
        catch (InvalidConfigurationException e)
        {
            this.plugin.getLogger().log(Level.SEVERE, "Cannot load configuration from jar", e);
        }
        this.fileConfiguration.setDefaults(defConfig);
    }

    public FileConfiguration getYaml()
    {
        if (this.fileConfiguration == null)
        {
            reloadYaml();
        }
        return this.fileConfiguration;
    }

    public void saveYaml()
    {
        if ((this.fileConfiguration == null) || (this.configFile == null))
        {
            return;
        }
        try
        {
            getYaml().save(this.configFile);
        }
        catch (IOException ex)
        {
            this.plugin.getLogger().log(Level.SEVERE, "Could not save config to " + this.configFile, ex);
        }
    }

    public void saveDefaultYaml()
    {
        if (!this.configFile.exists())
        {
            Path file = this.configFile.toPath();
            try
            {
                Files.createFile(file, new FileAttribute[0]);
            }
            catch (FileAlreadyExistsException x)
            {
                Bukkit.getLogger().log(Level.INFO, "Tried to create a new Player Config, but it already existed! ");
            }
            catch (IOException x)
            {
                if (Bukkit.broadcast(ChatColor.DARK_RED + "AN ERROR OCCURRED WHILE ATTEMPTING TO CREATE FILE: " + this.configFile.getName(), "esscore.debug") == 0)
                {
                    Bukkit.getLogger().log(Level.SEVERE, "AN ERROR OCCURRED WHILE ATTEMPTING TO CREATE FILE: " + this.configFile.getName(), x);
                }
            }
        }
    }

    public void modifyYaml()
    {
        saveYaml();
        reloadYaml();
    }
}
