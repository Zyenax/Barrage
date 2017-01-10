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

public class SQLBarrageCoins implements Listener{
	
	private static Barrage plugin;
	public SQLBarrageCoins(Barrage listener) {
		SQLBarrageCoins.plugin = listener;		
	}

    public static HashMap<UUID, Integer> COINS = new HashMap<UUID, Integer>();

    private static final String INSERT = "INSERT INTO Coins VALUES(?,?,?) ON DUPLICATE KEY UPDATE NAME=?";
    private static final String SELECT = "SELECT COINS FROM Coins WHERE UUID=?";
    private static final String SAVE = "UPDATE Coins SET COINS=? WHERE UUID=?";
    
    private static void addPlayer(Player p, Integer coinAmount) {
        removePlayer(p);
        COINS.put(p.getUniqueId(), coinAmount);
    }

    public static void removePlayer(Player p) {
        COINS.remove(p.getUniqueId());
    }

    public static Integer getCoins(Player p) {
        if (COINS.containsKey(p.getUniqueId())){
            return COINS.get(p.getUniqueId());
        }else{
        	return null;
        }
        
    }

    public static void setCoins(Player p, Integer coinAmount) {
        if (COINS.containsKey(p.getUniqueId())){
        	COINS.remove(p.getUniqueId());
            COINS.put(p.getUniqueId(), coinAmount);
        }else{
           COINS.put(p.getUniqueId(), coinAmount);
        }
    }
    
    public static void addCoins(Player p, Integer coinAmount) {
        if (COINS.containsKey(p.getUniqueId())){
            COINS.replace(p.getUniqueId(), getCoins(p) + coinAmount);
        }else{
           COINS.put(p.getUniqueId(), coinAmount);
        }
    }
    
    public static void removeCoins(Player p, Integer coinAmount) {
        if (COINS.containsKey(p.getUniqueId())){
            COINS.replace(p.getUniqueId(), getCoins(p) - coinAmount);
        }else{
           COINS.put(p.getUniqueId(), coinAmount);
        }
    }
    
    public static void loadPlayer(final Player p) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {
            public void run() {
                try {
                    PreparedStatement statement = Barrage.mysql.prepareStatement(INSERT);
                    statement.setString(1, p.getUniqueId().toString());
                    statement.setString(2, p.getName());
                    statement.setInt(3, COINS.get(p.getUniqueId()));
                    statement.setString(4, p.getName());
                    Barrage.mysql.update(statement);

                    statement = Barrage.mysql.prepareStatement(SELECT);
                    statement.setString(1, p.getUniqueId().toString());
                    ResultSet result = Barrage.mysql.query(statement);
                    if (result.next())
                        addPlayer(p, result.getInt("COINS"));
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
                    statement.setInt(1, COINS.get(p.getUniqueId()));
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
                	if(COINS.containsKey(p.getUniqueId())){
                    PreparedStatement statement = Barrage.mysql.prepareStatement(SAVE);
                    statement.setInt(1, COINS.get(p.getUniqueId()));
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
