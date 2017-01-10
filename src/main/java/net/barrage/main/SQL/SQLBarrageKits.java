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

public class SQLBarrageKits implements Listener{
	
	private static Barrage plugin;
	public SQLBarrageKits(Barrage listener) {
		SQLBarrageKits.plugin = listener;		
	}

	public static HashMap<UUID, String> Kit1 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit2 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit3 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit4 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit5 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit6 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit7 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit8 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit9 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit10 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit11 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit12 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit13 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit14 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit15 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit16 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit17 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit18 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit19 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit20 = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Kit21 = new HashMap<UUID, String>();

    private static final String INSERT = "INSERT INTO Kits VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE NAME=?";
    private static final String SELECT = "SELECT * FROM Kits WHERE UUID=?";
    private static final String SAVE = "UPDATE Kits SET KIT1=?, KIT2=?, KIT3=?, KIT4=?, KIT5=?, KIT6=?, KIT7=?, KIT8=?, KIT9=?, KIT10=?, KIT11=?, KIT12=?, KIT13=?, KIT14=?, KIT15=?, KIT16=?, KIT17=?, KIT18=?, KIT19=?, KIT20=?, KIT21=? WHERE UUID=?";
    
    private static void addPlayer(Player p, String kit1, String kit2, String kit3, String kit4, String kit5, String kit6, String kit7, String kit8, String kit9, String kit10, String kit11, String kit12, String kit13, String kit14, String kit15, String kit16, String kit17, String kit18, String kit19, String kit20, String kit21) {
        removePlayer(p);
        Kit1.put(p.getUniqueId(), kit1);
        Kit2.put(p.getUniqueId(), kit2);
        Kit3.put(p.getUniqueId(), kit3);
        Kit4.put(p.getUniqueId(), kit4);
        Kit5.put(p.getUniqueId(), kit5);
        Kit6.put(p.getUniqueId(), kit6);
        Kit7.put(p.getUniqueId(), kit7);
        Kit8.put(p.getUniqueId(), kit8);
        Kit9.put(p.getUniqueId(), kit9);
        Kit10.put(p.getUniqueId(), kit10);
        Kit11.put(p.getUniqueId(), kit11);
        Kit12.put(p.getUniqueId(), kit12);
        Kit13.put(p.getUniqueId(), kit13);
        Kit14.put(p.getUniqueId(), kit14);
        Kit15.put(p.getUniqueId(), kit15);
        Kit16.put(p.getUniqueId(), kit16);
        Kit17.put(p.getUniqueId(), kit17);
        Kit18.put(p.getUniqueId(), kit18);
        Kit19.put(p.getUniqueId(), kit19);
        Kit20.put(p.getUniqueId(), kit20);
        Kit21.put(p.getUniqueId(), kit21);
    }

    public static void removePlayer(Player p) {
    	Kit1.remove(p.getUniqueId());
    	Kit2.remove(p.getUniqueId());
    	Kit3.remove(p.getUniqueId());
    	Kit4.remove(p.getUniqueId());
    	Kit5.remove(p.getUniqueId());
    	Kit6.remove(p.getUniqueId());
    	Kit7.remove(p.getUniqueId());
    	Kit8.remove(p.getUniqueId());
    	Kit9.remove(p.getUniqueId());
    	Kit10.remove(p.getUniqueId());
    	Kit11.remove(p.getUniqueId());
    	Kit12.remove(p.getUniqueId());
    	Kit13.remove(p.getUniqueId());
    	Kit14.remove(p.getUniqueId());
    	Kit15.remove(p.getUniqueId());
    	Kit16.remove(p.getUniqueId());
    	Kit17.remove(p.getUniqueId());
    	Kit18.remove(p.getUniqueId());
    	Kit19.remove(p.getUniqueId());
    	Kit20.remove(p.getUniqueId());
    	Kit21.remove(p.getUniqueId());
    }

    public static String getKit1(Player p) {
        if (Kit1.containsKey(p.getUniqueId())){
            return Kit1.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit2(Player p) {
        if (Kit2.containsKey(p.getUniqueId())){
            return Kit2.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit3(Player p) {
        if (Kit3.containsKey(p.getUniqueId())){
            return Kit3.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit4(Player p) {
        if (Kit4.containsKey(p.getUniqueId())){
            return Kit4.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit5(Player p) {
        if (Kit5.containsKey(p.getUniqueId())){
            return Kit5.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit6(Player p) {
        if (Kit6.containsKey(p.getUniqueId())){
            return Kit6.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit7(Player p) {
        if (Kit7.containsKey(p.getUniqueId())){
            return Kit7.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit8(Player p) {
        if (Kit8.containsKey(p.getUniqueId())){
            return Kit8.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit9(Player p) {
        if (Kit9.containsKey(p.getUniqueId())){
            return Kit9.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit10(Player p) {
        if (Kit10.containsKey(p.getUniqueId())){
            return Kit10.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit11(Player p) {
        if (Kit11.containsKey(p.getUniqueId())){
            return Kit11.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit12(Player p) {
        if (Kit12.containsKey(p.getUniqueId())){
            return Kit12.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit13(Player p) {
        if (Kit13.containsKey(p.getUniqueId())){
            return Kit13.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit14(Player p) {
        if (Kit14.containsKey(p.getUniqueId())){
            return Kit14.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit15(Player p) {
        if (Kit15.containsKey(p.getUniqueId())){
            return Kit15.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit16(Player p) {
        if (Kit16.containsKey(p.getUniqueId())){
            return Kit16.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit17(Player p) {
        if (Kit17.containsKey(p.getUniqueId())){
            return Kit17.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit18(Player p) {
        if (Kit18.containsKey(p.getUniqueId())){
            return Kit18.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit19(Player p) {
        if (Kit19.containsKey(p.getUniqueId())){
            return Kit19.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit20(Player p) {
        if (Kit20.containsKey(p.getUniqueId())){
            return Kit20.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static String getKit21(Player p) {
        if (Kit21.containsKey(p.getUniqueId())){
            return Kit21.get(p.getUniqueId());
        }else{
        	return null;
        }
    }

    public static void setKit1(Player p, String trueorfalse) {
        if(Kit1.containsKey(p.getUniqueId())){
        	Kit1.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit1.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit2(Player p, String trueorfalse) {
        if(Kit2.containsKey(p.getUniqueId())){
        	Kit2.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit2.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit3(Player p, String trueorfalse) {
        if(Kit3.containsKey(p.getUniqueId())){
        	Kit3.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit3.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit4(Player p, String trueorfalse) {
        if(Kit4.containsKey(p.getUniqueId())){
        	Kit4.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit4.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit5(Player p, String trueorfalse) {
        if(Kit5.containsKey(p.getUniqueId())){
        	Kit5.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit5.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit6(Player p, String trueorfalse) {
        if(Kit6.containsKey(p.getUniqueId())){
        	Kit6.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit6.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit7(Player p, String trueorfalse) {
        if(Kit7.containsKey(p.getUniqueId())){
        	Kit7.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit7.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit8(Player p, String trueorfalse) {
        if(Kit8.containsKey(p.getUniqueId())){
        	Kit8.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit8.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit9(Player p, String trueorfalse) {
        if(Kit9.containsKey(p.getUniqueId())){
        	Kit9.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit9.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit10(Player p, String trueorfalse) {
        if(Kit10.containsKey(p.getUniqueId())){
        	Kit10.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit10.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit11(Player p, String trueorfalse) {
        if(Kit11.containsKey(p.getUniqueId())){
        	Kit11.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit11.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit12(Player p, String trueorfalse) {
        if(Kit12.containsKey(p.getUniqueId())){
        	Kit12.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit12.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit13(Player p, String trueorfalse) {
        if(Kit13.containsKey(p.getUniqueId())){
        	Kit13.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit13.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit14(Player p, String trueorfalse) {
        if(Kit14.containsKey(p.getUniqueId())){
        	Kit14.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit14.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit15(Player p, String trueorfalse) {
        if(Kit15.containsKey(p.getUniqueId())){
        	Kit15.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit15.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit16(Player p, String trueorfalse) {
        if(Kit16.containsKey(p.getUniqueId())){
        	Kit16.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit16.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit17(Player p, String trueorfalse) {
        if(Kit17.containsKey(p.getUniqueId())){
        	Kit17.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit17.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit18(Player p, String trueorfalse) {
        if(Kit18.containsKey(p.getUniqueId())){
        	Kit18.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit18.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit19(Player p, String trueorfalse) {
        if(Kit19.containsKey(p.getUniqueId())){
        	Kit19.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit19.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit20(Player p, String trueorfalse) {
        if(Kit20.containsKey(p.getUniqueId())){
        	Kit20.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit20.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void setKit21(Player p, String trueorfalse) {
        if(Kit21.containsKey(p.getUniqueId())){
        	Kit21.replace(p.getUniqueId(), trueorfalse);
        }else{
        	Kit21.put(p.getUniqueId(), trueorfalse);
        }
    }
    
    public static void loadPlayer(final Player p) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {
            public void run() {
                try {
                        PreparedStatement statement = Barrage.mysql.prepareStatement(INSERT);
                        statement.setString(1, p.getUniqueId().toString());
                        statement.setString(2, p.getName());
                        statement.setString(3, Kit1.get(p.getUniqueId()));
                        statement.setString(4, Kit2.get(p.getUniqueId()));
                        statement.setString(5, Kit3.get(p.getUniqueId()));
                        statement.setString(6, Kit4.get(p.getUniqueId()));
                        statement.setString(7, Kit5.get(p.getUniqueId()));
                        statement.setString(8, Kit6.get(p.getUniqueId()));
                        statement.setString(9, Kit7.get(p.getUniqueId()));
                        statement.setString(10, Kit8.get(p.getUniqueId()));
                        statement.setString(11, Kit9.get(p.getUniqueId()));
                        statement.setString(12, Kit10.get(p.getUniqueId()));
                        statement.setString(13, Kit11.get(p.getUniqueId()));
                        statement.setString(14, Kit12.get(p.getUniqueId()));
                        statement.setString(15, Kit13.get(p.getUniqueId()));
                        statement.setString(16, Kit14.get(p.getUniqueId()));
                        statement.setString(17, Kit15.get(p.getUniqueId()));
                        statement.setString(18, Kit16.get(p.getUniqueId()));
                        statement.setString(19, Kit17.get(p.getUniqueId()));
                        statement.setString(20, Kit18.get(p.getUniqueId()));
                        statement.setString(21, Kit19.get(p.getUniqueId()));
                        statement.setString(22, Kit20.get(p.getUniqueId()));
                        statement.setString(23, Kit21.get(p.getUniqueId()));
                        statement.setString(24, p.getName());
                        Barrage.mysql.update(statement);

                    statement = Barrage.mysql.prepareStatement(SELECT);
                    statement.setString(1, p.getUniqueId().toString());
                    ResultSet result = Barrage.mysql.query(statement);
                    if (result.next())
                        addPlayer(p, result.getString("KIT1"), 
                        		result.getString("KIT2"), 
                        		result.getString("KIT3"), 
                        		result.getString("KIT4"), 
                        		result.getString("KIT5"), 
                        		result.getString("KIT6"), 
                        		result.getString("KIT7"), 
                        		result.getString("KIT8"), 
                        		result.getString("KIT9"), 
                        		result.getString("KIT10"), 
                        		result.getString("KIT11"), 
                        		result.getString("KIT12"), 
                        		result.getString("KIT13"), 
                        		result.getString("KIT14"), 
                        		result.getString("KIT15"), 
                        		result.getString("KIT16"), 
                        		result.getString("KIT17"), 
                        		result.getString("KIT18"), 
                        		result.getString("KIT19"), 
                        		result.getString("KIT20"), 
                        		result.getString("KIT21"));
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
                        statement.setString(1, Kit1.get(p.getUniqueId()));
                        statement.setString(2, Kit2.get(p.getUniqueId()));
                        statement.setString(3, Kit3.get(p.getUniqueId()));
                        statement.setString(4, Kit4.get(p.getUniqueId()));
                        statement.setString(5, Kit5.get(p.getUniqueId()));
                        statement.setString(6, Kit6.get(p.getUniqueId()));
                        statement.setString(7, Kit7.get(p.getUniqueId()));
                        statement.setString(8, Kit8.get(p.getUniqueId()));
                        statement.setString(9, Kit9.get(p.getUniqueId()));
                        statement.setString(10, Kit10.get(p.getUniqueId()));
                        statement.setString(11, Kit11.get(p.getUniqueId()));
                        statement.setString(12, Kit12.get(p.getUniqueId()));
                        statement.setString(13, Kit13.get(p.getUniqueId()));
                        statement.setString(14, Kit14.get(p.getUniqueId()));
                        statement.setString(15, Kit15.get(p.getUniqueId()));
                        statement.setString(16, Kit16.get(p.getUniqueId()));
                        statement.setString(17, Kit17.get(p.getUniqueId()));
                        statement.setString(18, Kit18.get(p.getUniqueId()));
                        statement.setString(19, Kit19.get(p.getUniqueId()));
                        statement.setString(20, Kit20.get(p.getUniqueId()));
                        statement.setString(21, Kit21.get(p.getUniqueId()));
                        statement.setString(22, p.getUniqueId().toString());
                        Barrage.mysql.update(statement);
                        removePlayer(p);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
    }
    
    public static void onDisableSavePlayer() {
            	for(Player p : Bukkit.getOnlinePlayers()){
                try {
                    PreparedStatement statement = Barrage.mysql.prepareStatement(SAVE);
                    statement.setString(1, Kit1.get(p.getUniqueId()));
                    statement.setString(2, Kit2.get(p.getUniqueId()));
                    statement.setString(3, Kit3.get(p.getUniqueId()));
                    statement.setString(4, Kit4.get(p.getUniqueId()));
                    statement.setString(5, Kit5.get(p.getUniqueId()));
                    statement.setString(6, Kit6.get(p.getUniqueId()));
                    statement.setString(7, Kit7.get(p.getUniqueId()));
                    statement.setString(8, Kit8.get(p.getUniqueId()));
                    statement.setString(9, Kit9.get(p.getUniqueId()));
                    statement.setString(10, Kit10.get(p.getUniqueId()));
                    statement.setString(11, Kit11.get(p.getUniqueId()));
                    statement.setString(12, Kit12.get(p.getUniqueId()));
                    statement.setString(13, Kit13.get(p.getUniqueId()));
                    statement.setString(14, Kit14.get(p.getUniqueId()));
                    statement.setString(15, Kit15.get(p.getUniqueId()));
                    statement.setString(16, Kit16.get(p.getUniqueId()));
                    statement.setString(17, Kit17.get(p.getUniqueId()));
                    statement.setString(18, Kit18.get(p.getUniqueId()));
                    statement.setString(19, Kit19.get(p.getUniqueId()));
                    statement.setString(20, Kit20.get(p.getUniqueId()));
                    statement.setString(21, Kit21.get(p.getUniqueId()));
                    statement.setString(22, p.getUniqueId().toString());
                    Barrage.mysql.update(statement);
                    removePlayer(p);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            	}
    }
}
