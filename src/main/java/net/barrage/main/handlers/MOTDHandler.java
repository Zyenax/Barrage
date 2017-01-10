package net.barrage.main.handlers;

import net.barrage.main.Barrage;
import net.necrocore.main.utils.Utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTDHandler implements Listener{

	@SuppressWarnings("unused")
	private static Barrage plugin;

	public MOTDHandler(Barrage hub) {
		MOTDHandler.plugin = hub;
	}
	
	@EventHandler
	public void onPing(ServerListPingEvent e){
		e.setMaxPlayers(e.getNumPlayers() + 1);
		e.setMotd(Utils.color("                       &8play.&c&lNecroCube&8.com \n    &9&lBLUE: &e&l" + TeamHandler.Blue.size() + " &6&lYOUR IP: &b&l" + e.getAddress().getHostAddress() + " &c&lRED: &e&l" + TeamHandler.Red.size()));
	}

}
