package com.efdevelopment.EXPLODINGFreedomModRevamped;

import com.efdevelopment.EXPLODINGFreedomModRevamped.EFMR_BuilderList;
import me.StevenLawson.TotalFreedomMod.TFM_Log;

public class EFMR
{

    public static final String DONATOR_FILE = "donator.yml";
   public static final String BUILDER_FILE = "builder.yml";
    public void onEnable()
    {
        loadDonatorConfig();
        loadBuilderConfig();
    }
    public static void loadBuilderConfig()
    {
        try
        {
            EFMR_BuilderList.load();
            EFMR_BuilderList.createBackup();
        }
        catch (Exception ex)
        {
            TFM_Log.severe("Error loading Builder list: " + ex.getMessage());
        }
    }
    public static void loadDonatorConfig()
    {
        try
        {
            EFMR_DonatorList.load();
            EFMR_DonatorList.createBackup();
        }
        catch (Exception ex)
        {
            TFM_Log.severe("Error loading donator list: " + ex.getMessage());
        }
    }
}