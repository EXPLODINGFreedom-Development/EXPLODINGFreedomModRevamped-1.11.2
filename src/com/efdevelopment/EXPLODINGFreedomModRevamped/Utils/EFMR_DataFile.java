package com.efdevelopment.EXPLODINGFreedomModRevamped.Utils;

import java.util.List;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class EFMR_DataFile
        extends EFMR_CustomConfigurationFiles
{
    public EFMR_DataFile(TotalFreedomMod core, String fileName)
    {
        super(core, fileName + ".yml", "Data");
    }

    public void set(String path, Object value)
    {
        this.config.set(path, value);
    }

    public boolean isSet(String path)
    {
        return this.config.isSet(path);
    }

    public ConfigurationSection getConfigurationSection(String path)
    {
        return this.config.getConfigurationSection(path);
    }

    public boolean sectionExists(String path)
    {
        return getConfigurationSection(path) != null;
    }

    public String getString(String path)
    {
        return this.config.getString(path);
    }

    public boolean getBoolean(String path)
    {
        return this.config.getBoolean(path);
    }

    public double getDouble(String path)
    {
        return this.config.getDouble(path);
    }

    public List<String> getList(String path)
    {
        return this.config.getStringList(path);
    }

    public int getInt(String path)
    {
        return this.config.getInt(path);
    }

    public float getFloat(String path)
    {
        return (float) this.config.getDouble(path);
    }
}
