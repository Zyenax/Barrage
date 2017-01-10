package net.barrage.main.handlers;

import net.barrage.main.Barrage;
import net.barrage.main.SQL.SQLBarrageLevels;
import net.necrocore.main.SQL.SQLRanks;
import net.necrocore.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class NameUpdater implements Listener{
	
	private Barrage plugin;
	public NameUpdater(Barrage listener) {
		this.plugin = listener;
		updateNames();
	}
	
	public void updateNames(){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
    		public void run() {
    			for(Player p : Bukkit.getOnlinePlayers()){
    				if(p != null){
    					if(TeamHandler.Blue.containsKey(p)){
    						Utils.setTag(p, Utils.color("&8[&e" + SQLBarrageLevels.getLevel(p) + "&8] &9"));
    						p.setPlayerListName(Utils.color("&8&l[&e" + SQLBarrageLevels.getLevel(p) + "&8&l] " + "&8&l[" + TeamHandler.getTeamColor(p) + TeamHandler.getTeam(p) + "&8&l] " + SQLRanks.getRankColor(p) + SQLRanks.getRank(p) + " " + p.getName()));
    					}else if(TeamHandler.Red.containsKey(p)){
    						Utils.setTag(p, Utils.color("&8[&e" + SQLBarrageLevels.getLevel(p) + "&8] &c"));
    						p.setPlayerListName(Utils.color("&8&l[&e" + SQLBarrageLevels.getLevel(p) + "&8&l] " + "&8&l[" + TeamHandler.getTeamColor(p) + TeamHandler.getTeam(p) + "&8&l] " + SQLRanks.getRankColor(p) + SQLRanks.getRank(p) + " " + p.getName()));
    					}
    				}
    			}
    		}
		}, 0, 1 * 20);
	}

}
