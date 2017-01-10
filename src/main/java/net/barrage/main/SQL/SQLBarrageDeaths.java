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

public class SQLBarrageDeaths implements Listener{
	
	private static Barrage plugin;
	public SQLBarrageDeaths(Barrage listener) {
		SQLBarrageDeaths.plugin = listener;		
	}

    public static HashMap<UUID, Integer> Deaths = new HashMap<UUID, Integer>();

    private static final String INSERT = "INSERT INTO Deaths VALUES(?,?,?) ON DUPLICATE KEY UPDATE NAME=?";
    private static final String SELECT = "SELECT DEATHS FROM Deaths WHERE UUID=?";
    private static final String SAVE = "UPDATE Deaths SET DEATHS=? WHERE UUID=?";
    
    private static void addPlayer(Player p, Integer deathAmount) {
        removePlayer(p);
        Deaths.put(p.getUniqueId(), deathAmount);
    }

    public static void removePlayer(Player p) {
        Deaths.remove(p.getUniqueId());
    }

    public static Integer getDeaths(Player p) {
        if (Deaths.containsKey(p.getUniqueId())){
            return Deaths.get(p.getUniqueId());
        }else{
        	return null;
        }
        
    }

    public static void setDeaths(Player p, Integer deathAmount) {
        if (Deaths.containsKey(p.getUniqueId())){
        	Deaths.remove(p.getUniqueId());
            Deaths.put(p.getUniqueId(), deathAmount);
        }else{
           Deaths.put(p.getUniqueId(), deathAmount);
        }
    }
    
    public static void addDeaths(Player p, Integer deathAmount) {
        if (Deaths.containsKey(p.getUniqueId())){
            Deaths.replace(p.getUniqueId(), getDeaths(p) + deathAmount);
        }else{
           Deaths.put(p.getUniqueId(), deathAmount);
        }
    }
    
    public static void removeDeaths(Player p, Integer deathAmount) {
        if (Deaths.containsKey(p.getUniqueId())){
            Deaths.replace(p.getUniqueId(), getDeaths(p) - deathAmount);
        }else{
           Deaths.put(p.getUniqueId(), deathAmount);
        }
    }
    
    public static void loadPlayer(final Player p) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {
            public void run() {
                try {
                    PreparedStatement statement = Barrage.mysql.prepareStatement(INSERT);
                    statement.setString(1, p.getUniqueId().toString());
                    statement.setString(2, p.getName());
                    statement.setInt(3, Deaths.get(p.getUniqueId()));
                    statement.setString(4, p.getName());
                    Barrage.mysql.update(statement);

                    statement = Barrage.mysql.prepareStatement(SELECT);
                    statement.setString(1, p.getUniqueId().toString());
                    ResultSet result = Barrage.mysql.query(statement);
                    if (result.next())
                        addPlayer(p, result.getInt("DEATHS"));
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
                    statement.setInt(1, Deaths.get(p.getUniqueId()));
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
                	if(Deaths.containsKey(p.getUniqueId())){
                    PreparedStatement statement = Barrage.mysql.prepareStatement(SAVE);
                    statement.setInt(1, Deaths.get(p.getUniqueId()));
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
