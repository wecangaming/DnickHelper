package de.dnickmc.essentials;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import de.dnickmc.essentials.effect.Nightvision;
import de.dnickmc.essentials.gamemode.Gamemode;
import de.dnickmc.essentials.heal.Feed;
import de.dnickmc.essentials.heal.Heal;
import de.dnickmc.essentials.others.Perms;
import de.dnickmc.essentials.others.Var;
import de.dnickmc.essentials.time.Day;

public class Main extends JavaPlugin implements Listener{
	
	public ConsoleCommandSender console = getServer().getConsoleSender();
	
	@Override
	public void onEnable() {
		console.sendMessage(Var.Prefix + "§2Das Plugin wird gestartet!");
		
		Bukkit.getPluginManager().registerEvents(this, this);
		
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
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onReload(PlayerCommandPreprocessEvent e) {
		
			Player p = e.getPlayer();
			String msg = e.getMessage().split(" ")[0];
			if (msg.equalsIgnoreCase("/reload")) {
				if(p.hasPermission(Perms.reload)|| p.isOp()) {
					e.setCancelled(true);
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage(Var.Prefix + "Der Server wird aufgrund von Änderungen am System in 3 Minuten neugeladen! In der Zeit kann es zu starken Laggs kommen. Bitte sichere deine Items, falls es zu einem Bug kommt.");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					    public void run() {
					    	Bukkit.getServer().setWhitelist(true);
							Bukkit.broadcastMessage("");
							Bukkit.broadcastMessage("");
							Bukkit.broadcastMessage(Var.Prefix + "Der Server wird in 60 Sekunden neugeladen! Bitte sichere deine Items, falls es zu einem Bug kommt!");
							Bukkit.broadcastMessage(Var.Prefix + "Die Whitelist wird für 60 Sekunden aktiviert aufgrund von Server Performance");
							Bukkit.broadcastMessage("");
							Bukkit.broadcastMessage("");
					    }
					}, 20*120);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					    public void run() {
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage(Var.Prefix + "Der Server wird in 10 Sekunden neugeladen! Bitte sichere deine Items, falls es zu einem Bug kommt!");
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage("");
					    }
					}, 20*170);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					    public void run() {
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage(Var.Prefix + "Der Server wird in 5 Sekunden neugeladen! Bitte sichere deine Items, falls es zu einem Bug kommt!");
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage("");
					    }
					}, 20*175);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					    public void run() {
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage(Var.Prefix + "Der Server wird in 4 Sekunden neugeladen! Bitte sichere deine Items, falls es zu einem Bug kommt!");
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage("");
					    }
					}, 20*176);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					    public void run() {
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage(Var.Prefix + "Der Server wird in 3 Sekunden neugeladen! Bitte sichere deine Items, falls es zu einem Bug kommt!");
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage("");
					    }
					}, 20*177);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					    public void run() {
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage(Var.Prefix + "Der Server wird in 2 Sekunden neugeladen! Bitte sichere deine Items, falls es zu einem Bug kommt!");
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage("");
					    }
					}, 20*178);

					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					    public void run() {
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage(Var.Prefix + "Der Server wird in 1 Sekunden neugeladen! Bitte sichere deine Items, falls es zu einem Bug kommt!");
					    	Bukkit.broadcastMessage("");
					    	Bukkit.broadcastMessage("");
					    }
					}, 20*179);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					    public void run() {
							Bukkit.reload();

							Bukkit.getServer().setWhitelist(false);
							Bukkit.broadcastMessage("");
							Bukkit.broadcastMessage("");
							Bukkit.broadcastMessage(Var.Prefix + "Der Server wurde neugeladen! Einige Einstellungen wurden übernommen!");
							Bukkit.broadcastMessage(Var.Prefix + "Die Whitelist wird deaktiviert!");
							Bukkit.broadcastMessage("");
							Bukkit.broadcastMessage("");
					    }
					}, 20*180);
				}
			
			} else if(msg.equalsIgnoreCase("/clear")) {
				if(p.hasPermission(Perms.clear)) {
					p.getInventory().clear();
					p.sendMessage(Var.Prefix + "Dein Inventar wurde geleert!");
				}
			}
		
	}
}
