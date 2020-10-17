/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.Utils;

import com.nukkitx.protocol.bedrock.compat.NoopBedrockPacketHelper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.primegames.core.CorePlayer;
import net.primegames.core.group.Permissions;
import net.primegames.core.providor.task.player.punishment.PunishmentCategory;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.command.CommandSender;
import org.cloudburstmc.server.command.ConsoleCommandSender;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.utils.TextFormat;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.UUID;

public class Utils {

    // Colors
    private static String AQUA = "{AQUA}";
    private  static String BLACK = "{BLACK}";
    private  static String BLUE = "{BLUE}";
    private  static String DARK_AQUA = "{DARK_AQUA}";
    private  static String DARK_BLUE = "{DARK_BLUE}";
    private  static String DARK_GRAY = "{DARK_GRAY}";
    private  static String DARK_GREEN = "{DARK_GREEN}";
    private  static String DARK_RED = "{DARK_RED}";
    private  static String DARK_PURPLE = "{DARK_PURPLE}";
    private  static String GOLD = "{GOLD}";
    private  static String GRAY = "{GRAY}";
    private  static String GREEN = "{GREEN}";
    private  static String LIGHT_PURPLE = "{LIGHT_PURPLE}";
    private  static String ORANGE = "{ORANGE}";
    private  static String PINK = "{LIGHT_PURPLE}";
    private  static String RED = "{RED}";
    private  static String WHITE = "{WHITE}";
    private  static String YELLOW = "{YELLOW}";

    // Formatting
    private  static String BOLD = "{BOLD}";
    private  static String OBFUSCATED = "{OBFUSCATED}";
    private  static String STRIKETHROUGH = "{STRIKETHROUGH}";
    private  static String UNDERLINE = "{UNDERLINE}";
    private  static String ITALIC = "{ITALIC}";
    private  static String RESET = "{RESET}";

    public static String translateColors(String message){
        message = message.replace(BLACK, TextFormat.BLACK.toString());
        message = message.replace(DARK_BLUE, TextFormat.DARK_BLUE.toString());
        message = message.replace(DARK_GREEN, TextFormat.DARK_GREEN.toString());
        message = message.replace(DARK_AQUA, TextFormat.DARK_AQUA.toString());
        message = message.replace(DARK_RED, TextFormat.DARK_RED.toString());
        message = message.replace(DARK_PURPLE, TextFormat.DARK_PURPLE.toString());
        message = message.replace(GOLD, TextFormat.GOLD.toString());
        message = message.replace(GRAY, TextFormat.GRAY.toString());
        message = message.replace(DARK_GRAY, TextFormat.DARK_GRAY.toString());
        message = message.replace(BLUE, TextFormat.BLUE.toString());
        message = message.replace(GREEN, TextFormat.GREEN.toString());
        message = message.replace(AQUA, TextFormat.AQUA.toString());
        message = message.replace(RED, TextFormat.RED.toString());
        message = message.replace(LIGHT_PURPLE, TextFormat.LIGHT_PURPLE.toString());
        message = message.replace(YELLOW, TextFormat.YELLOW.toString());
        message = message.replace(WHITE, TextFormat.WHITE.toString());
        message = message.replace(OBFUSCATED, TextFormat.OBFUSCATED.toString());
        message = message.replace(BOLD, TextFormat.BOLD.toString());
        message = message.replace(STRIKETHROUGH, TextFormat.STRIKETHROUGH.toString());
        message = message.replace(UNDERLINE, TextFormat.UNDERLINE.toString());
        message = message.replace(ITALIC, TextFormat.ITALIC.toString());
        message = message.replace(RESET, TextFormat.RESET.toString());
        message = message.replace(ORANGE, TextFormat.GOLD.toString());
        return message;
    }

    public static Date addDays(Date date, int days){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());
    }

    public static boolean addSentence(CommandSender sender, String[] args, String usage, int type){
        if(args.length < 1){
            LoggerUtils.info("called" + args.length);
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
            int days = 0;
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
