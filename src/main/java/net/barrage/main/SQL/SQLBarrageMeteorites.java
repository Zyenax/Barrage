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

public class SQLBarrageMeteorites implements Listener{
	
	private static Barrage plugin;
	public SQLBarrageMeteorites(Barrage listener) {
		SQLBarrageMeteorites.plugin = listener;		
	}

    public static HashMap<UUID, Integer> meteorites = new HashMap<UUID, Integer>();

    private static final String INSERT = "INSERT INTO Meteorites VALUES(?,?,?) ON DUPLICATE KEY UPDATE NAME=?";
    private static final String SELECT = "SELECT METEORITES FROM Meteorites WHERE UUID=?";
    private static final String SAVE = "UPDATE Meteorites SET METEORITES=? WHERE UUID=?";
    
    private static void addPlayer(Player p, Integer meteoriteAmount) {
        removePlayer(p);
        meteorites.put(p.getUniqueId(), meteoriteAmount);
    }

    public static void removePlayer(Player p) {
        meteorites.remove(p.getUniqueId());
    }

    public static Integer getMeteorites(Player p) {
        if (meteorites.containsKey(p.getUniqueId())){
            return meteorites.get(p.getUniqueId());
        }else{
        	return null;
        }
        
    }

    public static void setMeteorites(Player p, Integer meteoriteAmount) {
        if (meteorites.containsKey(p.getUniqueId())){
        	meteorites.remove(p.getUniqueId());
            meteorites.put(p.getUniqueId(), meteoriteAmount);
        }else{
           meteorites.put(p.getUniqueId(), meteoriteAmount);
        }
    }
    
    public static void addMeteorites(Player p, Integer meteoriteAmount) {
        if (meteorites.containsKey(p.getUniqueId())){
            meteorites.replace(p.getUniqueId(), getMeteorites(p) + meteoriteAmount);
        }else{
           meteorites.put(p.getUniqueId(), meteoriteAmount);
        }
    }
    
    public static void removeMeteorites(Player p, Integer meteoriteAmount) {
        if (meteorites.containsKey(p.getUniqueId())){
            meteorites.replace(p.getUniqueId(), getMeteorites(p) - meteoriteAmount);
        }else{
           meteorites.put(p.getUniqueId(), meteoriteAmount);
        }
    }
    
    public static void loadPlayer(final Player p) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {
            public void run() {
                try {
                    PreparedStatement statement = Barrage.mysql.prepareStatement(INSERT);
                    statement.setString(1, p.getUniqueId().toString());
                    statement.setString(2, p.getName());
                    statement.setInt(3, meteorites.get(p.getUniqueId()));
                    statement.setString(4, p.getName());
                    Barrage.mysql.update(statement);

                    statement = Barrage.mysql.prepareStatement(SELECT);
                    statement.setString(1, p.getUniqueId().toString());
                    ResultSet result = Barrage.mysql.query(statement);
                    if (result.next())
                        addPlayer(p, result.getInt("METEORITES"));
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
                	if(meteorites.containsKey(p.getUniqueId())){
                    PreparedStatement statement = Barrage.mysql.prepareStatement(SAVE);
                    statement.setInt(1, meteorites.get(p.getUniqueId()));
                    statement.setString(2, p.getUniqueId().toString());
                    Barrage.mysql.update(statement);
                    removePlayer(p);
                	}
                } catch (SQLException e) {
                    e.printStackTrace();
                }
    }
    
    public static void onDisableSavePlayer() {
            	for(Player p : Bukkit.getOnlinePlayers()){
                try {
                    PreparedStatement statement = Barrage.mysql.prepareStatement(SAVE);
                    statement.setInt(1, meteorites.get(p.getUniqueId()));
                    statement.setString(2, p.getUniqueId().toString());
                    Barrage.mysql.update(statement);
                    removePlayer(p);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            	}
    }
}
