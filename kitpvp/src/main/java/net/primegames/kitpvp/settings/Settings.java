package net.primegames.kitpvp.settings;

import com.nukkitx.math.vector.Vector3f;
import net.primegames.kitpvp.Kitpvp;
import org.cloudburstmc.server.level.Level;

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

    private Level loadLevel(String $levelName, Vector3f vector3){
        plugin.getServer().loadLevel().id($levelName)
                .load();
        Level level = plugin.getServer().getLevel($levelName);
        if(level == null){
            throw new RuntimeException("Required world " + $levelName +  " was not found in the worlds folder.");
        }
        level.setSpawnLocation(vector3);
        return level;
    }

    abstract protected String getDefaultWorldName();

    abstract protected Vector3f getSpawnPoint();

}
