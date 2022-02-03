package my_first_plugin;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class App extends JavaPlugin
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    @Override
    public void onEnable() {
        getLogger().info("Hello, SpigotMC!");
        this.getCommand("kit").setExecutor(new CommandKit());
    }
    @Override
    public void onDisable() {
        getLogger().info("See you again, SpigotMC!");
    }
}