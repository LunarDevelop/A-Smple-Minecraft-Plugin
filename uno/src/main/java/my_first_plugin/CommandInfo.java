package my_first_plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandInfo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player p;

        if (args.length > 0) {
            p = Bukkit.getPlayer(args[0]);
            if (p == null) {
                sender.sendMessage(ChatColor.BLUE+"This user is not logged onto the server or doesn't exist");
                return true;
            }
        }
        else {
            p = (Player) sender;
        }

        Location location = (Location) p.getLocation();

        String[] lines = {
            ChatColor.GOLD + "============================================",
            "Name: " + p.getDisplayName(),
            "UUID: " + p.getUniqueId(),
            "Ping: " + p.getPing() +" || Locale: " + p.getLocale(),
            "Exp: " + p.getExp() + " || Level: " + p.getLevel(),
            "Location: " + (int) location.getX() + ", " + (int) location.getY() + ", " + (int) location.getZ(),
            "Flight Allowed: " + p.getAllowFlight(),
        };

        p.sendMessage(lines);
        p.playSound(p.getLocation(), Sound.ENTITY_SPLASH_POTION_BREAK, 2, 2);

        return true;
    }
    
}
