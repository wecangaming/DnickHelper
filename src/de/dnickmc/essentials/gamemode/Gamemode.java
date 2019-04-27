package de.dnickmc.essentials.gamemode;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.dnickmc.essentials.others.Perms;
import de.dnickmc.essentials.others.Var;

public class Gamemode implements CommandExecutor{
	
	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("2")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission(Perms.gamemode)) {
					if(args.length == 0) {
						
						p.setGameMode(GameMode.ADVENTURE);
						console.sendMessage(Var.Prefix + "§f" + p.getName() + " §2ist im §9Adventuremode§2!");
						p.sendMessage(Var.Prefix + "§2Neuer Gamemode: §9Adventuremode!");
						return true;
						
						} else if (args.length >= 1) {
						
							Player target = Bukkit.getPlayer(args[0]);
							if(target != null) {
								
							target.setGameMode(GameMode.CREATIVE);
							console.sendMessage(Var.Prefix + "§f" + p.getName() + " §2ist im §9Adventuremode §2durch §f" + p.getName() + "§2 gesetzt wurden.");
							target.sendMessage(Var.Prefix + "§2Du wurdest in den §9Adventuremode §2 gesetzt!");
							p.sendMessage(Var.Prefix + "§2Du hast" + target.getName() +" §9Adventuremode!");
							return true;
							} else {
								p.sendMessage(Var.Prefix + "§4 Der Spieler §2" + args[0] + "§4 ist nicht auf dem Server!");
						}
					} else {
						p.sendMessage(Var.Prefix + "§4Nutze bitte nur §5/2 [Spieler]§4!");
					}
				} else {
					p.sendMessage(Var.NO_PERMS);
				}
			} else {
				if(args.length == 0) {
					console.sendMessage(Var.Prefix + "§4Bitte gebe ein Spieler an!");
				} else if (args.length >= 1) {
					Player target = Bukkit.getPlayer(args[0]);
					
					if(target != null) {
						target.setGameMode(GameMode.ADVENTURE);
						console.sendMessage(Var.Prefix + target.getName() + "§2 wurde in den §9Adventuremode §2durch die Console gesetzt!");
						target.sendMessage(Var.Prefix + "§2Die Console hat dich in §9Adventuremode §2gesetzt!");
						return true;
					} else {
						console.sendMessage(Var.Prefix + "§4Der Spieler §2" + args[0] + " §4 ist nicht auf dem Server!");
					}
				}
			}
		}
		if(command.getName().equalsIgnoreCase("1")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission(Perms.gamemode)) {
					if(args.length == 0) {
						
						p.setGameMode(GameMode.CREATIVE);
						console.sendMessage(Var.Prefix + p.getName() + " ist im Kreativemode!");
						p.sendMessage(Var.Prefix+ "§2Neuer Gamemode: §9Kreativemode!");
						return true;
						
						} else if (args.length == 1) {
						
							Player target = Bukkit.getPlayer(args[0]);
							if(target != null) {
								
							target.setGameMode(GameMode.CREATIVE);
							console.sendMessage(Var.Prefix + p.getName() + " ist im Kreativemode durch" +p.getName());
							target.sendMessage(Var.Prefix + "§2Du wurdest in den §9Kreativemode §7 gesetzt!");
							p.sendMessage(Var.Prefix + "§2Du hast" + target.getName() +" §9Kreativemode!");
							return true;
							} else {
								p.sendMessage(Var.Prefix + "§4 Der Spieler §2" + args[0] + "§4 ist nicht auf dem Server!");
						}
					} else {
						p.sendMessage(Var.Prefix + "§4Nutze bitte nur §5/1 [Spieler]§4!");
					}
				} else {
					p.sendMessage(Var.NO_PERMS);
				}
			} else {
				if(args.length == 0) {
					sender.getServer().getConsoleSender().sendMessage(Var.Prefix + "Bitte gebe ein Spieler an!");
				} else if (args.length >= 1) {
					Player target = Bukkit.getPlayer(args[0]);
					
					if(target != null) {
						target.setGameMode(GameMode.CREATIVE);
						console.sendMessage(Var.Prefix + target.getName() + "§2 wurde in den §9Kreativemode §2durch die Console gesetzt!");
						target.sendMessage(Var.Prefix + "§2Die Console hat dich in §9Kreativemode §2gesetzt!");
						return true;
					} else {
						console.sendMessage(Var.Prefix + "§4Der Spieler §2" + args[0] + " §4 ist nicht auf dem Server!");
					}
				}
			}
		}
		if(command.getName().equalsIgnoreCase("3")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission(Perms.gamemode)) {
					if(args.length == 0) {
						
						p.setGameMode(GameMode.SPECTATOR);
						console.sendMessage(Var.Prefix + p.getName() + " ist im Spectatormode!");
						p.sendMessage(Var.Prefix+ "§2Neuer Gamemode: §9Spectatormode!");
						return true;
						
						} else if (args.length >= 1) {
						
							Player target = Bukkit.getPlayer(args[0]);
							if(target != null) {
								
							target.setGameMode(GameMode.SPECTATOR);
							console.sendMessage(Var.Prefix + p.getName() + " ist im Spectatormode durch" +p.getName());
							target.sendMessage(Var.Prefix + "§2Du wurdest in den §9Spectatormode §7 gesetzt!");
							p.sendMessage(Var.Prefix + "§2Du hast" + target.getName() +" §9Spectatormode!");
							return true;
							} else {
								p.sendMessage(Var.Prefix + "§4 Der Spieler §2" + args[0] + "§4 ist nicht auf dem Server!");
						}
					} else {
						p.sendMessage(Var.Prefix + "§4Nutze bitte nur §5/3 [Spieler]§4!");
					}
				} else {
					p.sendMessage(Var.NO_PERMS);
				}
			} else {
				if(args.length == 0) {
					console.sendMessage(Var.Prefix + "Bitte gebe ein Spieler an!");
				} else if (args.length >= 1) {
					Player target = Bukkit.getPlayer(args[0]);
					
					if(target != null) {
						target.setGameMode(GameMode.SPECTATOR);
						console.sendMessage(Var.Prefix + target.getName() + "§2 wurde in den §9Spectatormode§2 durch die Console gesetzt!");
						target.sendMessage(Var.Prefix + "§2Die Console hat dich in §9Spectatormode §2gesetzt!");
						return true;
					} else {
						console.sendMessage(Var.Prefix + "§4Der Spieler §2" + args[0] + " §4 ist nicht auf dem Server!");
					}
				}
			}
		}
		if(command.getName().equalsIgnoreCase("0")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission(Perms.gamemode)) {
					if(args.length >= 0) {
						
						p.setGameMode(GameMode.SURVIVAL);
						console.sendMessage(Var.Prefix + p.getName() + " ist im Überlebensmodus!");
						p.sendMessage(Var.Prefix+ "§2Neuer Gamemode: §9Überlebensmodus!");
						return true;
						
						} else if (args.length == 1) {
						
							Player target = Bukkit.getPlayer(args[0]);
							if(target != null) {
								
							target.setGameMode(GameMode.SURVIVAL);
							console.sendMessage(Var.Prefix + p.getName() + " ist im Überlebensmodus!");
							target.sendMessage(Var.Prefix + "§2Neuer Gamemode: §9Überlebensmodus!");
							p.sendMessage(Var.Prefix + "§2Neuer Gamemode: §9Überlebensmodus!");
							return true;
							} else {
								p.sendMessage(Var.Prefix + "§4 Der Spieler §2" + args[0] + "§4 ist nicht auf dem Server!");
						}
					} else {
						p.sendMessage(Var.Prefix + "§4Nutze bitte nur §5/0 [Spieler]§4!");
					}
				} else {
					p.sendMessage(Var.NO_PERMS);
				}
			} else {
				if(args.length == 0) {
					console.sendMessage(Var.Prefix + "Bitte gebe ein Spieler an!");
				} else if (args.length >= 1) {
					Player target = Bukkit.getPlayer(args[0]);
					
					if(target != null) {
						target.setGameMode(GameMode.SURVIVAL);
						console.sendMessage(Var.Prefix + target.getName() + "§2 wurde in den §9Überlebensmodus §2durch die Console gesetzt!");
						target.sendMessage(Var.Prefix + "§2Die Console hat dich in §9Überlebensmodus §2gesetzt!");
						return true;
					} else {
						console.sendMessage(Var.Prefix + "§4Der Spieler §2" + args[0] + " §4 ist nicht auf dem Server!");
					}
				}
			}
		}
		return false;
	}
	
	

}
