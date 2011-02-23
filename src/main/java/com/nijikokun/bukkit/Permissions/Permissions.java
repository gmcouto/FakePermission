package com.nijikokun.bukkit.Permissions;

import com.nijiko.Misc;
import com.nijiko.configuration.DefaultConfiguration;
import com.nijiko.permissions.Control;
import com.nijiko.permissions.PermissionHandler;
import java.io.File;
import java.util.logging.Logger;
import org.anjocaido.groupmanager.GroupManager;
import org.bukkit.Server;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;

public class Permissions extends JavaPlugin {

    private class Listener extends PlayerListener {

        private Permissions plugin;

        public Listener(Permissions plugin) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        public void onPlayerCommand(PlayerChatEvent event) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }
    public static final Logger log = Logger.getLogger("Fake Permissions");
    public static String name = "Permissions";
    public static String codename = "Hacked Permissions by AnjoCaido";
    public static String version = "2.0";
    public static PermissionHandler Security = new Control(null);
    public static Misc Misc = new Misc();
    public static Server Server;
    private Listener Listener = null;
    private DefaultConfiguration config = null;
    private GroupManager groupManager;

    public Permissions(PluginLoader pluginLoader, Server instance, PluginDescriptionFile desc, File folder, File plugin, ClassLoader cLoader) {
        super(pluginLoader, instance, desc, folder, plugin, cLoader);
        Server = this.getServer();
        Plugin p = this.getServer().getPluginManager().getPlugin("GroupManager");
        if (p != null) {
            if (!this.getServer().getPluginManager().isPluginEnabled(p)) {
                try {
                    this.getServer().getPluginManager().enablePlugin(p);
                    this.getServer().getPluginManager().enablePlugin(this);
                } catch (Exception e) {
                }
            }
        } else {
            File[] listFiles = this.getDataFolder().getParentFile().listFiles();
            for (File f : listFiles) {
                if (f.getName().equalsIgnoreCase("GroupManager.jar")) {
                    try {
                        this.getServer().getPluginManager().loadPlugin(f);
                        this.getServer().getPluginManager().enablePlugin(this);
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    public void onDisable() {
        //compiled code
        //throw new RuntimeException("Compiled Code");
        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println("Fake " + pdfFile.getName() + " version " + pdfFile.getVersion() + " is disabled!");
    }

    public void onEnable() {
        //compiled code
        Server = this.getServer();
        Plugin p = this.getServer().getPluginManager().getPlugin("GroupManager");
        PluginDescriptionFile pdfFile = this.getDescription();
        if (p != null) {
            if (!this.getServer().getPluginManager().isPluginEnabled(p)) {
                this.getServer().getPluginManager().enablePlugin(p);
            }
            GroupManager gm = (GroupManager) p;
            groupManager = gm;
            Security = gm.getPermissionHandler();
            // EXAMPLE: Custom code, here we just output some info so we can check all is well         
            System.out.println("Fake " + pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
        } else {
            System.err.println("OOOPS! Fake " + pdfFile.getName() + " version " + pdfFile.getVersion() + " couldn't find GroupManager!");
            this.getPluginLoader().disablePlugin(this);
        }
    }

    private void registerEvents() {
        //compiled code
        //throw new RuntimeException("Compiled Code");
    }

    public PermissionHandler getHandler() {
        //compiled code
        //throw new RuntimeException("Compiled Code");
        //System.out.println("Alguem chamou o handler");
        checkEnable();
        return Security;
    }

    public void setupPermissions() {
        checkEnable();
    }

    private void checkEnable() {
        if (!this.isEnabled()) {
            this.getServer().getPluginManager().enablePlugin(this);
        }
    }
}
