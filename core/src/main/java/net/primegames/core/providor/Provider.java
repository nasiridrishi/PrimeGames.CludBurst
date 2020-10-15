/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.providor;

import net.primegames.core.Core;

public abstract class Provider {

    public abstract void scheduleTask(MySqlTask mySqlTask);

}
