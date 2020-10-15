package net.primegames.core;

import net.primegames.core.kit.KitFactory;
import net.primegames.core.listener.CustomCorePlayerListener;
import net.primegames.core.listener.SessionListener;
import net.primegames.core.providor.MySQLProvider;
import net.primegames.core.providor.task.MySQLInitialCoreTask;
import org.cloudburstmc.server.plugin.PluginBase;

import java.sql.SQLException;


public class Core extends PluginBase {

    private static Core instance;
    private MySQLProvider mySQLProvider;
    private KitFactory kitFactory;

    public static Core getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        mySQLProvider = new MySQLProvider();
        mySQLProvider.scheduleTask(new MySQLInitialCoreTask());

        kitFactory = new KitFactory();
        getServer().getPluginManager();
        registerListeners();

    }

    @Override
    public void onDisable() {

        //close the connection with SQL DB
        try {
            getMySQLProvider().getConnection().close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new CustomCorePlayerListener(), this);
        getServer().getPluginManager().registerEvents(new SessionListener(), this);
    }

    public KitFactory getKitFactory() {
        return this.kitFactory;
    }

    public MySQLProvider getMySQLProvider() {
        return mySQLProvider;
    }
}
