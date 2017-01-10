package net.barrage.main;

import net.barrage.main.SQL.SQLBarrageCoins;
import net.barrage.main.SQL.SQLBarrageDeaths;
import net.barrage.main.SQL.SQLBarrageKills;
import net.barrage.main.SQL.SQLBarrageKits;
import net.barrage.main.SQL.SQLBarrageLevels;
import net.barrage.main.SQL.SQLBarrageMeteorites;
import net.barrage.main.handlers.ScoreBoardHandler;
import net.barrage.main.handlers.TeamHandler;
import net.necrocore.main.SQL.SQLRanks;
import net.necrocore.main.utils.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener{
	
	@SuppressWarnings("unused")
	private Barrage plugin;
	public PlayerJoin(Barrage listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = (Player) e.getPlayer();
		TeamHandler.addToTeam(p);
    	if(TeamHandler.Blue.containsKey(p)){
    		Utils.setTag(p, Utils.color("&9"));
    		p.setPlayerListName(Utils.color("&8&l[&e" + SQLBarrageLevels.getLevel(p) + "&8&l] " + SQLRanks.getRankColor(p) + SQLRanks.getRank(p) + " &9" + p.getName()));
    		e.setJoinMessage(Utils.color("&8[&a+&8] &9" + p.getName()));
    	}else if(TeamHandler.Red.containsKey(p)){
    		Utils.setTag(p, Utils.color("&c"));
    		p.setPlayerListName(Utils.color("&8&l[&e" + SQLBarrageLevels.getLevel(p) + "&8&l] " + SQLRanks.getRankColor(p) + SQLRanks.getRank(p) + " &c" + p.getName()));
    		e.setJoinMessage(Utils.color("&8[&a+&8] &c" + p.getName()));
    	}
	}
	
	
	@EventHandler
	public void onJoinSQL(PlayerJoinEvent e){
		final Player p = (Player) e.getPlayer();
		//IF THEY HAVENT JOINED BEFORE PUT THEIR COINS TO 0 AND ADD THEM TO SQL
		if(SQLBarrageCoins.getCoins(p) == null){
			SQLBarrageCoins.setCoins(p, 0);
		}
		//LOAD THE PLAYERS COINS FROM THE DATABASE
		SQLBarrageCoins.loadPlayer(p);
		
		
		//IF THEY HAVENT JOINED BEFORE PUT THEIR METEORITES TO 0 AND ADD THEM TO SQL
		if(SQLBarrageMeteorites.getMeteorites(p) == null){
			SQLBarrageMeteorites.setMeteorites(p, 0);
		}
		//LOAD THE PLAYERS METEORITES FROM THE DATABASE
		SQLBarrageMeteorites.loadPlayer(p);
		
		
		//IF THEY HAVENT JOINED BEFORE PUT THEIR KILLS TO 0 AND ADD THEM TO SQL
		if(SQLBarrageKills.getKills(p) == null){
			SQLBarrageKills.setKills(p, 0);
		}
		//LOAD THE PLAYERS KILLS FROM THE DATABASE
		SQLBarrageKills.loadPlayer(p);
		
		
			//IF THEY HAVENT JOINED BEFORE PUT THEIR DEATHS TO 0 AND ADD THEM TO SQL
			if(SQLBarrageDeaths.getDeaths(p) == null){
				SQLBarrageDeaths.setDeaths(p, 0);
			}
			//LOAD THE PLAYERS DEATHS FROM THE DATABASE
			SQLBarrageDeaths.loadPlayer(p);
		
		
			//IF THEY HAVENT JOINED BEFORE PUT THEIR LEVEL TO 1 AND ADD THEM TO SQL
			if(SQLBarrageLevels.getLevel(p) == null){
				SQLBarrageLevels.setLevel(p, 1);
			}
		
		
			//IF THEY HAVENT JOINED BEFORE PUT THEIR XP TO 0 AND ADD THEM TO SQL
				if(SQLBarrageLevels.getXP(p) == null){
					SQLBarrageLevels.setXP(p, 0);
				}
		
			//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT1 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit1(p) == null){
					SQLBarrageKits.setKit1(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT2 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit2(p) == null){
					SQLBarrageKits.setKit2(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT3 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit3(p) == null){
					SQLBarrageKits.setKit3(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT4 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit4(p) == null){
					SQLBarrageKits.setKit4(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT5 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit5(p) == null){
					SQLBarrageKits.setKit5(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT6 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit6(p) == null){
					SQLBarrageKits.setKit6(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT7 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit7(p) == null){
					SQLBarrageKits.setKit7(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT8 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit8(p) == null){
					SQLBarrageKits.setKit8(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT9 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit9(p) == null){
					SQLBarrageKits.setKit9(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT10 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit10(p) == null){
					SQLBarrageKits.setKit10(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT11 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit11(p) == null){
					SQLBarrageKits.setKit11(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT12 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit12(p) == null){
					SQLBarrageKits.setKit12(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT13 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit13(p) == null){
					SQLBarrageKits.setKit13(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT14 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit14(p) == null){
					SQLBarrageKits.setKit14(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT15 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit15(p) == null){
					SQLBarrageKits.setKit15(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT16 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit16(p) == null){
					SQLBarrageKits.setKit16(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT17 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit17(p) == null){
					SQLBarrageKits.setKit17(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT18 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit18(p) == null){
					SQLBarrageKits.setKit18(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT19 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit19(p) == null){
					SQLBarrageKits.setKit19(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT20 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit20(p) == null){
					SQLBarrageKits.setKit20(p, "false");
				}
				
				//IF THEY HAVENT JOINED BEFORE PUT THEIR KIT21 TO "false" AND ADD THEM TO SQL
				if(SQLBarrageKits.getKit21(p) == null){
					SQLBarrageKits.setKit21(p, "false");
				}
				//LOAD THE PLAYERS KITS FROM THE DATABASE
				SQLBarrageKits.loadPlayer(p);
		
		
		//IF THEY HAVENT JOINED BEFORE PUT THEIR NEEDEDXP TO THE AMOUNT NEEDED FOR LEVEL 1 AND THEN ADD THEM TO SQL
		if(SQLBarrageLevels.getXPNeeded(p) == null){
			SQLBarrageLevels.setXPNeeded(p, SQLBarrageLevels.getXPNeededForLevel(SQLBarrageLevels.getLevel(p)));
		}
		//LOAD THE PLAYERS LEVEL,XP, AND XPNEEDED FROM THE DATABASE
		SQLBarrageLevels.loadPlayer(p);
		ScoreBoardHandler.makeScoreBoard(p);
	}
}
