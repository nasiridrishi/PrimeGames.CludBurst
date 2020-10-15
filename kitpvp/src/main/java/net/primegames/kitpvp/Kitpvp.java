package net.primegames.kitpvp;

import net.primegames.core.Core;
import net.primegames.core.plugin.CorePlugin;
import net.primegames.kitpvp.kit.ClassicKit;
import net.primegames.kitpvp.listener.KitpvpCustomPlayerListener;
import net.primegames.kitpvp.listener.PlayerKitListener;
import net.primegames.kitpvp.settings.Settings;
import net.primegames.kitpvp.settings.presets.ClassicSettings;

public class Kitpvp extends CorePlugin {

    private static Kitpvp instance;

    private Settings settings;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        setSettings();
        registerListeners();
        registerKits();
    }


    private void registerListeners(){
        getServer().getPluginManager().registerEvents(new KitpvpCustomPlayerListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerKitListener(), this);
    }

    private Settings getSettings(){
        return settings;
    }

    private void setSettings(){
        if(ClassicSettings.class.getSuperclass().equals(Settings.class)){
            this.settings = new ClassicSettings();
        }else {
            getLogger().error("Trying to set as settings class an object that does not extend Settings: " + ClassicSettings.class.toString());
        }
    }

    private void registerKits(){
        Core.getInstance().getKitFactory().registerKit(new ClassicKit());
    }


    public static Kitpvp getInstance(){
        return instance;
    }
}
