package net.barrage.main.handlers;

import net.barrage.main.Barrage;
import net.barrage.main.SQL.SQLBarrageCoins;
import net.barrage.main.SQL.SQLBarrageLevels;
import net.necrocore.main.SQL.SQLNetworkLevels;
import net.necrocore.main.utils.Packets;
import net.necrocore.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildHandler implements Listener{
	
	@SuppressWarnings("unused")
	private Barrage plugin;
	public BuildHandler(Barrage listener) {
		this.plugin = listener;		
	}
	
	private String noBuild = Utils.color("&8&l[&c&lBarrage&8&l] &eYou do not have permission to build!");
	
	@EventHandler
	public void onBuild(BlockPlaceEvent event){
		if(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
			event.setCancelled(true);
			event.getPlayer().sendMessage(noBuild);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockBreakEvent event){
		Integer xpamount = Utils.randomNum(3, 7);
		Integer networkxpamount = Utils.randomNum(0, 3);
		Integer coinamount = Utils.randomNum(5, 7);
		FireworkEffect blueEffect = FireworkEffect.builder().trail(true).flicker(true).withColor(new Color[] { Color.BLUE }).with(FireworkEffect.Type.BURST).build();
		FireworkEffect redEffect = FireworkEffect.builder().trail(true).flicker(true).withColor(new Color[] { Color.RED }).with(FireworkEffect.Type.BURST).build();
		Material blockType = event.getBlock().getType();
		Block block = event.getBlock();
		if(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
		if (blockType.equals(Material.WOOL) && block.getData() == 14){
			if(TeamHandler.Blue.containsKey(event.getPlayer())){
				event.setCancelled(true);
				SQLBarrageCoins.addCoins(event.getPlayer(), coinamount);
				SQLBarrageLevels.addXP(event.getPlayer(), xpamount);
				SQLNetworkLevels.addXP(event.getPlayer(), networkxpamount);
				block.getWorld().playSound(event.getPlayer().getLocation(), Sound.BLAZE_HIT, Integer.MAX_VALUE, Integer.MAX_VALUE);
				Packets.playFirework(block.getLocation().add(0, 5, 0), blueEffect, 1);
				for(Player p : Bukkit.getOnlinePlayers()){
					p.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] " + "&8&l[&9&lBLUE&8&l] &9" + event.getPlayer().getName() + " &ehas destroyed a &8&l[&c&lRED&8&l] &ewool!"));
					Packets.sendActionBar(p, Utils.color("&8&l[&c&lBarrage&8&l] " + "&8&l[&9&lBLUE&8&l] &9" + event.getPlayer().getName() + " &ehas destroyed a &8&l[&c&lRED&8&l] &ewool!"));
				}
			}else if(TeamHandler.Red.containsKey(event.getPlayer())){
				event.setCancelled(true);
				event.getPlayer().sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &eYou arent allowed to break your own wool!"));
			}
		}else if (blockType.equals(Material.WOOL) && block.getData() == 11){
			if(TeamHandler.Blue.containsKey(event.getPlayer())){
				event.setCancelled(true);
				event.getPlayer().sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &eYou arent allowed to break your own wool!"));
			}else if(TeamHandler.Red.containsKey(event.getPlayer())){
				event.setCancelled(true);
				SQLBarrageCoins.addCoins(event.getPlayer(), coinamount);
				SQLBarrageLevels.addXP(event.getPlayer(), xpamount);
				SQLNetworkLevels.addXP(event.getPlayer(), networkxpamount);
				block.getWorld().playSound(event.getPlayer().getLocation(), Sound.BLAZE_HIT, Integer.MAX_VALUE, Integer.MAX_VALUE);
				Packets.playFirework(block.getLocation().add(0, 5, 0), redEffect, 1);
				for(Player p : Bukkit.getOnlinePlayers()){
					p.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] " + "&8&l[&c&lRED&8&l] &c" + event.getPlayer().getName() + " &ehas destroyed a &8&l[&9&lBLUE&8&l] &ewool!"));
					Packets.sendActionBar(p, Utils.color("&8&l[&c&lBarrage&8&l] " + "&8&l[&c&lRED&8&l] &c" + event.getPlayer().getName() + " &ehas destroyed a &8&l[&9&lBLUE&8&l] &ewool!"));
				}
				
			}
		}else{
			event.setCancelled(true);
			event.getPlayer().sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] " + "&eYou may only destroy wool!"));
		}
	}
	}

}
