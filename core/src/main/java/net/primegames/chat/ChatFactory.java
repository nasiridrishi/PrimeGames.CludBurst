/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.chat;

import net.primegames.chat.rooms.MainChat;
import net.primegames.chat.rooms.WorldChat;

import java.util.ArrayList;

public class ChatFactory {

    static private ArrayList<Chat>  chats = new ArrayList<>();

    static public void init(){
        openChat(new MainChat());
        openChat(new WorldChat());
        openChat(new WorldChat());
    }

    public static ArrayList<Chat> getChats() {
        return chats;
    }

    public static void openChat(Chat chat){
        chats.add(chat);
    }

    public static Chat getChat(String id){
        for (Chat chat: chats){
            if(chat.getId().equals(id)){
                return chat;
            }
        }
        return null;
    }
}
