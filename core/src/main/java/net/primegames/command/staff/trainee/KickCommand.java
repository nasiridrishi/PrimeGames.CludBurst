/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.command.staff.trainee;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.utils.TextFormat;
import net.primegames.command.CoreCommand;
import net.primegames.CorePlayer;
import net.primegames.group.Permissions;
import net.primegames.plugin.CorePlugin;

import java.util.Arrays;

public class KickCommand extends CoreCommand {


    public KickCommand() {
        super("kick", CorePlugin.getInstance());
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
