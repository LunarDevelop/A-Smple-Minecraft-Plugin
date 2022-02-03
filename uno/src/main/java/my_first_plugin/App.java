package my_first_plugin;

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
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    @Override
    public void onEnable() {
        getLogger().info("Hello, SpigotMC!");

        CommandGui gui = new CommandGui();

        this.getCommand("kit").setExecutor(new CommandKit());
        this.getCommand("gui").setExecutor(gui);

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(gui, this);
    }
    
    @Override
    public void onDisable() {
        getLogger().info("See you again, SpigotMC!");
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        getLogger().info("Player " + event.getPlayer().getName() + " is logging in!");
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        getLogger().info("Player " + event.getPlayer().getName() + " is quitting the server!");
    }
}