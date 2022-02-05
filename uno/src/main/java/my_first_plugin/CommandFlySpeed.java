package my_first_plugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFlySpeed implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player p = (Player) sender;
        try {
            p.setFlySpeed(Integer.parseInt(args[0]);

            p.sendMessage("Your flight speed is now set to: " +  args[0]);
        }
        catch (Exception e) {
            p.sendMessage("You need to enter a speed you wish to have, it must be a number");
        }
        return true;
    }
}