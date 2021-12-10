/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.Utils;

import cn.nukkit.scheduler.Task;
import cn.nukkit.scheduler.TaskHandler;
import net.primegames.Core;

import java.time.Instant;

public class HeartBeat {

    private int heartBeat = 0;

    private TaskHandler perSecScheduler;

    private Task task = null;

    private Long initStamp = Instant.now().getEpochSecond();

    public HeartBeat(){
        init();
    }

    private void init(){
        perSecScheduler = Core.getInstance().getServer().getScheduler().scheduleRepeatingTask(task = new Task() {
            @Override
            public void onRun(int currentTick)  {
                onRunPerSec();
            }
        }, 20);
    }

    public void onRunPerSec(){
    }

    public TaskHandler getPerSecScheduler() {
        return perSecScheduler;
    }

    public int getHeartBeat() {
        return heartBeat;
    }

    public Task getTask() {
        return task;
    }

    public int getHeartBeatInSec(){
        return Math.floorMod(heartBeat, 20);
    }

    public void stopBeat(){
        if(task != null){
            Core.getInstance().getServer().getScheduler().cancelTask(task.getTaskId());
            task = null;
            perSecScheduler = null;
        }
    }
}
