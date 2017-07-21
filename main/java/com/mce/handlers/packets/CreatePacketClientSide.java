package com.mce.handlers.packets;

import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;

import java.io.IOException;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.network.internal.FMLProxyPacket;

public class CreatePacketClientSide {
	public CreatePacketClientSide() {
		// don't need anything here
	}

	public static FMLProxyPacket createClientToServerTestPacket(int parTestValue)
			throws IOException {
		// DEBUG
		System.out.println("Sending ProcessPacketClientSide on Client Side");

		ByteBufOutputStream bbos = new ByteBufOutputStream(Unpooled.buffer());
		bbos.writeInt(mod_IDT.PACKET_TYPE_C2S_TEST);
		bbos.writeInt(parTestValue);
		FMLProxyPacket thePacket = new FMLProxyPacket(bbos.buffer(),
				mod_IDT.networkChannelName);
		bbos.close();

		return thePacket;
	}

	public static void sendToServer(FMLProxyPacket parPacket) {
		mod_IDT.channel.sendToServer(parPacket);
	}

	public static void sendTestPacket(int parTestData) {
		try {
			sendToServer(createClientToServerTestPacket(parTestData));
		} catch (IOException e) {
			System.out.println("An error has occurred! Error ID: IDT-305");
			e.printStackTrace();
		}
	}
}