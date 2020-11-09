/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.command.staff.trainee;

import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import net.primegames.core.Core;
import net.primegames.core.CorePlayer;
import net.primegames.core.command.staff.SentenceCommand;
import net.primegames.core.group.Permissions;
import net.primegames.core.plugin.CorePlugin;
import net.primegames.core.providor.task.player.punishment.PunishmentCategory;


public class MuteCommand extends SentenceCommand {


    public MuteCommand() {
        super("kick", Core.getInstance().getPlugin());
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!(sender instanceof ConsoleCommandSender)) {
            if (checkPermission((CorePlayer) sender, Permissions.COMMAND_BAN)) {
                return false;
            }
        }
        return addSentence(sender, args, getUsage(), PunishmentCategory.MUTE);
    }

}
