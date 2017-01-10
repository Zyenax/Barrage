package net.barrage.main.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

import net.barrage.main.Barrage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SQLBarrageKills implements Listener{
	
	private static Barrage plugin;
	public SQLBarrageKills(Barrage listener) {
		SQLBarrageKills.plugin = listener;		
	}

    public static HashMap<UUID, Integer> Kills = new HashMap<UUID, Integer>();

    private static final String INSERT = "INSERT INTO Kills VALUES(?,?,?) ON DUPLICATE KEY UPDATE NAME=?";
    private static final String SELECT = "SELECT KILLS FROM Kills WHERE UUID=?";
    private static final String SAVE = "UPDATE Kills SET KILLS=? WHERE UUID=?";
    
    private static void addPlayer(Player p, Integer killAmount) {
        removePlayer(p);
        Kills.put(p.getUniqueId(), killAmount);
    }

    public static void removePlayer(Player p) {
        Kills.remove(p.getUniqueId());
    }

    public static Integer getKills(Player p) {
        if (Kills.containsKey(p.getUniqueId())){
            return Kills.get(p.getUniqueId());
        }else{
        	return null;
        }
        
    }

    public static void setKills(Player p, Integer killAmount) {
        if (Kills.containsKey(p.getUniqueId())){
        	Kills.remove(p.getUniqueId());
            Kills.put(p.getUniqueId(), killAmount);
        }else{
           Kills.put(p.getUniqueId(), killAmount);
        }
    }
    
    public static void addKills(Player p, Integer killAmount) {
        if (Kills.containsKey(p.getUniqueId())){
            Kills.replace(p.getUniqueId(), getKills(p) + killAmount);
        }else{
           Kills.put(p.getUniqueId(), killAmount);
        }
    }
    
    public static void removeKills(Player p, Integer killAmount) {
        if (Kills.containsKey(p.getUniqueId())){
            Kills.replace(p.getUniqueId(), getKills(p) - killAmount);
        }else{
           Kills.put(p.getUniqueId(), killAmount);
        }
    }
    
    public static void loadPlayer(final Player p) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {
            public void run() {
                try {
                    PreparedStatement statement = Barrage.mysql.prepareStatement(INSERT);
                    statement.setString(1, p.getUniqueId().toString());
                    statement.setString(2, p.getName());
                    statement.setInt(3, Kills.get(p.getUniqueId()));
                    statement.setString(4, p.getName());
                    Barrage.mysql.update(statement);

                    statement = Barrage.mysql.prepareStatement(SELECT);
                    statement.setString(1, p.getUniqueId().toString());
                    ResultSet result = Barrage.mysql.query(statement);
                    if (result.next())
                        addPlayer(p, result.getInt("KILLS"));
                    result.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static void savePlayer(final Player p) {
                try {
                    PreparedStatement statement = Barrage.mysql.prepareStatement(SAVE);
                    statement.setInt(1, Kills.get(p.getUniqueId()));
                    statement.setString(2, p.getUniqueId().toString());
                    Barrage.mysql.update(statement);
                    removePlayer(p);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
    }
    
    public static void onDisableSavePlayer() {
            	for(Player p : Bukkit.getOnlinePlayers()){
                try {
                	if(Kills.containsKey(p.getUniqueId())){
                    PreparedStatement statement = Barrage.mysql.prepareStatement(SAVE);
                    statement.setInt(1, Kills.get(p.getUniqueId()));
                    statement.setString(2, p.getUniqueId().toString());
                    Barrage.mysql.update(statement);
                    removePlayer(p);
                	}
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            	}
    }
}
