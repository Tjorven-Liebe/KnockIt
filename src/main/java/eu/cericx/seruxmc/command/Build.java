package eu.cericx.seruxmc.command;

import de.cericx.coreapi.util.logger.Logger;
import de.cericx.coreapi.util.logger.Prefix;
import de.cericx.coreapi.util.messagebuilder.Message;
import eu.cericx.seruxmc.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Build implements CommandExecutor {

    public Build() {

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0) {
                UUID uuid = player.getUniqueId();
                if (Util.uuids.contains(uuid)) {
                    Util.uuids.remove(uuid);
                    player.sendMessage(Message.get("build.player.disable", "&e&lBauen &cdeaktiviert"));
                } else {
                    Util.uuids.add(uuid);
                    player.sendMessage(Message.get("build.player.enable", "&e&lBauen &aaktiviert"));
                }
            }else
                if(args.length == 1) {
                    Player target = (Player) Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        UUID uuid = target.getUniqueId();
                        if (Util.uuids.contains(uuid)) {
                            target.sendMessage(Message.get("build.target.disable", "&e&lBauen &7von &b%playername% &cdeaktiviert").replace("%playername%", player.getName()).replace("%targetname%", target.getName()));
                            player.sendMessage(Message.get("build.player.target.disable", "&e&lBauen &7für &b %targetname% §cdeaktiviert").replace("%playername%", player.getName()).replace("%targetname%" ,target.getName()));
                        }else {
                            target.sendMessage(Message.get("build.target.enable", "&e&lBauen &7von &b%playername% &aaktiviert").replace("%playername%", player.getName()).replace("%targetname%", target.getName()));
                            player.sendMessage(Message.get("build.player.target.disable", "&e&lBauen &7für &b %targetname% §cdeaktiviert").replace("%playername%", player.getName()).replace("%targetname%" ,target.getName()));
                        }

                    }else
                        player.sendMessage(Prefix.offline(args[0]));
                }else
                    player.sendMessage(Prefix.use("build <Spieler>"));

        }else
        if(args.length == 1) {
            Player target = (Player) Bukkit.getPlayer(args[0]);
            if(target != null) {
                UUID uuid = target.getUniqueId();
                if (Util.uuids.contains(uuid)) {
                    target.sendMessage(Message.get("build.target.disable", "&e&lBauen &7von &bKonsole &cdeaktiviert").replace("%targetname%", target.getName()));
                    sender.sendMessage(Message.get("build.player.target.disable", "&e&lBauen &7für &b %targetname% §cdeaktiviert").replace("%targetname%" ,target.getName()));
                }else {
                    target.sendMessage(Message.get("build.target.enable", "&e&lBauen &7von §bKonsole &aaktiviert").replace("%targetname%", target.getName()));
                    sender.sendMessage(Message.get("build.player.target.disable", "&e&lBauen &7für &b %targetname% §cdeaktiviert").replace("%targetname%" ,target.getName()));
                }
            }else
                sender.sendMessage(Prefix.offline(args[0]));
        }else
            sender.sendMessage(Prefix.use("build <Spieler>"));
        return false;
    }

}
