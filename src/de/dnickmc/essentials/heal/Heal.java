package de.dnickmc.essentials.heal;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.dnickmc.essentials.others.Perms;
import de.dnickmc.essentials.others.Var;

public class Heal implements CommandExecutor {

	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("heal")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission(Perms.heal)) {
					if(args.length == 0) {
						p.setHealth(20);
						p.setFoodLevel(20);
						p.setFallDistance(0);
						p.setFireTicks(0);
						p.sendMessage(Var.Prefix + "§2Du bist wieder Gesund!");
						return true;
					}
					if(args.length == 1) {
						if(p.hasPermission(Perms.heal_other)) {
							Player target = Bukkit.getPlayer(args[0]);
							if(target != null) {
								target.setHealth(20);
								target.setFoodLevel(20);
								target.setFallDistance(0);
								target.setFireTicks(0);
								target.sendMessage(Var.Prefix + "§2Du wurdest von jemanden geheilt!");
								p.sendMessage(Var.Prefix + "§2Du hast §f" + args[0] + "§2 geheilt!");
							} else {
								p.sendMessage(Var.Prefix + "§4 Der Spieler §2" + args[0] + "§4 ist nicht auf dem Server!");
							}
						} else {
							p.sendMessage(Var.NO_PERMS);
						}
					} else {
					p.sendMessage(Var.Prefix + "§4Bitte benutze nur /heal [Spieler]");
					return true;
					}					
				} else {
					p.sendMessage(Var.NO_PERMS);
				}
			} else {
				if(args.length == 0) {
					console.sendMessage(Var.Prefix + "§4Bitte gebe noch einen Spieler an, um jemanden auf dem Server zu heilen.");
				} else if(args.length >= 1) {
					Player target = Bukkit.getPlayer(args[0]);
					
					if(target != null) {
						target.setHealth(20);
						target.setFoodLevel(20);
						target.sendMessage(Var.Prefix + "§2Die Console hat dich geheilt!");
						console.sendMessage(Var.Prefix + args[0] + " §2wurde geheilt!");
					} else {
						console.sendMessage(Var.Prefix + "§4Der Spieler §f" + args[0] +  "§4 ist nicht Online!");
					}
				}
			}
		}
		return false;
	}
}
