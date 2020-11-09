/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.settings.presets;

import cn.nukkit.math.Vector3;
import net.primegames.kitpvp.settings.Settings;

public class ClassicSettings extends Settings {
    @Override
    protected String getDefaultWorldName() {
        return "kitpvp";
    }

    @Override
    protected Vector3 getSpawnPoint() {
        return new Vector3(-18.5, 108, -11.5);
    }
}
