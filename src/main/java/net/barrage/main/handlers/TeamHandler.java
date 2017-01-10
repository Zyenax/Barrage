package net.barrage.main.handlers;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import net.barrage.main.Barrage;
import net.necrocore.main.utils.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TeamHandler implements Listener{
	
	@SuppressWarnings("unused")
	private Barrage plugin;
	public TeamHandler(Barrage listener) {
		this.plugin = listener;		
	}
	
	static Random random = new Random();
	public static HashMap<Player, UUID> Blue = new HashMap<Player, UUID>();
	public static HashMap<Player, UUID> Red = new HashMap<Player, UUID>();
	
	public static String getTeamColor(Player p){
		if(Blue.containsKey(p)){
			return "&9&l";
		}else if (Red.containsKey(p)){
			return "&c&l";
		}
		return null;
	}
	
	public static String getTeam(Player p){
		if(Blue.containsKey(p)){
			return "BLUE";
		}else if (Red.containsKey(p)){
			return "RED";
		}
		return null;
	}
	
	public static void addToTeam(Player p) {
	    if (Red.size() == Blue.size()) {
	        if (random.nextBoolean()) {
	            Red.put(p, p.getUniqueId());
	            p.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &eYou have been added to the &c&lRED &eteam!"));
	        } else {
	        	Blue.put(p, p.getUniqueId());
	        	p.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &eYou have been added to the &9&lBLUE &eteam!"));
	        }
	    } else {
	        if (Red.size() < Blue.size()) {
	        	Red.put(p, p.getUniqueId());
	        	p.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &eYou have been added to the &c&lRED &eteam!"));
	        } else {
	        	Blue.put(p, p.getUniqueId());
	        	p.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &eYou have been added to the &9&lBLUE &eteam!"));
	        }
	    }
	}

}
