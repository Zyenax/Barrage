package net.barrage.main.handlers;

import net.barrage.main.Barrage;
import net.barrage.main.SQL.SQLBarrageLevels;
import net.necrocore.main.SQL.SQLRanks;
import net.necrocore.main.utils.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatHandler implements Listener{

	@SuppressWarnings("unused")
	private static Barrage plugin;

	public ChatHandler(Barrage hub) {
		ChatHandler.plugin = hub;
	}
	
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(TeamHandler.Blue.containsKey(p)){
			e.setFormat(Utils.color("&8&l[&e" + SQLBarrageLevels.getLevel(p) + "&8&l] " + "&8&l[" + TeamHandler.getTeamColor(p) + TeamHandler.getTeam(p) + "&8&l] " + SQLRanks.getRankColor(p) + SQLRanks.getRank(p) + " " + p.getName() + " &r") + e.getMessage());
		}else if(TeamHandler.Red.containsKey(p)){
			e.setFormat(Utils.color("&8&l[&e" + SQLBarrageLevels.getLevel(p) + "&8&l] " + "&8&l[" + TeamHandler.getTeamColor(p) + TeamHandler.getTeam(p) + "&8&l] " + SQLRanks.getRankColor(p) + SQLRanks.getRank(p) + " " + p.getName() + " &r") + e.getMessage());
		}
	}

}
