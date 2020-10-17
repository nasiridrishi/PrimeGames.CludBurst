/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.command.sentence;

import net.primegames.core.CorePlayer;
import net.primegames.core.command.CoreCommand;
import net.primegames.core.group.Permissions;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.command.CommandSender;
import org.cloudburstmc.server.command.ConsoleCommandSender;
import org.cloudburstmc.server.command.data.CommandData;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.utils.TextFormat;

import java.util.Arrays;

public class KickCommand extends CoreCommand {

    public KickCommand() {
        super(CommandData.builder("kick").build());
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if(!(sender instanceof ConsoleCommandSender)){
            if(checkPermission((CorePlayer) sender, Permissions.COMMAND_KICK)){
                return false;
            }
        }
        if(args.length < 1){
            sender.sendMessage(getUsage());
            return false;
        }
        Player target = Server.getInstance().getPlayer(args[0]);
        if(target == null){
            sender.sendMessage(TextFormat.RED + "Player is not online");
            return false;
        }
        String reason = "Undefined reason";
        if(args.length > 1){
            String[] reasonArgs = Arrays.copyOfRange(args, 1, args.length);
            reason = Arrays.toString(reasonArgs);
        }
        target.kick(sender.getName() + " kicked you for " + reason);
        return true;
    }


}
