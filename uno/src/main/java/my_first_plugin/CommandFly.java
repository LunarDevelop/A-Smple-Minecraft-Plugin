package my_first_plugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player p = (Player) sender;
        boolean FlyBool = p.getAllowFlight();
        p.setAllowFlight(!FlyBool);
        p.setFlying(!FlyBool);

        p.sendMessage("Your flight mode is now set to: " + !FlyBool );

        return true;
    }
}