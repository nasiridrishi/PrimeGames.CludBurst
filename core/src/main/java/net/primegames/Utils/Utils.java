/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.Utils;



import cn.nukkit.utils.TextFormat;

import java.sql.Date;
import java.util.Calendar;

public class Utils {

    // Colors
    private static final String AQUA = "{AQUA}";
    private  static final String BLACK = "{BLACK}";
    private  static final String BLUE = "{BLUE}";
    private  static final String DARK_AQUA = "{DARK_AQUA}";
    private  static final String DARK_BLUE = "{DARK_BLUE}";
    private  static final String DARK_GRAY = "{DARK_GRAY}";
    private  static final String DARK_GREEN = "{DARK_GREEN}";
    private  static final String DARK_RED = "{DARK_RED}";
    private  static final String DARK_PURPLE = "{DARK_PURPLE}";
    private  static final String GOLD = "{GOLD}";
    private  static final String GRAY = "{GRAY}";
    private  static final String GREEN = "{GREEN}";
    private  static final String LIGHT_PURPLE = "{LIGHT_PURPLE}";
    private  static final String ORANGE = "{ORANGE}";
    private  static final String PINK = "{LIGHT_PURPLE}";
    private  static final String RED = "{RED}";
    private  static final String WHITE = "{WHITE}";
    private  static final String YELLOW = "{YELLOW}";

    // Formatting
    private  static final String BOLD = "{BOLD}";
    private  static final String OBFUSCATED = "{OBFUSCATED}";
    private  static final String STRIKETHROUGH = "{STRIKETHROUGH}";
    private  static final String UNDERLINE = "{UNDERLINE}";
    private  static final String ITALIC = "{ITALIC}";
    private  static final String RESET = "{RESET}";

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

}
