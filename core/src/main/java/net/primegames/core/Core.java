package net.primegames.core;

import com.google.common.base.Preconditions;
import net.primegames.core.Utils.LoggerUtils;
import net.primegames.core.chat.ChatFactory;
import net.primegames.core.command.staff.mod.BanCommand;
import net.primegames.core.command.staff.trainee.KickCommand;
import net.primegames.core.command.staff.trainee.MuteCommand;
import net.primegames.core.group.GroupManager;
import net.primegames.core.kit.KitFactory;
import net.primegames.core.listener.ChatListener;
import net.primegames.core.listener.CustomCorePlayerListener;
import net.primegames.core.listener.PlayerLoadedListener;
import net.primegames.core.plugin.CorePlugin;
import net.primegames.core.providor.MySQLProvider;
import net.primegames.core.providor.task.MySQLInitialCoreTask;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.command.Command;
import org.cloudburstmc.server.command.PluginCommand;
import org.cloudburstmc.server.registry.CommandRegistry;
import org.cloudburstmc.server.scheduler.Task;
import org.slf4j.Logger;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Core {
    private final Logger logger;
    private final CorePlugin corePlugin;
    private final Path dataFolder;
    private final Server server;


    private static Core instance = null;
    private final MySQLProvider mySQLProvider;
    private final KitFactory kitFactory;
    private final GroupManager groupManager;
    private final ArrayList<String> ignoreList = new ArrayList<>(Arrays.asList("stop", "help", "list", "plugins", "whitelist", "gamemode"));


    public Core(CorePlugin corePlugin, Logger logger, Path dataFolder, Server server) {
        this.logger = logger;
        this.corePlugin = corePlugin;
        this.dataFolder = dataFolder;
        this.server = server;
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
        server.getScheduler().scheduleDelayedTask(new Task() {
            @Override
            public void onRun(int currentTick) {
                mySQLProvider.scheduleTask(new MySQLInitialCoreTask());
            }
        }, 20);
    }

    private void registerCoreCommands() {
        CommandRegistry registry = server.getCommandRegistry();
        registry.register(corePlugin, new KickCommand());
        registry.register(corePlugin, new BanCommand());
        registry.register(corePlugin, new MuteCommand());
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
        Map<String, Command> commandEntries = server.getCommandRegistry().getRegisteredCommands();
        ArrayList<Command> commands = new ArrayList<>();
        for (Map.Entry<String, Command> commandEntry : commandEntries.entrySet()) {
            if (!(commandEntry.getValue() instanceof PluginCommand)) {
                commands.add(commandEntry.getValue());
            }
        }
        for (Command command : commands) {
            if(!ignoreList.contains(command.getName())){
                server.getCommandRegistry().unregister(corePlugin, command.getName());
            }
        }
        LoggerUtils.info("Unregistered default server commands");
    }

    public static Core getInstance() {
        return instance;
    }

    protected void registerListeners() {
        corePlugin.getEventManager().registerListeners(corePlugin, new ChatListener());
        corePlugin.getEventManager().registerListeners(corePlugin, new CustomCorePlayerListener());
        corePlugin.getEventManager().registerListeners(corePlugin, new PlayerLoadedListener());
    }

    public Server getServer() {
        return server;
    }

    public Logger getLogger() {
        return logger;
    }

    public CorePlugin getCorePlugin() {
        return corePlugin;
    }

    public Path getDataFolder() {
        return dataFolder;
    }
}
