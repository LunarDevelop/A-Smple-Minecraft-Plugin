package my_first_plugin;
import org.bukkit.Bukkit;
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
            int num = Integer.parseInt(args[0]);
            if (num < 0 || num > 100) {
                p.sendMessage("You need to enter a speed you wish to have, it must be a number between 1 and 100");
                return true;
            }

            float speed = ((float) num / 100F);
            p.setFlySpeed(speed);

            p.sendMessage("Your flight speed is now set to: " +  ((int) (speed * 100)) + "%");
        }
        catch (Exception e) {
            p.sendMessage("You need to enter a speed you wish to have, it must be a number between 1 and 100");
            Bukkit.getLogger().warning("Excption: " + e);;
        }
        return true;
    }
}