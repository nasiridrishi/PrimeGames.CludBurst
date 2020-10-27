/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.command;

import net.primegames.core.CorePlayer;
import org.cloudburstmc.server.command.CommandSender;
import org.cloudburstmc.server.command.data.CommandData;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.utils.TextFormat;

public abstract class PlayerCommand extends CoreCommand{

    public PlayerCommand(CommandData data) {
        super(data);
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if(!(sender instanceof CorePlayer)){
            return false;
        }
        CorePlayer player = CorePlayer.cast((Player) sender);
        if(getGroupPermission() == null || player.hasGroupPermission(getGroupPermission())){
            onCommand((CorePlayer) sender, args);
            return true;
        }else{
            player.sendMessage(TextFormat.RED.toString() + "Not enough permission");
        }
        return false;
    }

    abstract public void onCommand(CorePlayer player, String[] args);

    abstract public String getGroupPermission();
}
