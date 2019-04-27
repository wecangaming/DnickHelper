package de.dnickmc.essentials.effect;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.dnickmc.essentials.others.Perms;
import de.dnickmc.essentials.others.Var;

public class Nightvision implements CommandExecutor{

	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("nachtsicht")|command.getName().equalsIgnoreCase("nightvision")|command.getName().equalsIgnoreCase("ns")){
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission(Perms.nightvision)) {
					if(args.length == 0) {
						if(!(p.hasPotionEffect(PotionEffectType.NIGHT_VISION))) {
							p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 9999999, 3));
							p.sendMessage(Var.Prefix + "§2Du kannst jetzt Nachts besser sehen!");
							console.sendMessage(Var.Prefix + "§2 Der Spieler §f§l" + p.getName() + " §2hat sich den Nachtsichteffekt gegeben!");
							return true;
						} else {
							p.removePotionEffect(PotionEffectType.NIGHT_VISION);
							p.sendMessage(Var.Prefix + "§2Du kannst jetzt Nachts schlechter sehen!");
							console.sendMessage(Var.Prefix + "§2Der Spieler §f§l" + p.getName() + " §2hat sich den Nachtsichteffekt genommen!");
							return true;
						}
					}
					if(args.length == 1) {
						if(p.hasPermission(Perms.nightvision_other) | p.isOp()) {
							Player target = Bukkit.getPlayer(args[0]);
							if(target != null) {
								if(!(target.hasPotionEffect(PotionEffectType.NIGHT_VISION))) {
									target.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 9999999, 3));
									target.sendMessage(Var.Prefix + "§2Du kannst jetzt Nachts besser sehen!");
									p.sendMessage(Var.Prefix + "§f§l" + target.getName() + "§2 kann jetzt Nachts besser sehen");
									console.sendMessage(Var.Prefix + "§2 Der Spieler §f§l" + p.getName() + " §2hat §f§l" + target.getName() + " §2den Nachtsichteffekt gegeben!");
									return true;
								} else {
									target.removePotionEffect(PotionEffectType.NIGHT_VISION);
									target.sendMessage(Var.Prefix + "§2Du kannst jetzt Nachts schlechter sehen!");
									p.sendMessage(Var.Prefix + "§f§l" + target.getName() + "§2 kann jetzt Nachts schlechter sehen");
									console.sendMessage(Var.Prefix + "§2 Der Spieler §f§l" + p.getName() + " §2hat §f§l" + target.getName() + " §2den Nachtsichteffekt genommen!");
									return true;
								}
							} else {
								p.sendMessage(Var.Prefix + "§4 Der Spieler §2§l" + args[0] + "§4 ist nicht auf dem Server!");
							}
						} else if(args.length >= 2){
							p.sendMessage(Var.NO_PERMS);
						}
					} else {
					p.sendMessage(Var.NIGHTVISION_SYNTAX_ERROR);
					}
				}
			} else {
				if(args.length == 0) {
					console.sendMessage(Var.Prefix + "§4Bitte gebe ein Spieler an, den du die Nachtsicht geben willst!");
				} else if(args.length >= 1) {
					Player target = Bukkit.getPlayer(args[0]);
					
					if(target != null) {
						if(!(target.hasPotionEffect(PotionEffectType.NIGHT_VISION))) {
							target.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,9999999, 3));
							target.sendMessage(Var.Prefix + "§2Die Console hat dir den Nachtsichteffekt gegeben!");
							console.sendMessage(Var.Prefix + "§2Der Spieler §f§l" + args[0] + " §2hat jetzt den Nachtsichteffekt!");
						} else {
							target.removePotionEffect(PotionEffectType.NIGHT_VISION);
							target.sendMessage(Var.Prefix + "§2Die Console hat dir den Nachtsichteffekt genommen!");
							console.sendMessage(Var.Prefix + "§2Der Spieler §f§l" + args[0] + " §2hat jetzt den Nachtsichteffekt nicht mehr!");
						}
					} else {
						console.sendMessage(Var.Prefix + "§4Der Spieler §f§l" + args[0] + " §4ist nicht auf dem Server!");
					}
				}
			}
		}
		return false;
	}
}