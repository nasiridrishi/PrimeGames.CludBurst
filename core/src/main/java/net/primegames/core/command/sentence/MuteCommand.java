/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.command.sentence;

import net.primegames.core.CorePlayer;
import net.primegames.core.Utils.Utils;
import net.primegames.core.command.CoreCommand;
import net.primegames.core.group.Permissions;
import net.primegames.core.providor.task.player.punishment.PunishmentCategory;
import org.cloudburstmc.server.command.Command;
import org.cloudburstmc.server.command.CommandSender;
import org.cloudburstmc.server.command.ConsoleCommandSender;
import org.cloudburstmc.server.command.data.CommandData;


public class MuteCommand extends SentenceCommand {

    public MuteCommand() {
        super(CommandData.builder("kick").build());
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
