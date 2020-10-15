package net.primegames.kitpvp;

import com.nukkitx.protocol.bedrock.BedrockServerSession;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.utils.ClientChainData;

public class KitpvpPlayer extends Player {

    public KitpvpPlayer(BedrockServerSession session, ClientChainData chainData) {
        super(session, chainData);
    }
}
