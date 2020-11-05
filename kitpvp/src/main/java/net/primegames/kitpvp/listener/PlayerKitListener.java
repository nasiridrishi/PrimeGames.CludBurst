package net.primegames.kitpvp.listener;

import net.primegames.core.kit.KitIds;
import net.primegames.kitpvp.Kitpvp;
import net.primegames.kitpvp.KitpvpPlayer;
import net.primegames.kitpvp.item.FixedHotBarSword;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerDeathEvent;
import org.cloudburstmc.server.event.player.PlayerJoinEvent;
import org.cloudburstmc.server.event.player.PlayerRespawnEvent;
import org.cloudburstmc.server.item.behavior.ItemIds;
import org.cloudburstmc.server.player.Player;

public class PlayerKitListener {

    @Listener
    public void onJoin(PlayerJoinEvent event){
        setKit(event.getPlayer());
    }

    @Listener
    public void onDeath(PlayerDeathEvent event){
        event.setDrops(null);
    }

    @Listener
    public void onRespawn(PlayerRespawnEvent event){
        setKit(event.getPlayer());
    }

    private void setKit(Player player){
        KitpvpPlayer kitPlayer = KitpvpPlayer.cast(player);
        FixedHotBarSword sword = new FixedHotBarSword(ItemIds.DIAMOND_SWORD);
        sword.setData(kitPlayer);
        kitPlayer.getInventory().setItem(0, sword);
        //Kitpvp.getInstance().getCore().getKitFactory().getKit(KitIds.classicKit).addTo(player);
    }
}
