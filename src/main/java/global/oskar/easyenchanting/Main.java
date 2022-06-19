/*
    EasyEnchantments - Provides a custom enchantment table for Minecraft
    Copyright (C) 2022  Oskar Manhart

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package global.oskar.easyenchanting;

import global.oskar.easyenchanting.listener.ArmorEnchanter;
import global.oskar.easyenchanting.listener.EnchanterInteract;
import global.oskar.easyenchanting.listener.GUIInvSetup;
import global.oskar.easyenchanting.listener.GUISetups;
import global.oskar.easyenchanting.listener.ToolEnchanter;
import global.oskar.easyenchanting.listener.WeaponEnchanter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Main extends JavaPlugin {
  public static Main plugin;
  public static Logger log;

  public void onEnable() {
    plugin = this;
    log = this.getLogger();
    loadConfig();
    registerListeners();
    this.getLogger().setLevel(Level.FINEST);
  }
  
  public void onDisable() {}
  
  public void registerListeners() {
    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(new GUIInvSetup(), this);
    pm.registerEvents(new GUISetups(), this);
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
