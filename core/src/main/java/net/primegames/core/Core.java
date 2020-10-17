package net.primegames.core;

import net.primegames.core.Utils.LoggerUtils;
import net.primegames.core.chat.ChatFactory;
import net.primegames.core.command.sentence.BanCommand;
import net.primegames.core.command.sentence.KickCommand;
import net.primegames.core.command.sentence.MuteCommand;
import net.primegames.core.group.GroupManager;
import net.primegames.core.kit.KitFactory;
import net.primegames.core.listener.ChatListener;
import net.primegames.core.listener.CustomCorePlayerListener;
import net.primegames.core.listener.PlayerLoadedListener;
import net.primegames.core.listener.SessionListener;
import net.primegames.core.providor.MySQLProvider;
import net.primegames.core.providor.task.MySQLInitialCoreTask;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.command.Command;
import org.cloudburstmc.server.command.PluginCommand;
import org.cloudburstmc.server.command.defaults.DefaultGamemodeCommand;
import org.cloudburstmc.server.plugin.PluginBase;
import org.cloudburstmc.server.registry.CommandRegistry;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;


public class Core extends PluginBase {

    private static Core instance;
    private MySQLProvider mySQLProvider;
    private KitFactory kitFactory;
    private GroupManager groupManager;
    public static Core getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
        unregisterDefaultCommands();
        registerCommands();
    }

    @Override
    public void onEnable() {
        mySQLProvider = new MySQLProvider();
        mySQLProvider.scheduleTask(new MySQLInitialCoreTask());

        groupManager = new GroupManager();

        ChatFactory.init();

        kitFactory = new KitFactory();
        registerListeners();

    }

    @Override
    public void onDisable() {
    }

    private void registerCommands(){
        CommandRegistry registry = getServer().getCommandRegistry();
        registry.register(this, new KickCommand());
        registry.register(this, new BanCommand());
        registry.register(this, new MuteCommand());
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new CustomCorePlayerListener(), this);
        getServer().getPluginManager().registerEvents(new SessionListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerLoadedListener(), this);
    }

    public KitFactory getKitFactory() {
        return this.kitFactory;
    }

    public MySQLProvider getMySQLProvider() {
        return mySQLProvider;
    }

    public GroupManager getGroupManager(){
        return groupManager;
    }

    public void unregisterDefaultCommands(){
        Map<String, Command> commandEntries = getServer().getCommandRegistry().getRegisteredCommands();
        ArrayList<Command> commands = new ArrayList<>();
        for (Map.Entry<String, Command> commandEntry:commandEntries.entrySet()){
            if(!(commandEntry.getValue() instanceof PluginCommand)){
                commands.add(commandEntry.getValue());
            }
        }
        for (Command command: commands){
            getServer().getCommandRegistry().unregister(this, command.getName());
        }
        LoggerUtils.info("Unregistered default server commands");
    }
}
