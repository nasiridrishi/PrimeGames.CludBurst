/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.group;

import net.primegames.core.CorePlayer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Group {

    private final int priorityLevel;

    private final String name;

    private final int identifier;

    private String chatFormat;

    private String tagFormat;

    private ArrayList<String> permissions = new ArrayList<String>();

    public Group(int priorityLevel, String name, int identifier, String chatFormat, String tagFormat, ArrayList<String> permissions){
        this.priorityLevel = priorityLevel;
        this.name = name;
        this.identifier = identifier;
        this.chatFormat = chatFormat;
        this.tagFormat = tagFormat;
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
        String username = player.getName();

        String format = chatFormat;
        format = format.replace("{player}", username);
        //todo format = format.replace("{clan}", player.getClan);
        //todo formate clan rank
        format = format.replace("{group}", this.name);
        format = format.replace("{message}", message);
        return format;
    }

    public String getTagFormatFor(CorePlayer player){
        String username = player.getName();

        String format = chatFormat;
        format = format.replace("{player}", username);
        //todo format = format.replace("{clan}", player.getClan);
        //todo formate clan rank
        format = format.replace("{group}", this.name);
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
