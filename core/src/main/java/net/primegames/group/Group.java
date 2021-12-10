/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.group;

import net.primegames.CorePlayer;
import net.primegames.Utils.Utils;

import java.util.ArrayList;
import java.util.Objects;

public class Group {

    private final int priorityLevel;

    private final String name;

    private final int identifier;

    private String chatFormat;

    private String tagFormat;

    private final ArrayList<String> permissions = new ArrayList<>();

    public Group(int priorityLevel, String name, int identifier, String chatFormat, String tagFormat, ArrayList<String> permissions){
        this.priorityLevel = priorityLevel;
        this.name = name;
        this.identifier = identifier;
        this.chatFormat = Utils.translateColors(chatFormat);
        this.tagFormat = Utils.translateColors(tagFormat);
        for (String permission: permissions){
            this.permissions.add(permission.toLowerCase());
        }
    }

    public int getIdentifier() {
        return identifier;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public String getChatFormat() {
        return chatFormat;
    }

    public void setChatFormat(String chatFormat) {
        this.chatFormat = chatFormat;
    }

    public String getChatFormatFor(CorePlayer player, String message){
        String format = forMateTag(player);
        format = format.replace("{message}", message);
        return format;
    }

    public String getTagFormatFor(CorePlayer player){
        return forMateTag(player);
    }

    private String forMateTag(CorePlayer player){
        String username = player.getName();

        String format = chatFormat;
        format = format.replace("{player}", username);
        format = format.replace("{group}", this.name);
        format = format.replace("{clan}", ""); //todo edit after implementing clan
        format = format.replace("{clan_rank}", ""); //todo edit after implementing clan
        return format;
    }

    public String getName() {
        return name;
    }

    public String getTagFormat() {
        return tagFormat;
    }

    public void setTagFormat(String tagFormat) {
        this.tagFormat = tagFormat;
    }

    public ArrayList<String> getPermissions() {
        return permissions;
    }

    public boolean hasPermission(String permission){
        for (String groupPermission: permissions){
            if(Objects.equals(permission.toLowerCase(), groupPermission)){
                return true;
            }else if (Objects.equals(permission, "*")){
                return true;
            }
        }
        return false;
    }

    public void setPermissions(ArrayList<String> permissions) {
        for (String permission: permissions){
            this.permissions.add(permission.toLowerCase());
        }
    }

    public void addPermission(String permission){
        permissions.add(permission.toLowerCase());
    }
}
