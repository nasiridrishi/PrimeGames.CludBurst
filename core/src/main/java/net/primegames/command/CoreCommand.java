/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.command;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.command.PluginCommand;
import net.primegames.CorePlayer;
import net.primegames.plugin.CorePlugin;

abstract public class CoreCommand extends PluginCommand<CorePlugin> {


    public CoreCommand(String name, CorePlugin owner) {
        super(name, owner);
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
