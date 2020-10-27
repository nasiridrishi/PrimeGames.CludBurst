package net.primegames.kitpvp;

import com.nukkitx.protocol.bedrock.BedrockServerSession;
import net.primegames.core.CorePlayer;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.utils.ClientChainData;

public class KitpvpPlayer extends CorePlayer {

    public KitpvpPlayer(BedrockServerSession session, ClientChainData chainData) {
        super(session, chainData);
    }
}
