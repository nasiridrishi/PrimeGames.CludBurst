package net.primegames.kitpvp.listener;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerRespawnEvent;
import cn.nukkit.item.ItemID;
import net.primegames.kitpvp.KitpvpPlayer;
import net.primegames.kitpvp.item.FixedHotBarSword;

public class PlayerKitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        setKit(event.getPlayer());
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        event.setDrops(null);
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event){
        setKit(event.getPlayer());
    }

    private void setKit(Player player){
        KitpvpPlayer kitPlayer = KitpvpPlayer.cast(player);
        FixedHotBarSword sword = new FixedHotBarSword();
        sword.setData(kitPlayer);
        kitPlayer.getInventory().setItem(0, sword);
        //Kitpvp.getInstance().getCore().getKitFactory().getKit(KitIds.classicKit).addTo(player);
    }
}
