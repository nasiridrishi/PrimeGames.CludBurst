/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.command.sentence;

import net.primegames.core.CorePlayer;
import net.primegames.core.Utils.LoggerUtils;
import net.primegames.core.Utils.Utils;
import net.primegames.core.command.CoreCommand;
import net.primegames.core.providor.task.player.punishment.PunishmentCategory;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.command.CommandSender;
import org.cloudburstmc.server.command.data.CommandData;
import org.cloudburstmc.server.player.Player;

import java.sql.Date;
import java.util.Arrays;

public abstract class SentenceCommand{


//    public SentenceCommand(CommandData data) {
//        super(data);
//    }
//
//    public static boolean addSentence(CommandSender sender, String[] args, String usage, int type){
//        if(args.length < 1){
//            LoggerUtils.info("called" + args.length);
//            sender.sendMessage(usage);
//            return false;
//        }
//        Player player = Server.getInstance().getPlayer(args[0]);
//        if(player == null){
//            sender.sendMessage("Player is not online");
//            //todo ban offline player
//            return false;
//        }
//        Date time = null;
//        if(args.length  > 1){
//            int days = 0;
//            try {
//                days = Integer.parseInt(args[1]);
//            } catch (final NumberFormatException e) {
//                sender.sendMessage("time must be in integers ");
//                return false;
//            }
//            time = Utils.addDays(new Date(System.currentTimeMillis()), days);
//        }
//        String reason = "";
//        if(args.length > 2){
//            reason = Arrays.toString((Arrays.copyOfRange(args, 2, args.length)));
//        }
//        CorePlayer target = CorePlayer.cast(player);
//        target.sentence(reason, sender.getName(), time, type);
//        String banType = "";
//        if(type == PunishmentCategory.MUTE){
//            banType = "muted";
//        }
//        if(type == PunishmentCategory.BAN){
//            banType = "banned";
//        }
//        sender.sendMessage("Successfully "+ banType + "  player "+ target.getName());
//        return true;
//    }
}
