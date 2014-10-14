package net.novauniverse.novacheat.util;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class JSONText {

    String JSON;
    EntityPlayer player;
    IChatBaseComponent component;
    PacketPlayOutChat packet;

    public JSONText(String JSON, EntityPlayer player) {
        this.JSON = JSON;
        this.player = player;

        this.component = ChatSerializer.a(JSON);
        this.packet = new PacketPlayOutChat(component, true);
    }

    public void playOut() {
        player.playerConnection.sendPacket(packet);
    }
}
