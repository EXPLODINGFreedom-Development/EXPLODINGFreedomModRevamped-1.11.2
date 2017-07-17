package com.efdevelopment.EXPLODINGFreedomModRevamped.Utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class EFMR_CustomConfigurationFiles
{
    private TotalFreedomMod core;
    protected FileConfiguration config;
    private File file;

    public EFMR_CustomConfigurationFiles(TotalFreedomMod core, String fileName)
    {
        this.core = core;
        create(fileName);
    }

    public EFMR_CustomConfigurationFiles(TotalFreedomMod core, String fileName, String folderName)
    {
        this.core = core;
        create(fileName, folderName);
    }

    private void create(String fileName)
    {
        this.file = new File(this.core.getDataFolder(), fileName);
        debug(this.file);
    }

    private void create(String fileName, String folderName)
    {
        if (!new File(this.core.getDataFolder(), folderName).exists())
        {
            new File(this.core.getDataFolder(), folderName).mkdir();
        }
        this.file = new File(this.core.getDataFolder(), folderName + File.separator + fileName);
        debug(this.file);
    }

    private void debug(File file)
    {
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (Exception e)
            {
                this.core.getLogger().warning("An error occurred, please report this error to the author.");
                e.printStackTrace();
            }
        }
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public void saveConfig()
    {
        try
        {
            this.config.save(this.file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void reloadConfig()
    {
        try
        {
            this.config.load(this.file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
