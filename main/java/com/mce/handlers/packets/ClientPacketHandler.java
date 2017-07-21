package com.mce.handlers.packets;

import java.io.IOException;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;

public class ClientPacketHandler extends ServerPacketHandler {
	@SubscribeEvent
	public void onClientPacket(ClientCustomPacketEvent event)
			throws IOException {
		channelName = event.packet.channel();
		if (channelName.equals(mod_IDT.networkChannelName)) {
			// DEBUG
			System.out.println("Client received packet from server");

			ProcessPacketClientSide.processPacketOnClient(
					event.packet.payload(), event.packet.getTarget());
		}
	}
}