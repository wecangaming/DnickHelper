package de.dnickmc.essentials;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.dnickmc.essentials.effect.Nightvision;
import de.dnickmc.essentials.gamemode.Gamemode;
import de.dnickmc.essentials.heal.Feed;
import de.dnickmc.essentials.heal.Heal;
import de.dnickmc.essentials.others.Var;
import de.dnickmc.essentials.time.Day;

public class Main extends JavaPlugin implements Listener{
	
	public ConsoleCommandSender console = getServer().getConsoleSender();
	
	@Override
	public void onEnable() {
		console.sendMessage(Var.Prefix + "§2Das Plugin wird gestartet!");
		
		
		this.getCommand("0").setExecutor(new Gamemode());
		this.getCommand("1").setExecutor(new Gamemode());
		this.getCommand("2").setExecutor(new Gamemode());
		this.getCommand("3").setExecutor(new Gamemode());
		this.getCommand("ns").setExecutor(new Nightvision());
		this.getCommand("nachtsicht").setExecutor(new Nightvision());
		this.getCommand("nightvision").setExecutor(new Nightvision());
		this.getCommand("heal").setExecutor(new Heal());
		this.getCommand("feed").setExecutor(new Feed());
		this.getCommand("tag").setExecutor(new Day());
		this.getCommand("day").setExecutor(new Day());
	}

	@Override
	public void onDisable() {
		console.sendMessage(Var.Prefix + "§2Das Plugin wird gestoppt!");
	}
}
