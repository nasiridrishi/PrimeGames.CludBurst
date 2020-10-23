package net.primegames.core;

import net.primegames.core.Utils.LoggerUtils;
import net.primegames.core.chat.ChatFactory;
import net.primegames.core.group.GroupManager;
import net.primegames.core.kit.KitFactory;
import net.primegames.core.listener.CustomCorePlayerListener;
import net.primegames.core.plugin.CorePlugin;
import net.primegames.core.providor.MySQLProvider;
import net.primegames.core.providor.task.MySQLInitialCoreTask;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.command.Command;
import org.cloudburstmc.server.command.PluginCommand;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.server.ServerInitializationEvent;
import org.cloudburstmc.server.event.server.ServerStartEvent;
import org.cloudburstmc.server.plugin.Plugin;
import org.cloudburstmc.server.plugin.PluginDescription;
import org.cloudburstmc.server.registry.CommandRegistry;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

@Plugin(id = "Core", version = "0.0.1", authors = {"nasir"}, url = "primegames.net", description = "PrimeGames CorePlugin")
public class Core extends CorePlugin {
    private static Core instance;
    private MySQLProvider mySQLProvider;
    private KitFactory kitFactory;
    private GroupManager groupManager;


    @Inject
    private Core(Logger logger, PluginDescription description, Path dataFolder, Server server) {
        super(logger, description, dataFolder, server);
    }

    @Listener
    public void onInitialization(ServerInitializationEvent event) {
        instance = this;
        unregisterDefaultCommands();
        registerCommands();
        mySQLProvider = new MySQLProvider();
    }

    @Listener
    public void onStart(ServerStartEvent event) {
        mySQLProvider.scheduleTask(new MySQLInitialCoreTask());

        groupManager = new GroupManager();

        ChatFactory.init();

        kitFactory = new KitFactory();
        registerListeners();
    }

    private void registerCommands() {
        CommandRegistry registry = getServer().getCommandRegistry();
//        registry.register(this, new KickCommand());
//        registry.register(this, new BanCommand());
//        registry.register(this, new MuteCommand());
    }

    private void registerListeners() {
        Server.getInstance().getEventManager().registerListeners(getPlugin(), new CustomCorePlayerListener());

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
        Map<String, Command> commandEntries = getServer().getCommandRegistry().getRegisteredCommands();
        ArrayList<Command> commands = new ArrayList<>();
        for (Map.Entry<String, Command> commandEntry : commandEntries.entrySet()) {
            if (!(commandEntry.getValue() instanceof PluginCommand)) {
                commands.add(commandEntry.getValue());
            }
        }
        for (Command command : commands) {
            getServer().getCommandRegistry().unregister(this, command.getName());
        }
        LoggerUtils.info("Unregistered default server commands");
    }

    public static Core getInstance() {
        return instance;
    }
}
