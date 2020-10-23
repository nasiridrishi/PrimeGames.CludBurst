/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.settings.presets;

import com.nukkitx.math.vector.Vector3f;
import net.primegames.kitpvp.settings.Settings;

public class ClassicSettings extends Settings {
    @Override
    protected String getDefaultWorldName() {
        return "kitpvp";
    }

    @Override
    protected Vector3f getSpawnPoint() {
        return Vector3f.from(-18.5, 108, -11.5);
    }
}
