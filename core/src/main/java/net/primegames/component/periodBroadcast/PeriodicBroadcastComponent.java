/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.component.periodBroadcast;

import cn.nukkit.Player;
import cn.nukkit.scheduler.Task;
import cn.nukkit.utils.TextFormat;
import net.primegames.component.Component;
import net.primegames.component.ComponentIds;
import net.primegames.CorePlayer;
import net.primegames.plugin.CorePlugin;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class PeriodicBroadcastComponent implements Component {

    private final CorePlugin plugin;
    private final int period;
    ArrayList<String> messages;

    private int periodCount = 0;

    private String prefix = TextFormat.GOLD + "=>" + TextFormat.RESET + " ";

    public PeriodicBroadcastComponent(CorePlugin plugin, ArrayList<String> messages,  int period){
        this.plugin = plugin;
        this.period = period;
        this.messages = messages;
        scheduleBroadCast();
    }

    public PeriodicBroadcastComponent(CorePlugin plugin, ArrayList<String> messages,  int period, String prefix){
        this.plugin = plugin;
        this.period = period;
        this.messages = messages;
        this.prefix = prefix;
        scheduleBroadCast();
    }

    @Override
    public String getIdentifier() {
        return ComponentIds.BROAD_CAST;
    }

    public void scheduleBroadCast(){
        plugin.getServer().getScheduler().scheduleDelayedRepeatingTask(new Task() {
            @Override
            public void onRun(int currentTick) {
                for (CorePlayer player: getOnlineCorePlayers()){
                    player.sendMessage(prefix + messages.get(periodCount));
                    periodCount++;
                    if(periodCount >= messages.toArray().length){
                        periodCount = 0;
                    }
                }
            }
        }, period, period);
    }

    public ArrayList<CorePlayer> getOnlineCorePlayers(){
        ArrayList<CorePlayer> players = new ArrayList<>();
        for (Map.Entry<UUID, Player> entry : plugin.getServer().getOnlinePlayers().entrySet()){
            players.add(CorePlayer.cast(entry.getValue()));
        }
        return players;
    }
}
