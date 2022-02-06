package my_first_plugin;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class App extends JavaPlugin implements Listener
{
    private static final Logger log = Logger.getLogger("Minecraft");
    public File file;
    public FileConfiguration config;

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    @Override
    public void onEnable() {
        String[] WelcomeMsg = {
            "Solar's first plugin has been enabled",
            "This plugin is mainly for testing and learning Bukkit plugins"
        };

        file = new File(getDataFolder(), "config.yml");
        config = new YamlConfiguration();

        saveDefaultConfig();

        for (String string : WelcomeMsg) {
            getLogger().info(string);
        }

        CommandGui gui = new CommandGui();

        this.getCommand("kit").setExecutor(new CommandKit());
        this.getCommand("gui").setExecutor(gui);
        this.getCommand("playerinfo").setExecutor(new CommandInfo());
        this.getCommand("fly").setExecutor(new CommandFly());
        this.getCommand("flyspeed").setExecutor(new CommandFlySpeed());

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(gui, this);
    }
    
    @Override
    public void onDisable() {
        getLogger().info("See you again, SpigotMC!");
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        log.info("Player " + event.getPlayer().getName() + " is logging in!");
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        log.info("Player " + event.getPlayer().getName() + " is quitting the server!");
    }

}