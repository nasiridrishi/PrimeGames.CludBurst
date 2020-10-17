/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.group;

import net.primegames.core.Core;
import net.primegames.core.Utils.LoggerUtils;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.utils.TextFormat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class GroupManager {

    private ArrayList<Group> groups = new ArrayList<>();

    private Class<? extends Group> groupClass = Group.class;

    public GroupManager(){
        initGroups();
    }

    public Group getGroup(int identifier){
        for (Group group: groups){
            if (group.getIdentifier() == identifier){
                return group;
            }
        }
        return null;
    }

    public Group getGroupByName(String name){
        for (Group group: groups){
            if(Objects.equals(group.getName(), name)){
                return group;
            }
        }
        return null;
    }


    public void addGroup(int priorityLevel, String name, int identifier, String chatFormat, String tagFormat, ArrayList<String> permissions)  {
        for (Group group:groups){
            if(identifier == group.getIdentifier()){
                LoggerUtils.warn("Overwriting group " + group.getName() + " with " + name);
            }
        }
        try {
            Constructor<? extends Group> constructor = groupClass.getConstructor(int.class, String.class, int.class, String.class, String.class, ArrayList.class);
            groups.add(constructor.newInstance(priorityLevel, name, identifier, chatFormat, tagFormat, permissions));
        }catch (NoSuchMethodException e){
            LoggerUtils.error(e.toString());
        } catch (IllegalAccessException|InstantiationException|InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void setGroupClass(Class<? extends Group> groupClass){
        this.groupClass = groupClass;
    }

    private void initGroups(){
        addGroup(1, "Mortal", GroupIds.MORTAL, "{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{GRAY}{group}{WHITE}] {player}{GRAY}: {message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{GRAY}{group}{WHITE}] {player}",
                new ArrayList<>(Arrays.asList(
                        "command.clans",
                        "command.lobby",
                        "command.ignore",
                        "command.unignore",
                        "command.tp",
                        "command.shrug",
                        "command.bank",
                        "command.shop",
                        "command.vote",
                        "command.servers",
                        "command.fix",
                        "mine.pvp",
                        "kit.pickaxe",
                        "command.sell",
                        "command.chat")));

        addGroup(2, "Voter", GroupIds.VOTER, "{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{GREEN}{group}{WHITE}] {player}{GRAY}: {WHITE}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{GREEN}{group}{WHITE}]{GRAY}{player}", 
                new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.fix",
                "mine.pvp",
                "kit.picaxe",
                "kit.voter",
                "command.chat",
                "command.sell",
                "skyblock.island-limit:3")));

        addGroup(3, "Ares", GroupIds.ARES, "{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{RED}{group}{WHITE}] {player}{GRAY}: {RED}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{RED}{group}{WHITE}]{RED}{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.fix",
                "slammer.plot-limit:3",
                "mine.pvp",
                "mine.ares",
                "kit.picaxe",
                "kit.voter",
                "kit.ares",
                "command.sell",
                "command.chat",
                "skyblock.island-limit:3")));

        addGroup(4, "Iris", GroupIds.IRIS, "{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{DARK_AQUA}{group}{WHITE}] {player}{GRAY}: {DARK_AQUA}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{DARK_AQUA}{group}{WHITE}]{LIGHT_PURPLE}{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "join.broadcast",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.fix",
                "slammer.plot-limit:4",
                "mine.pvp",
                "mine.ares",
                "mine.iris",
                "kit.pickaxe",
                "kit.voter",
                "kit.ares",
                "kit.iris",
                "command.sell",
                "command.chat",
                "skyblock.island-limit:4")));

        addGroup(5, "Poseidon", GroupIds.POSEIDON, "{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{GOLD}{group}{WHITE}] {player}{GRAY}: {BOLD}{GOLD}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{GOLD}{group}{WHITE}]{DARK_RED}{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.fly",
                "join.broadcast",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.fix",
                "slammer.plot-limit:6",
                "command.color",
                "mine.pvp",
                "mine.ares",
                "mine.iris",
                "mine.poseidon",
                "kit.pickaxe",
                "kit.voter",
                "kit.ares",
                "kit.iris",
                "kit.poseidon",
                "command.sell",
                "command.chat",
                "skyblock.island-limit:5")));

        addGroup(6, "Hades", GroupIds.HADES, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{DARK_PURPLE}{group}{WHITE}] {player}{GRAY}: {DARK_PURPLE}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{DARK_PURPLE}{group}{WHITE}]{DARK_RED}{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.fly",
                "join.broadcast",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.fix",
                "command.sell",
                "slammer.plot-limit:10",
                "command.color",
                "mine.pvp",
                "mine.ares",
                "mine.iris",
                "mine.poseidon",
                "mine.hades",
                "kit.pickaxe",
                "kit.voter",
                "kit.ares",
                "kit.iris",
                "kit.poseidon",
                "kit.hades",
                "command.chat",
                "skyblock.island-limit:6")));

        addGroup(6, "Artist", GroupIds.ARTIST, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{DARK_PURPLE}{group}{WHITE}] {player}{GRAY}: {DARK_PURPLE}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{DARK_PURPLE}{group}{WHITE}]{DARK_RED}{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.fly",
                "join.broadcast",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.fix",
                "command.sell",
                "slammer.plot-limit:10",
                "command.color",
                "mine.pvp",
                "mine.ares",
                "mine.iris",
                "mine.poseidon",
                "mine.hades",
                "kit.pickaxe",
                "kit.voter",
                "kit.ares",
                "kit.iris",
                "kit.poseidon",
                "kit.hades",
                "command.chat",
                "skyblock.island-limit:6")));

        addGroup(7, "Zeus", GroupIds.ZEUS, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{AQUA}{group}{WHITE}] {player}{GRAY}: {AQUA}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{AQUA}{group}{WHITE}]{GOLD}{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.fly",
                "join.broadcast",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.fix",
                "command.sell",
                "slammer.plot-limit:15",
                "command.color",
                "mine.pvp",
                "mine.ares",
                "mine.iris",
                "mine.poseidon",
                "mine.hades",
                "mine.zeus",
                "kit.pickaxe",
                "kit.voter",
                "kit.ares",
                "kit.iris",
                "kit.poseidon",
                "kit.hades",
                "kit.zeus",
                "command.chat",
                "skyblock.island-limit:7")));

        addGroup(8, "Titan", GroupIds.TITAN, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{GREEN}{group}{WHITE}] {player}{GRAY}: {GREEN}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{GREEN}{BOLD}{group}{RESET}{WHITE}]{GREEN}{player}{RESET}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.fly",
                "join.broadcast",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.fix",
                "command.sell",
                "command.color",
                "slammer.plot-limit:10",
                "mine.pvp",
                "mine.ares",
                "mine.iris",
                "mine.poseidon",
                "mine.hades",
                "mine.zeus",
                "mine.titan",
                "kit.pickaxe",
                "kit.voter",
                "kit.ares",
                "kit.iris",
                "kit.poseidon",
                "kit.hades",
                "kit.zeus",
                "kit.titan",
                "command.chat",
                "skyblock.island-limit:8")));

        addGroup(9, "Streamer", GroupIds.STREAMER, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{DARK_PURPLE}{group}{WHITE}] {player}{GRAY}: {DARK_PURPLE}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{DARK_PURPLE}{group}{WHITE}]{DARK_PURPLE}{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.fly",
                "join.broadcast",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.fix",
                "mine.pvp",
                "kit.voter",
                "kit.ares",
                "kit.iris",
                "command.chat")));

        addGroup(50, "Builder", GroupIds.BUILDER, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{GOLD}{group}{WHITE}] {player}{GRAY}: {GOLD}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{GOLD}{group}{WHITE}]{GOLD}{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.fly",
                "slammer.plot-limit:3",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.fix",
                "mine.pvp",
                "chat.staff",
                "kit.voter",
                "kit.ares",
                "kit.iris",
                "command.chat")));

        addGroup(51, "Trainee", GroupIds.TRAINEE, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{YELLOW}{group}{WHITE}] {player}{GRAY}: {YELLOW}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{YELLOW}{group}{WHITE}]{YELLOW}{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "slammer.plot-limit:3",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.vanish",
                "command.mute",
                "command.kick",
                "command.fix",
                "command.staffchat",
                "command.ftp",
                "mine.pvp",
                "chat.staff",
                "command.warn",
                "kit.voter",
                "kit.ares",
                "command.chat"
        )));

        addGroup(52, "Mod", GroupIds.MOD, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{DARK_AQUA}{group}{WHITE}] {player}{GRAY}: {DARK_RED}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{DARK_AQUA}{group}{GREEN}{WHITE}]{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.fly",
                "slammer.plot-limit:3",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.vanish",
                "command.ban",
                "command.mute",
                "command.kick",
                "command.fix",
                "command.ftp",
                "command.staffchat",
                "command.warn",
                "command.unmute",
                "command.alias",
                "mine.pvp",
                "chat.staff",
                "kit.voter",
                "kit.ares",
                "command.chat"
        )));

        addGroup(53, "Admin", GroupIds.ADMIN, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{DARK_AQUA}{group}{WHITE}] {player}{GRAY}: {DARK_RED}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{DARK_AQUA}{group}{WHITE}]{BLUE}{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.fly",
                "join.broadcast",
                "slammer.plot-limit:3",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.vanish",
                "command.ban",
                "command.mute",
                "command.kick",
                "command.fix",
                "command.ftp",
                "plots.bypass-protection",
                "command.unmute",
                "command.staffchat",
                "command.warn",
                "command.unban",
                "command.alias",
                "mine.pvp",
                "chat.staff",
                "kit.voter",
                "kit.ares",
                "kit.iris",
                "command.chat",
                "command.superban")));

        addGroup(59, "Community Manager", GroupIds.COMMUNITY_MANAGER, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{YELLOW}{group}{WHITE}] {player}{GRAY}: {DARK_RED}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{YELLOW}{group}{WHITE}]{YELLOW}{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.fly",
                "slammer.plot-limit:3",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.ban",
                "command.mute",
                "command.kick",
                "command.fix",
                "command.staffchat",
                "command.warn",
                "command.ftp",
                "command.alias",
                "mine.pvp",
                "chat.staff",
                "kit.voter",
                "kit.ares",
                "kit.iris",
                "command.chat",
                "command.superban")));

        addGroup(60, "Head Builder", GroupIds.HEAD_BUILDER, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{GREEN}{group}{WHITE}] {player}{GRAY}: {DARK_RED}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{GREEN}{group}{WHITE}]{GREEN}{player}", new ArrayList<>(Arrays.asList(
                "command.clans",
                "command.lobby",
                "command.ignore",
                "command.unignore",
                "command.fly",
                "join.broadcast",
                "slammer.plot-limit:3",
                "command.tp",
                "command.shrug",
                "command.bank",
                "command.shop",
                "command.vote",
                "command.servers",
                "command.fix",
                "command.ftp",
                "mine.pvp",
                "chat.staff",
                "kit.voter",
                "kit.ares",
                "kit.iris",
                "command.chat")));

        addGroup(100, "LOS", GroupIds.LOS, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{GREEN}{group}{WHITE}]{GREEN} {player}{GOLD}: {GREEN}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{GREEN}{group}{WHITE}]{LIGHT_PURPLE}{player}", new ArrayList<>(Arrays.asList("*")));

        addGroup(101, "Chief", GroupIds.CHIEF, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{GREEN}{group}{WHITE}]{DARK_PURPLE} {player}{GOLD}: {GREEN}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{GREEN}{group}{WHITE}]{DARK_PURPLE}{player}", new ArrayList<>(Arrays.asList("*")));

        addGroup(102, "Developer", GroupIds.DEV, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{DARK_RED}{group}{WHITE}]{RED} {player}{WHITE}: {DARK_PURPLE}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{GREEN}{group}{WHITE}]{DARK_PURPLE}{player}", new ArrayList<>(Arrays.asList("*")));

        addGroup(103, "Owner", GroupIds.OWNER, "{BOLD}{RED}{clan_rank}{DARK_AQUA}{clan}{WHITE}[{BLUE}{group}{WHITE}]{DARK_AQUA} {player}{YELLOW}: {AQUA}{message}", "•{RED}{clan_rank}{DARK_AQUA}{clan}{clan_ln}{WHITE}[{BOLD}{BLUE}{group}{WHITE}]{DARK_AQUA}{player}", new ArrayList<>(Arrays.asList("*")));

    }
}
