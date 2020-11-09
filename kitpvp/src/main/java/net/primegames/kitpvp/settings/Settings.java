package net.primegames.kitpvp.settings;

import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3;
import net.primegames.kitpvp.Kitpvp;

public abstract class Settings {

    private final Kitpvp plugin;

    public Settings(){
        this.plugin = Kitpvp.getInstance();
        Level lobby = loadLevel(getDefaultWorldName(), getSpawnPoint());
        plugin.getServer().setDefaultLevel(lobby);
        lobby.setAutoSave(false);
        lobby.setRaining(false);
        lobby.setSpawnLocation(getSpawnPoint());
        lobby.stopTime();

    }

    private Level loadLevel(String $levelName, Vector3 vector3){
        plugin.getServer().loadLevel($levelName);
        Level level = plugin.getServer().getLevelByName($levelName);
        if(level == null){
            throw new RuntimeException("Required world " + $levelName +  " was not found in the worlds folder.");
        }
        level.setSpawnLocation(vector3);
        return level;
    }

    abstract protected String getDefaultWorldName();

    abstract protected Vector3 getSpawnPoint();

}
