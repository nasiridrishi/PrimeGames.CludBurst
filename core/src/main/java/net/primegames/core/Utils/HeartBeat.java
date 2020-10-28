/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.Utils;

import net.primegames.core.Core;
import org.cloudburstmc.server.scheduler.Task;
import org.cloudburstmc.server.scheduler.TaskHandler;

public class HeartBeat {

    private int heartBeat = 0;

    private TaskHandler scheduler;

    private Task task = null;

    public HeartBeat(){
        init();
    }

    private void init(){
        scheduler = Core.getInstance().getServer().getScheduler().scheduleRepeatingTask(task = new Task() {
            @Override
            public void onRun(int currentTick) {
                heartBeat += 1;
                if(heartBeat % 20 == 0){
                    onRunPerSec();
                }
            }
        }, 1);
    }

    public void onRunPerSec(){

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
        }
    }
}
