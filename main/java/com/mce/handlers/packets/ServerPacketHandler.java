package com.mce.handlers.packets;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;

public class ServerPacketHandler {
	protected String channelName;
	protected EntityPlayerMP thePlayer;

	@SubscribeEvent
	public void onServerPacket(ServerCustomPacketEvent event)
			throws IOException {
		channelName = event.packet.channel();

		NetHandlerPlayServer theNetHandlerPlayServer = (NetHandlerPlayServer) event.handler;
		thePlayer = theNetHandlerPlayServer.playerEntity;

		if (channelName.equals(mod_IDT.networkChannelName)) {
			// DEBUG
			System.out.println("Server received packet from player = "
					+ thePlayer.getEntityId());
			ProcessPacketServerSide
					.processPacketOnServer(event.packet.payload(),
							event.packet.getTarget(), thePlayer);
		}
	}
}