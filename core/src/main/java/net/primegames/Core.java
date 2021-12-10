/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames;

import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.scheduler.Task;
import com.google.common.base.Preconditions;
import net.primegames.Utils.LoggerUtils;
import net.primegames.chat.ChatFactory;
import net.primegames.command.staff.mod.BanCommand;
import net.primegames.command.staff.trainee.KickCommand;
import net.primegames.command.staff.trainee.MuteCommand;
import net.primegames.group.GroupManager;
import net.primegames.kit.KitFactory;
import net.primegames.listener.ChatListener;
import net.primegames.listener.CustomCorePlayerListener;
import net.primegames.listener.PlayerLoadedListener;
import net.primegames.plugin.CorePlugin;
import net.primegames.providor.MySQLProvider;
import net.primegames.providor.task.MySQLInitialCoreTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Core {


    private static Core instance = null;
    private final MySQLProvider mySQLProvider;
    private final KitFactory kitFactory;
    private final GroupManager groupManager;
    private final ArrayList<String> ignoreList = new ArrayList<>(Arrays.asList("stop", "help", "list", "plugins", "whitelist", "gamemode"));

    private CorePlugin plugin;


    public Core(CorePlugin plugin) {
        this.plugin = plugin;
        Preconditions.checkState(instance == null, "Instance already set!");
        instance = this;
        mySQLProvider = new MySQLProvider();
        groupManager = new GroupManager();
        ChatFactory.init();
        kitFactory = new KitFactory();
    }

    /*
     * This event is called before the server has fully loaded.
     */
    public void onInit() {
        unregisterDefaultCommands();
        registerCoreCommands();
    }

    public void onStartup() {
        registerListeners();
        plugin.getServer().getScheduler().scheduleDelayedTask(new Task() {
            @Override
            public void onRun(int currentTick) {
                mySQLProvider.scheduleTask(new MySQLInitialCoreTask());
            }
        }, 20);
    }

    private void registerCoreCommands() {
        SimpleCommandMap registry = plugin.getServer().getCommandMap();
        registry.register("Core", new KickCommand());
        registry.register("Core", new BanCommand());
        registry.register("Core", new MuteCommand());
    }

    public KitFactory getKitFactory() {
        return this.kitFactory;
    }

    public MySQLProvider getMySQLProvider() {
        return mySQLProvider;
    }

    public GroupManager getGroupManager() {
        return groupManager;
    }

    public void unregisterDefaultCommands() {
        Map<String, Command> commandEntries = plugin.getServer().getCommandMap().getCommands();
        ArrayList<Command> commands = new ArrayList<>();
        for (Map.Entry<String, Command> commandEntry : commandEntries.entrySet()) {
            if (!(commandEntry.getValue() instanceof PluginCommand)) {
                commands.add(commandEntry.getValue());
            }
        }
        for (Command command : commands) {
            if(!ignoreList.contains(command.getName())){
                command.unregister(plugin.getServer().getCommandMap());
            }
        }
        LoggerUtils.info("Unregistered default server commands");
    }

    public static Core getInstance() {
        return instance;
    }

    public CorePlugin getPlugin() {
        return plugin;
    }

    public Server getServer(){
        return plugin.getServer();
    }

    protected void registerListeners() {
        plugin.getServer().getPluginManager().registerEvents(new ChatListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new CustomCorePlayerListener(),  plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerLoadedListener(), plugin);
    }
}
