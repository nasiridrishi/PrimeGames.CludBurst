package net.primegames.kitpvp;

import com.nukkitx.protocol.bedrock.BedrockServerSession;
import lombok.Getter;
import lombok.Setter;
import net.primegames.core.CorePlayer;
import net.primegames.core.Utils.CoreScoreBoard;
import net.primegames.core.component.killtracker.tracker.HasKillTracker;
import net.primegames.core.component.killtracker.tracker.KillTrackerDataStore;
import net.primegames.core.economy.balance.Balance;
import net.primegames.core.economy.balance.contract.BalanceHolder;
import net.primegames.kitpvp.player.KitPvPScoreBoard;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.utils.ClientChainData;

public class KitpvpPlayer extends CorePlayer implements HasKillTracker, BalanceHolder {

    @Setter private KillTrackerDataStore killTracker;

    @Setter private Balance balance;

    public KitpvpPlayer(BedrockServerSession session, ClientChainData chainData) {
        super(session, chainData);
        killTracker = new KillTrackerDataStore(this);
    }

    public static KitpvpPlayer cast(Player player){
        return (KitpvpPlayer)player;
    }

    @Override
    public KillTrackerDataStore getKillTracker() {
        return killTracker;
    }

    @Override
    public Balance getBalance() {
        return balance;
    }
}
