package net.barrage.main;

import java.sql.PreparedStatement;

import net.barrage.main.SQL.SQLBarrageCoins;
import net.barrage.main.SQL.SQLBarrageDeaths;
import net.barrage.main.SQL.SQLBarrageKills;
import net.barrage.main.SQL.SQLBarrageKits;
import net.barrage.main.SQL.SQLBarrageLevels;
import net.barrage.main.SQL.SQLBarrageMeteorites;
import net.barrage.main.commands.CoinCommand;
import net.barrage.main.commands.LevelCommand;
import net.barrage.main.commands.MeteoriteCommand;
import net.barrage.main.commands.XPCommand;
import net.barrage.main.handlers.BuildHandler;
import net.barrage.main.handlers.ChatHandler;
import net.barrage.main.handlers.MOTDHandler;
import net.barrage.main.handlers.NameUpdater;
import net.barrage.main.handlers.PvPHandler;
import net.barrage.main.handlers.ScoreBoardHandler;
import net.barrage.main.handlers.TeamHandler;
import net.necrocore.main.NecroCore;
import net.necrocore.main.SQL.SQL;
import net.necrocore.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Barrage extends JavaPlugin implements Listener{

	public static SQL mysql;
	private static Barrage instance;
	public static String name = Utils.color("&8&l[&c&lBarrage&8&l] ");
	
	
	public void onEnable(){
		registerListeners();
		registerCommands();
		NecroCore.useCoreChat = false;
		instance = this;
		NecroCore.useCoreTabAndTag = false;
	    ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(Utils.color(name + "&aBarrage plugin has been enabled!"));
		connectMySQL();
		for(Player p : Bukkit.getOnlinePlayers()){
			SQLBarrageCoins.loadPlayer(p);
			SQLBarrageLevels.loadPlayer(p);
			SQLBarrageMeteorites.loadPlayer(p);
		}
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
    		public void run() {
    			if(Bukkit.getPluginManager().getPlugin("NecroCore") == null){
    				Bukkit.getServer().broadcastMessage(Utils.color(name + "&4&lFATAL: &cNecroCore plugin not found some features WILL NOT work on the server please add NecroCore to the servers plugin folder or notify an [Admin]"));
    			}
    		}
    	}, 20);
	}
	
	public void onDisable(){
		SQLBarrageCoins.onDisableSavePlayer();
		SQLBarrageLevels.onDisableSavePlayer();
		SQLBarrageMeteorites.onDisableSavePlayer();
		SQLBarrageKits.onDisableSavePlayer();
		SQLBarrageKills.onDisableSavePlayer();
		SQLBarrageDeaths.onDisableSavePlayer();
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(Utils.color(name + "&cBarrage plugin has been disabled!"));
	}
	
	public void registerListeners(){
		PluginManager manager = Bukkit.getServer().getPluginManager();
		manager.registerEvents(new PlayerJoin(this), this);
		manager.registerEvents(new PlayerQuit(this), this);
		manager.registerEvents(new SQLBarrageCoins(this), this);
		manager.registerEvents(new SQLBarrageDeaths(this), this);
		manager.registerEvents(new SQLBarrageKills(this), this);
		manager.registerEvents(new SQLBarrageKits(this), this);
		manager.registerEvents(new SQLBarrageLevels(this), this);
		manager.registerEvents(new SQLBarrageMeteorites(this), this);
		manager.registerEvents(new LevelCommand(this), this);
		manager.registerEvents(new XPCommand(this), this);
		manager.registerEvents(new CoinCommand(this), this);
		manager.registerEvents(new TeamHandler(this), this);
		manager.registerEvents(new BuildHandler(this), this);
		manager.registerEvents(new ChatHandler(this), this);
		manager.registerEvents(new PvPHandler(this), this);
		manager.registerEvents(new NameUpdater(this), this);
		manager.registerEvents(new ScoreBoardHandler(this), this);
		manager.registerEvents(new MOTDHandler(this), this);
		manager.registerEvents(new MeteoriteCommand(this), this);
	}
	
	public void registerCommands(){
		getCommand("level").setExecutor(new LevelCommand(this));
		getCommand("xp").setExecutor(new XPCommand(this));
		getCommand("coins").setExecutor(new CoinCommand(this));
		getCommand("meteorites").setExecutor(new MeteoriteCommand(this));
	}
	
	public static Barrage getInstance(){
	     return instance;
	}

	public SQL getMySQL(){
	     return mysql;
	}
	
	public void connectMySQL() {
		// IPADDRESS, PORT, DATABASE, USERNAME, PASSWORD
	     mysql = new SQL("127.0.0.1", "3306", "endermite_584", "endermite_584", "8d09ed8619");
	     PreparedStatement Kits = mysql.prepareStatement("CREATE TABLE IF NOT EXISTS Kits(UUID varchar(36) NOT NULL, NAME VARCHAR(16) NOT NULL, KIT1 varchar(5) NOT NULL, KIT2 varchar(5) NOT NULL, KIT3 varchar(5) NOT NULL, KIT4 varchar(5) NOT NULL, KIT5 varchar(5) NOT NULL, KIT6 varchar(5) NOT NULL, KIT7 varchar(5) NOT NULL, KIT8 varchar(5) NOT NULL, KIT9 varchar(5) NOT NULL, KIT10 varchar(5) NOT NULL, KIT11 varchar(5) NOT NULL, KIT12 varchar(5) NOT NULL, KIT13 varchar(5) NOT NULL, KIT14 varchar(5) NOT NULL, KIT15 varchar(5) NOT NULL, KIT16 varchar(5) NOT NULL, KIT17 varchar(5) NOT NULL, KIT18 varchar(5) NOT NULL, KIT19 varchar(5) NOT NULL, KIT20 varchar(5) NOT NULL, KIT21 varchar(5) NOT NULL, PRIMARY KEY(UUID))");
	     PreparedStatement Coins = mysql.prepareStatement("CREATE TABLE IF NOT EXISTS Coins(UUID varchar(36) NOT NULL, NAME VARCHAR(16) NOT NULL, COINS INT(20) NOT NULL, PRIMARY KEY(UUID))");
	     PreparedStatement Kills = mysql.prepareStatement("CREATE TABLE IF NOT EXISTS Kills(UUID varchar(36) NOT NULL, NAME VARCHAR(16) NOT NULL, KILLS INT(20) NOT NULL, PRIMARY KEY(UUID))");
	     PreparedStatement Deaths = mysql.prepareStatement("CREATE TABLE IF NOT EXISTS Deaths(UUID varchar(36) NOT NULL, NAME VARCHAR(16) NOT NULL, DEATHS INT(20) NOT NULL, PRIMARY KEY(UUID))");
	     PreparedStatement Meteorites = mysql.prepareStatement("CREATE TABLE IF NOT EXISTS Meteorites(UUID varchar(36) NOT NULL, NAME VARCHAR(16) NOT NULL, METEORITES INT(20) NOT NULL, PRIMARY KEY(UUID))");
	     PreparedStatement Level = mysql.prepareStatement("CREATE TABLE IF NOT EXISTS Level(UUID varchar(36) NOT NULL, NAME VARCHAR(16) NOT NULL, LEVEL INT(20) NOT NULL, EXPERIENCE INT(20) NOT NULL, EXPERIENCENEEDED INT(20) NOT NULL, PRIMARY KEY(UUID))");
	     
	     
	     //USED TO CREATE TABLES FOR INFORMATION
	     mysql.update(Kits);
	     mysql.update(Coins);
	     mysql.update(Kills);
	     mysql.update(Deaths);
	     mysql.update(Meteorites);
	     mysql.update(Level);
	}
}
