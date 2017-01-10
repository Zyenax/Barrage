package net.barrage.main;

import net.barrage.main.SQL.SQLBarrageCoins;
import net.barrage.main.SQL.SQLBarrageDeaths;
import net.barrage.main.SQL.SQLBarrageKills;
import net.barrage.main.SQL.SQLBarrageKits;
import net.barrage.main.SQL.SQLBarrageLevels;
import net.barrage.main.SQL.SQLBarrageMeteorites;
import net.barrage.main.handlers.TeamHandler;
import net.necrocore.main.utils.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener{
	
	@SuppressWarnings("unused")
	private Barrage plugin;
	public PlayerQuit(Barrage listener) {
		this.plugin = listener;		
	}
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
	if(TeamHandler.Red.containsKey(p)){
		TeamHandler.Red.remove(p);
		e.setQuitMessage(Utils.color("&8[&c-&8] &c" + p.getName()));
	}else if(TeamHandler.Blue.containsKey(p)){
		TeamHandler.Blue.remove(p);
		e.setQuitMessage(Utils.color("&8[&c-&8] &9" + p.getName()));
	}
	}
	
	@EventHandler
	public void onQuitSQL(PlayerQuitEvent e){
		//SAVE THE PLAYERS COINS TO SQL AFTER THEY LEAVE
		if(SQLBarrageCoins.COINS.containsKey(e.getPlayer().getUniqueId())){
			SQLBarrageCoins.savePlayer(e.getPlayer());
		}
		
		
		//SAVE THE PLAYERS METEORITES TO SQL AFTER THEY LEAVE
		if(SQLBarrageMeteorites.meteorites.containsKey(e.getPlayer().getUniqueId())){
			SQLBarrageMeteorites.savePlayer(e.getPlayer());
		}
		
		//SAVE THE PLAYERS KITS TO SQL AFTER THEY LEAVE
		SQLBarrageKits.savePlayer(e.getPlayer());
		
		
		//SAVE THE PLAYERS LEVEL,XP, AND XPNEEDED TO SQL AFTER THEY LEAVE
		if(SQLBarrageLevels.levels.containsKey(e.getPlayer().getUniqueId())){
			SQLBarrageLevels.savePlayer(e.getPlayer());
		}
		
		
		//SAVE THE PLAYERS KILLS TO SQL AFTER THEY LEAVE
		if(SQLBarrageKills.Kills.containsKey(e.getPlayer().getUniqueId())){
			SQLBarrageKills.savePlayer(e.getPlayer());
		}
		
		
		//SAVE THE PLAYERS DEATHS TO SQL AFTER THEY LEAVE
		if(SQLBarrageDeaths.Deaths.containsKey(e.getPlayer().getUniqueId())){
			SQLBarrageDeaths.savePlayer(e.getPlayer());
		}
	}
}
