/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.command;

import net.primegames.core.Core;
import net.primegames.core.CorePlayer;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.command.*;
import org.cloudburstmc.server.command.data.CommandData;
import org.cloudburstmc.server.player.Player;

abstract public class CoreCommand extends Command{


    public CoreCommand(CommandData data) {
        super(data);
    }

    public CorePlayer getPlayerExact(String username){
        Player player = Server.getInstance().getPlayerExact(username);
        if(player != null){
            return CorePlayer.cast(player);
        }
        return null;
    }


    public CorePlayer getPlayer(String username){
        Player player = Server.getInstance().getPlayer(username);
        if(player != null){
            return CorePlayer.cast(player);
        }
        return null;
    }

    public boolean isConsole(CommandSender sender){
        return sender instanceof ConsoleCommandSender;
    }

    public boolean isCorePlayer(CommandSender sender){
        return sender instanceof CorePlayer;
    }

    public boolean checkPermission(CorePlayer player, String permission){
        return player.hasGroupPermission(permission);
    }
}
