package global.oskar.easyenchanting;

import global.oskar.easyenchanting.listener.ArmorEnchanter;
import global.oskar.easyenchanting.listener.EnchanterInteract;
import global.oskar.easyenchanting.listener.GuiInvSetup;
import global.oskar.easyenchanting.listener.GuiSetups;
import global.oskar.easyenchanting.listener.ToolEnchanter;
import global.oskar.easyenchanting.listener.WeaponEnchanter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
  public static Main plugin;
  
  public void onEnable() {
    plugin = this;
    loadConfig();
    registerListeners();
  }
  
  public void onDisable() {}
  
  public void registerListeners() {
    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(new GuiInvSetup(), this);
    pm.registerEvents(new GuiSetups(), this);
    pm.registerEvents(new ToolEnchanter(), this);
    pm.registerEvents(new WeaponEnchanter(), this);
    pm.registerEvents(new EnchanterInteract(), this);
    pm.registerEvents(new ArmorEnchanter(), this);
  }
  
  public void loadConfig() {
    getConfig().options().copyDefaults(true);
    saveConfig();
  }
}
