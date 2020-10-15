/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.Utils;

import com.nukkitx.protocol.bedrock.compat.NoopBedrockPacketHelper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.UUID;

public class Utils {

    public static byte[] toBinary(UUID uuid) {
        byte[] bytes = new byte[16];
        ByteBuf buf = Unpooled.wrappedBuffer(bytes).writerIndex(0);   //wrapBuffer(bytes).writerIndex(0);
        NoopBedrockPacketHelper.INSTANCE.writeUuid(buf, uuid);
        return bytes;
    }

}
