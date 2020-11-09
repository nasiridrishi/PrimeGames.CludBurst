package net.primegames.kitpvp;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
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
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class Kitpvp extends CorePlugin {

    private static Kitpvp instance = null;

    private Settings settings;

    private final Core core;

    public Kitpvp(){
        instance = this;
        core = new Core(this);
    }


    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void onEnable() {
        core.onStartup();
        registerListeners();
        setSettings();
        registerKits();
        ComponentManager.getInstance().addComponent(new CombatLoggerComponent(this));
        Item.addCreativeItem(new FixedHotBarSword());
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
        getPluginManager().registerEvents(new KitpvpCustomPlayerListener(), this);
        getPluginManager().registerEvents(new PlayerKitListener(), this);
        getPluginManager().registerEvents(new ProtectionListener(), this);
        getPluginManager().registerEvents(new KitPvPCombatLoggerListener(), this);
        getPluginManager().registerEvents(new ScoreBoardListener(), this);
        getPluginManager().registerEvents(new KitPvPPlayerLoadListener(), this);
        getPluginManager().registerEvents(new KitpvpCombatLoggListener(), this);
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
