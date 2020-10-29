package net.primegames.kitpvp;

import com.google.common.base.Preconditions;
import net.primegames.core.Core;
import net.primegames.core.Utils.LoggerUtils;
import net.primegames.core.component.ComponentManager;
import net.primegames.core.component.combatLogger.CombatLoggerComponent;
import net.primegames.core.component.combatLogger.KitPvPCombatLoggerListener;
import net.primegames.core.kit.KitFactory;
import net.primegames.core.plugin.CorePlugin;
import net.primegames.kitpvp.kit.ClassicKit;
import net.primegames.kitpvp.listener.KitpvpCustomPlayerListener;
import net.primegames.kitpvp.listener.PlayerKitListener;
import net.primegames.kitpvp.listener.ProtectionListener;
import net.primegames.kitpvp.settings.Settings;
import net.primegames.kitpvp.settings.presets.ClassicSettings;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.server.ServerInitializationEvent;
import org.cloudburstmc.server.event.server.ServerStartEvent;
import org.cloudburstmc.server.plugin.Plugin;
import org.cloudburstmc.server.plugin.PluginDescription;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.nio.file.Path;

@Plugin(id = "Kitpvp", version = "0.0.1")
public class Kitpvp extends CorePlugin {

    private static Kitpvp instance = null;

    private Settings settings;

    private Core core;

    @Inject
    private Kitpvp(Logger logger, PluginDescription description, Path dataFolder, Server server) {
        super(logger, description, dataFolder, server);
        core = new Core(this, logger, dataFolder, server);
        Preconditions.checkState(instance == null, "Already initialized!");
        instance = this;
        Server.getInstance().setAutoSave(false);
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
    }

    public Core getCore() {
        return core;
    }
}
