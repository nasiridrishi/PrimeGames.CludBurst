package net.primegames.core;

import com.nukkitx.protocol.bedrock.BedrockServerSession;
import lombok.Getter;
import lombok.Setter;
import net.primegames.core.Utils.LoggerUtils;
import net.primegames.core.Utils.Utils;
import net.primegames.core.chat.Chat;
import net.primegames.core.chat.ChatFactory;
import net.primegames.core.chat.ChatId;
import net.primegames.core.component.combatLogger.CombatLogHeartBeat;
import net.primegames.core.group.Group;
import net.primegames.core.group.GroupIds;
import net.primegames.core.player.CorePlayerDataStore;
import net.primegames.core.providor.task.player.punishment.MySQLPunishPlayerTask;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.utils.ClientChainData;

import java.sql.Date;
import java.util.ArrayList;

public class CorePlayer extends Player{

    public final String STATUS_LOADING = "status.loading";
    public final String STATUS_REGISTER_PENDING = "status.registration_pending";
    public final String STATUS_ONLINE = "status.loaded";
    public final String STATUS_UPDATING = "status.updating";

    private Chat chat;

    private Boolean muted = false;

    private ArrayList<CorePlayer> ignoredPlayers = new ArrayList<>();


    private String status = STATUS_LOADING;

    private CorePlayerDataStore databaseData;

    private ArrayList<Group> groups = new ArrayList<>();

    public CorePlayer(BedrockServerSession session, ClientChainData chainData) {
        super(session, chainData);
        addGroup(Core.getInstance().getGroupManager().getGroup(GroupIds.MORTAL));
        chat = ChatFactory.getChat(ChatId.MAIN_CHAT);
    }

    public ArrayList<Group> getGroups(){
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group){
        if(hasGroup(group)){
            LoggerUtils.error("Tried to re-add an existing group to CorePlayer");
            return;
        }
        //todo send message to player
        //todo save to db
        groups.add(group);
    }

    public void removeGroup(Group group){
        if(groups.remove(group)){
            //todo save tp db
            //todo send transble
            sendMessage(group.getName() + " was removed");
        }else {
            LoggerUtils.warn("Tried to remove a group which " + getName() + " did not have");
        }
    }

    public boolean hasGroupPermission(String permission){
        for (Group group:groups){
            if(group.hasPermission(permission)){
                return true;
            }
        }
        return  false;
    }

    public Group getHighestPriorityGroup(){
        Group result = null;
        for (Group group: groups){
            if(result == null){
                result  = group;
            } else if (group.getPriorityLevel() > result.getPriorityLevel()){
                result = group;
            }
        }
        return result;
    }

    public boolean hasGroup(Group group){
        return groups.contains(group);
    }

    public Chat getChat(){
        return chat;
    }


    public void setChat(Chat chat){
        this.chat = chat;
    }



    public void setDatabaseData(CorePlayerDataStore databaseData) {
        this.databaseData = databaseData;
    }

    public CorePlayerDataStore getCoreDataStore() {
        return databaseData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean isLoaded(){
        return status.equals(STATUS_ONLINE);
    }

    public ArrayList<CorePlayer> getIgnoredPlayers() {
        return ignoredPlayers;
    }

    public boolean isIgnored(CorePlayer player){
        for(CorePlayer ignored:ignoredPlayers){
            if(player.getName().equals(ignored.getName())){
                return true;
            }
        }
        return false;
    }

    public void setIgnoredPlayers(ArrayList<CorePlayer> ignoredPlayers) {
        this.ignoredPlayers = ignoredPlayers;
    }

    public void unIgnorePlayer(CorePlayer player){
        if(isIgnored(player)){
            ignoredPlayers.remove(player);
        }
    }

    public void ignorePlayer(CorePlayer player){
        if(!isIgnored(player)){
            ignoredPlayers.add(player);
        }
    }

    public void sentence(String reason, String effector, Date expiration, int category){
        Core.getInstance().getMySQLProvider().scheduleTask(new MySQLPunishPlayerTask(getName(), effector, reason, getServerId().toString(), expiration, getAddress(), category));
    }

    public void mute(){
        muted = true;
    }

    public boolean isMuted(){
        return muted;
    }

    public void unmute(){
        muted = false;
    }

    public static CorePlayer cast(Player player){
        return (CorePlayer)player;
    }

    public int getFloorX(){
        return (int) this.getX();
    }

    public int getFloorY(){
        return (int) this.getY();
    }

    public int getFloorZ(){
        return (int) this.getZ();
    }

}
