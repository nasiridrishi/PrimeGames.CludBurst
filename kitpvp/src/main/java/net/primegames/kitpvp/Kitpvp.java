package net.primegames.kitpvp;

import com.google.common.base.Preconditions;
import net.primegames.core.Core;
import net.primegames.core.Utils.LoggerUtils;
import net.primegames.core.component.ComponentManager;
import net.primegames.core.component.combatLogger.CombatLoggerComponent;
import net.primegames.core.component.combatLogger.KitPvPCombatLoggerListener;
import net.primegames.core.kit.KitFactory;
import net.primegames.core.plugin.CorePlugin;
import net.primegames.kitpvp.item.FixedHotBarSword;
import net.primegames.kitpvp.kit.ClassicKit;
import net.primegames.kitpvp.listener.*;
import net.primegames.kitpvp.settings.Settings;
import net.primegames.kitpvp.settings.presets.ClassicSettings;
import net.primegames.kitpvp.utils.KitPvPHeartBeat;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.server.ServerInitializationEvent;
import org.cloudburstmc.server.event.server.ServerStartEvent;
import org.cloudburstmc.server.item.ItemFactory;
import org.cloudburstmc.server.item.behavior.ItemIds;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.plugin.Plugin;
import org.cloudburstmc.server.plugin.PluginDescription;
import org.cloudburstmc.server.registry.ItemRegistry;
import org.cloudburstmc.server.utils.Identifier;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

@Plugin(id = "Kitpvp", version = "0.0.1")
public class Kitpvp extends CorePlugin {

    private static Kitpvp instance = null;

    private Settings settings;

    private final Core core;

    @Inject
    private Kitpvp(Logger logger, PluginDescription description, Path dataFolder, Server server) {
        super(logger, description, dataFolder, server);
        core = new Core(this, logger, dataFolder, server);
        Preconditions.checkState(instance == null, "Already initialized!");
        instance = this;
        Server.getInstance().setAutoSave(false);
        ItemRegistry.get().register(ItemIds.DIAMOND_SWORD, FixedHotBarSword::new);
        new KitPvPHeartBeat();
    }

    @Override
    @Listener
    public void onInitialization(ServerInitializationEvent event) {
        core.onInit();
    }

    @Override
    @Listener
    public void onStart(ServerStartEvent event) {
        core.onStartup();
        registerListeners();
        setSettings();
        registerKits();
        ComponentManager.getInstance().addComponent(new CombatLoggerComponent(this));
    }

    private Settings getSettings(){
        return settings;
    }

    private void setSettings(){
        if(ClassicSettings.class.getSuperclass().equals(Settings.class)){
            this.settings = new ClassicSettings();
        }else {
            LoggerUtils.error("Trying to set as settings class an object that does not extend Settings: " + ClassicSettings.class.toString());
        }
    }

    private void registerKits(){
        KitFactory kitFactory = new KitFactory();
        kitFactory.registerKit(new ClassicKit());
    }


    public static Kitpvp getInstance(){
        return instance;
    }


    protected void registerListeners(){
        getEventManager().registerListeners(this, new KitpvpCustomPlayerListener());
        getEventManager().registerListeners(this, new PlayerKitListener());
        getEventManager().registerListeners(this, new ProtectionListener());
        getEventManager().registerListeners(this, new KitPvPCombatLoggerListener());
        getEventManager().registerListeners(this, new ScoreBoardListener());
        getEventManager().registerListeners(this, new KitPvPPlayerLoadListener());
    }

    public Core getCore() {
        return core;
    }

    public ArrayList<KitpvpPlayer> getOnlineKitPlayers(){
        ArrayList<KitpvpPlayer> players = new ArrayList<>();
        for (Map.Entry<UUID, Player> entry: getServer().getOnlinePlayers().entrySet()){
            players.add(KitpvpPlayer.cast(entry.getValue()));
        }
        return players;
    }
}
