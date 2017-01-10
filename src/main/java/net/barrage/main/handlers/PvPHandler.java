package net.barrage.main.handlers;

import net.barrage.main.Barrage;
import net.barrage.main.SQL.SQLBarrageCoins;
import net.barrage.main.SQL.SQLBarrageDeaths;
import net.barrage.main.SQL.SQLBarrageKills;
import net.barrage.main.SQL.SQLBarrageLevels;
import net.necrocore.main.SQL.SQLNetworkLevels;
import net.necrocore.main.SQL.SQLShards;
import net.necrocore.main.utils.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PvPHandler implements Listener{
	
	@SuppressWarnings("unused")
	private Barrage plugin;
	public PvPHandler(Barrage listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void entityDamage(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			Player player = (Player) e.getEntity();
			Player damager = (Player) e.getDamager();
				if(TeamHandler.Blue.containsKey(player) && TeamHandler.Blue.containsKey(damager)){
					e.setCancelled(true);
					damager.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &eYou may not harm your own team members!"));
				}else if(TeamHandler.Red.containsKey(player) && TeamHandler.Red.containsKey(damager)){
					e.setCancelled(true);
					damager.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &eYou may not harm your own team members!"));
				}else{
					player.sendMessage(Utils.color("&eYou have been damaged by &a" + damager.getName() + " &efor " + ((int)damager.getLastDamage()) + " &ehearts!"));
					damager.sendMessage(Utils.color("&eYou have damaged &a" + player.getName() + " &efor " + ((int)damager.getLastDamage()) + " &ehearts!"));
				}
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		if(e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player){
			Player player = e.getEntity();
			Player killer = e.getEntity().getKiller();
			Integer shardamount = Utils.randomNum(0, 1);
			Integer xpamount = Utils.randomNum(1, 4);
			Integer networkxpamount = Utils.randomNum(0, 1);
			Integer coinamount = Utils.randomNum(1, 5);
			Integer killamount = 1;
			Integer deathamount = 1;
			SQLBarrageCoins.addCoins(killer, coinamount);
			SQLBarrageLevels.addXP(killer, xpamount);
			SQLBarrageKills.addKills(killer, killamount);
			SQLBarrageDeaths.addDeaths(player, deathamount);
			SQLNetworkLevels.addXP(killer, networkxpamount);
			SQLShards.addShards(killer, shardamount);
			if(TeamHandler.Red.containsKey(player)){
				player.spigot().respawn();
				//Location loc = new Location(Bukkit.getWorld("GAME"), -22.5, 52, -99.5, 0, 0);
				//player.teleport(loc);
			}else if(TeamHandler.Blue.containsKey(player)){
				player.spigot().respawn();
				//Location loc = new Location(Bukkit.getWorld("GAME"), -22.5, 52, 86.5, 180, 0);
				//player.teleport(loc);
			}
		}
	}
	
}
