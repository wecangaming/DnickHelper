package de.dnickmc.essentials.time;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.dnickmc.essentials.others.Var;

public class Day implements CommandExecutor {

	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.getName().equalsIgnoreCase("tag") |sender.getName().equalsIgnoreCase("day")) {
			if(sender instanceof Player ) {
				Player p = (Player)sender;
				
				if(p.hasPermission("dnick.time")) {
					if(args.length == 0) {
						p.getWorld().setTime(0);
						p.sendMessage(Var.Prefix + "§2Die Zeit wurde auf Tag gestellt!");
						Bukkit.broadcastMessage(Var.Prefix + "§f§l" + p.getCustomName() + " §2hat die Zeit auf Tag gestellt!");
					}
				}
			} else {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "time set 0");
				console.sendMessage(Var.Prefix + "§2Du hast die Zeit auf Tag gestellt!");
			}
			
		}
		return false;
	}
}
