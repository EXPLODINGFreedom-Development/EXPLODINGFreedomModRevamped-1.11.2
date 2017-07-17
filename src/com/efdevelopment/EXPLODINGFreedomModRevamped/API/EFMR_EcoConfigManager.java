package com.efdevelopment.EXPLODINGFreedomModRevamped.API;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;

public class EFMR_EcoConfigManager {

	public static void CreateBalanceConfig() {
		File loc = new File("plugins//" + StringManager.PluginName);
		File file = new File("plugins//" + StringManager.PluginName + "//balances.yml");
		if (!loc.exists()) {
			loc.mkdir();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				StringManager.CWarning("The balances file could not be created!");
			}
		}
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static YamlConfiguration getBalanceConfig() {
		File file = new File("plugins//" + StringManager.PluginName + "//balances.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		return cfg;
	}
	
	public static File getBalanceFile() {
		File file = new File("plugins//" + StringManager.PluginName + "//balances.yml");
		return file;
	}

	public static void BalanceConfigSave() {
		File file = new File("plugins//" + StringManager.PluginName + "//balances.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		try {
			cfg.save(file);
			StringManager.CInfo("Saved balances file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
