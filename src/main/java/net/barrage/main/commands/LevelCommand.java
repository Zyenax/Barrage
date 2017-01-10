package net.barrage.main.commands;

import net.barrage.main.Barrage;
import net.barrage.main.SQL.SQLBarrageLevels;
import net.necrocore.main.SQL.SQLRanks;
import net.necrocore.main.handlers.Rank;
import net.necrocore.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class LevelCommand implements Listener, CommandExecutor {
	
	@SuppressWarnings("unused")
	private Barrage plugin;

	public LevelCommand(Barrage hub) {
		this.plugin = hub;
	}

	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
			if (command.getName().equalsIgnoreCase("level")){
				if(args.length == 0){
					String incompleteCommand = Utils.color("&8&l[&c&lBarrage&8&l] &c/level [give/take/set/reset/get] [player] [amount]");
					String noPerms = Utils.color("&8&l[&c&lBarrage&8&l] &cYou must have " + Rank.ADMIN.getColor() + Rank.ADMIN.getName() + " &cor above to use this!");
					String badSender = Utils.color("&8&l[&c&lBarrage&8&l] &cYou do not have permission to send this command!");
					if(sender instanceof Player){
						Player player = (Player)sender;
						if(SQLRanks.getRank(player).equals(Rank.ADMIN.getName())
								|| SQLRanks.getRank(player).equals(Rank.OWNER.getName())){
							player.sendMessage(incompleteCommand);
						}else{
							player.sendMessage(noPerms);
						}
					}else if(sender instanceof ConsoleCommandSender){
						sender.sendMessage(incompleteCommand);
					}else{
						sender.sendMessage(badSender);
					}
				}
				
					if(args.length == 1){
						String arg1 = args[0];
						String invalidPlayer = Utils.color("&8&l[&c&lBarrage&8&l] &cYou must supply an online players name!");
						String incompleteCommand = Utils.color("&8&l[&c&lBarrage&8&l] &c/level [give/take/set/reset/get] [player] [amount]");
						String noPerms = Utils.color("&8&l[&c&lBarrage&8&l] &cYou must have " + Rank.ADMIN.getColor() + Rank.ADMIN.getName() + " &cor above to use this!");
						String badSender = Utils.color("&8&l[&c&lBarrage&8&l] &cYou do not have permission to send this command!");
						if(sender instanceof Player){
							Player player = (Player)sender;
							if(SQLRanks.getRank(player).equals(Rank.ADMIN.getName())
									|| SQLRanks.getRank(player).equals(Rank.OWNER.getName())){
								if(arg1.equalsIgnoreCase("give")
										|| arg1.equalsIgnoreCase("take")
										|| arg1.equalsIgnoreCase("set")
										|| arg1.equalsIgnoreCase("get")
										|| arg1.equalsIgnoreCase("reset")){
									player.sendMessage(invalidPlayer);
								}else{
									player.sendMessage(incompleteCommand);
								}
							}else{
								player.sendMessage(noPerms);
							}
						}else if(sender instanceof ConsoleCommandSender){
							if(arg1.equals("give")
									|| arg1.equals("take")
									|| arg1.equals("set")
									|| arg1.equals("get")
									|| arg1.equals("reset")){
								sender.sendMessage(invalidPlayer);
							}else{
								sender.sendMessage(incompleteCommand);
							}
						}else{
							sender.sendMessage(badSender);
						}
					}
			
				if(args.length == 2){
					Player target = (Player)Bukkit.getServer().getPlayer(args[1]);
					String nolevelValueProvided = Utils.color("&8&l[&c&lBarrage&8&l] &cYou must supply a level amount!");
					String noPerms = Utils.color("&8&l[&c&lBarrage&8&l] &cYou must have " + Rank.ADMIN.getColor() + Rank.ADMIN.getName() + " &cor above to use this!");
					String invalidPlayer = Utils.color("&8&l[&c&lBarrage&8&l] &cYou must supply an online players name!");
					String badSender = Utils.color("&8&l[&c&lBarrage&8&l] &cYou do not have permission to send this command!");
						if(sender instanceof Player){
							Player player = (Player)sender;
								if(SQLRanks.getRank(player).equals(Rank.ADMIN.getName())){
									if(target != null){
										if(args[0].equals("get")){
											player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + " &eis level &c" + SQLBarrageLevels.getLevel(target)));
										}else if(args[0].equals("reset")){
											if(!SQLRanks.getRank(target).equals(Rank.OWNER.getName())){
												SQLBarrageLevels.setLevel(target, 0);
												
												player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been reset to &c" + SQLBarrageLevels.getLevel(target)));
											}
										}else{
											player.sendMessage(nolevelValueProvided);
										}
									}else{
										player.sendMessage(invalidPlayer);
									}
								}else if(SQLRanks.getRank(player).equals(Rank.OWNER.getName())){
									if(target != null){
										if(args[0].equals("get")){
											player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + " &eis level &c" + SQLBarrageLevels.getLevel(target)));
										}else if(args[0].equals("reset")){
											SQLBarrageLevels.setLevel(target, 0);
											
											player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been reset to &c" + SQLBarrageLevels.getLevel(target)));
										}else{
											player.sendMessage(nolevelValueProvided);
										}
									}else{
										player.sendMessage(invalidPlayer);
									}
								}else{
									player.sendMessage(noPerms);
								}
						}else if(sender instanceof ConsoleCommandSender){
							if(target != null){
								sender.sendMessage(nolevelValueProvided);
							}else{
								sender.sendMessage(invalidPlayer);
							}
						}else{
							sender.sendMessage(badSender);
						}
					}
			
				if(args.length == 3){
					String incompleteCommand = Utils.color("&8&l[&c&lBarrage&8&l] &c/level [give/take/set/reset/get] [player] [amount]");
					String noHigherPerm = Utils.color("&8&l[&c&lBarrage&8&l] &cYou are not allowed to edit this players level!");
					String noPerms = Utils.color("&8&l[&c&lBarrage&8&l] &cYou must have " + Rank.ADMIN.getColor() + Rank.ADMIN.getName() + " &cor above to use this!");
					String invalidPlayer = Utils.color("&8&l[&c&lBarrage&8&l] &cYou must supply an online players name!");
					String invalidNumberException = Utils.color("&8&l[&c&lBarrage&8&l] &cYou must supply a number!");
					String giveortake = args[0];
					Player target = (Player)Bukkit.getServer().getPlayer(args[1]);
					if(args[2].length() <= 9){
						Integer amount = Integer.parseInt(args[2]);
					if(sender instanceof Player){
						Player player = (Player)sender;
						if(target != null){
						if(SQLRanks.getRank(player).equals(Rank.ADMIN.getName())){
							if(!SQLRanks.getRank(target).equals(Rank.OWNER.getName())){
								if(giveortake.equals("give")){
									try{
										if(SQLBarrageLevels.getLevel(target) + amount <= 100 && SQLBarrageLevels.getLevel(target) + amount >= 0){
											SQLBarrageLevels.addLevel(target, amount);
											player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been set to &c" + SQLBarrageLevels.getLevel(target)));
										}else{
											player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &cYou have entered an unsupported amount!"));
										}
									}catch (NumberFormatException e1){
										player.sendMessage(invalidNumberException);
									}
								}else if(giveortake.equals("take")){
									try{
										if(SQLBarrageLevels.getLevel(target) - amount <= 100 && SQLBarrageLevels.getLevel(target) - amount >= 0){
											SQLBarrageLevels.removeLevel(target, amount);
											player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been set to &c" + SQLBarrageLevels.getLevel(target)));
										}else{
											player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &cYou have entered an unsupported amount!"));
										}
									}catch (NumberFormatException e1){
										player.sendMessage(invalidNumberException);
									}
								}else if(giveortake.equals("set")){
									try{
										if(amount <= 100 && amount >= 0){
											SQLBarrageLevels.setLevel(target, amount);
											player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been set to &c" + SQLBarrageLevels.getLevel(target)));
										}else{
											player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &cYou have entered an unsupported amount!"));
										}
									}catch (NumberFormatException e1){
										player.sendMessage(invalidNumberException);
									}
								}else if(giveortake.equals("reset")){
									try{
										SQLBarrageLevels.setLevel(target, 0);
										player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been set to &c" + SQLBarrageLevels.getLevel(target)));
									}catch (NumberFormatException e1){
										player.sendMessage(invalidNumberException);
									}
								}else if(giveortake.equals("get")){
									player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + " &eis level &c" + SQLBarrageLevels.getLevel(target)));
								}else{
									player.sendMessage(incompleteCommand);
								}
							}else{
								player.sendMessage(noHigherPerm);
							}
						}else if(SQLRanks.getRank(player).equals(Rank.OWNER.getName())){
							if(giveortake.equals("give")){
								try{
									if(SQLBarrageLevels.getLevel(target) + amount <= 100 && SQLBarrageLevels.getLevel(target) + amount >= 0){
										SQLBarrageLevels.addLevel(target, amount);
										player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been set to &c" + SQLBarrageLevels.getLevel(target)));
									}else{
										player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &cYou have entered an unsupported amount!"));
									}
								}catch (NumberFormatException e1){
									player.sendMessage(invalidNumberException);
								}
							}else if(giveortake.equals("take")){
								try{
									if(SQLBarrageLevels.getLevel(target) - amount <= 100 && SQLBarrageLevels.getLevel(target) - amount >= 0){
										SQLBarrageLevels.removeLevel(target, amount);
										player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been set to &c" + SQLBarrageLevels.getLevel(target)));
									}else{
										player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &cYou have entered an unsupported amount!"));
									}
								}catch (NumberFormatException e1){
									player.sendMessage(invalidNumberException);
								}
							}else if(giveortake.equals("set")){
								try{
									if(amount <= 100 && amount >= 0){
										SQLBarrageLevels.setLevel(target, amount);
										player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been set to &c" + SQLBarrageLevels.getLevel(target)));
									}else{
										player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &cYou have entered an unsupported amount!"));
									}
								}catch (NumberFormatException e1){
									player.sendMessage(invalidNumberException);
								}
							}else if(giveortake.equals("reset")){
								try{
									SQLBarrageLevels.setLevel(target, 0);
									player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been set to &c" + SQLBarrageLevels.getLevel(target)));
								}catch (NumberFormatException e1){
									player.sendMessage(invalidNumberException);
								}
							}else if(giveortake.equals("get")){
								player.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + " &eis level &c" + SQLBarrageLevels.getLevel(target)));
							}else{
								player.sendMessage(incompleteCommand);
							}
						}else{
							player.sendMessage(noPerms);
						}
						}else{
							player.sendMessage(invalidPlayer);
						}
					}else if(sender instanceof ConsoleCommandSender){
						if(giveortake.equals("give")){
							try{
								if(SQLBarrageLevels.getLevel(target) + amount <= 100 && SQLBarrageLevels.getLevel(target) + amount >= 0){
									SQLBarrageLevels.addLevel(target, amount);
									sender.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been set to &c" + SQLBarrageLevels.getLevel(target)));
								}else{
									sender.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &cYou have entered an unsupported amount!"));
								}
							}catch (NumberFormatException e1){
								sender.sendMessage(invalidNumberException);
							}
						}else if(giveortake.equals("take")){
							try{
								if(SQLBarrageLevels.getLevel(target) - amount <= 100 && SQLBarrageLevels.getLevel(target) - amount >= 0){
									SQLBarrageLevels.removeLevel(target, amount);
									sender.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been set to &c" + SQLBarrageLevels.getLevel(target)));
								}else{
									sender.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &cYou have entered an unsupported amount!"));
								}
							}catch (NumberFormatException e1){
								sender.sendMessage(invalidNumberException);
							}
						}else if(giveortake.equals("set")){
							try{
								if(amount <= 100 && amount >= 0){
									SQLBarrageLevels.setLevel(target, amount);
									sender.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been set to &c" + SQLBarrageLevels.getLevel(target)));
								}else{
									sender.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &cYou have entered an unsupported amount!"));
								}
							}catch (NumberFormatException e1){
								sender.sendMessage(invalidNumberException);
							}
						}else if(giveortake.equals("reset")){
							try{
								SQLBarrageLevels.setLevel(target, 0);
								sender.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + "'s &elevel have been set to &c" + SQLBarrageLevels.getLevel(target)));
							}catch (NumberFormatException e1){
								sender.sendMessage(invalidNumberException);
							}
						}else if(giveortake.equals("get")){
							sender.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &c" + target.getName() + " &eis level &c" + SQLBarrageLevels.getLevel(target)));
						}else{
							sender.sendMessage(incompleteCommand);
						}
					}
				}else{
					sender.sendMessage(Utils.color("&8&l[&c&lBarrage&8&l] &cYou have entered an unsupported amount!"));
				}
			}
			}
			return true;
		}
}
