/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.command.staff;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import net.primegames.core.CorePlayer;
import net.primegames.core.Utils.Utils;
import net.primegames.core.command.CoreCommand;
import net.primegames.core.plugin.CorePlugin;
import net.primegames.core.providor.task.player.punishment.PunishmentCategory;

import java.sql.Date;
import java.util.Arrays;

public abstract class SentenceCommand extends CoreCommand{


    public SentenceCommand(String name, CorePlugin owner) {
        super(name, owner);
    }

    public static boolean addSentence(CommandSender sender, String[] args, String usage, int type){
        if(args.length < 1){
            sender.sendMessage(usage);
            return false;
        }
        Player player = Server.getInstance().getPlayer(args[0]);
        if(player == null){
            sender.sendMessage("Player is not online");
            //todo ban offline player
            return false;
        }
        Date time = null;
        if(args.length  > 1){
            int days;
            try {
                days = Integer.parseInt(args[1]);
            } catch (final NumberFormatException e) {
                sender.sendMessage("time must be in integers ");
                return false;
            }
            time = Utils.addDays(new Date(System.currentTimeMillis()), days);
        }
        String reason = "";
        if(args.length > 2){
            reason = Arrays.toString((Arrays.copyOfRange(args, 2, args.length)));
        }
        CorePlayer target = CorePlayer.cast(player);
        target.sentence(reason, sender.getName(), time, type);
        String banType = "";
        if(type == PunishmentCategory.MUTE){
            banType = "muted";
        }
        if(type == PunishmentCategory.BAN){
            banType = "banned";
        }
        sender.sendMessage("Successfully "+ banType + "  player "+ target.getName());
        return true;
    }
}
