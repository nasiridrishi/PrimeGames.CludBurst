/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.command.staff.mod;

import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import net.primegames.command.staff.SentenceCommand;
import net.primegames.Core;
import net.primegames.CorePlayer;
import net.primegames.group.Permissions;
import net.primegames.providor.task.player.punishment.PunishmentCategory;


public class BanCommand extends SentenceCommand {


    public BanCommand() {
        super("ban", Core.getInstance().getPlugin());
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if(!(sender instanceof ConsoleCommandSender)){
            if(checkPermission((CorePlayer) sender, Permissions.COMMAND_BAN)){
                return false;
            }
        }
        return addSentence(sender, args, getUsage(), PunishmentCategory.BAN);
    }
}
