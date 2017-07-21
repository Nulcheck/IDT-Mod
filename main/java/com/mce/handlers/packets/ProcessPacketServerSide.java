package com.mce.handlers.packets;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;

import com.mce.common.mod_IDT;

import cpw.mods.fml.relauncher.Side;

public class ProcessPacketServerSide {

	public ProcessPacketServerSide() {
		// don't need anything here
	}

	public static void processPacketOnServer(ByteBuf parBB, Side parSide,
			EntityPlayerMP parPlayer) throws IOException {
		if (parSide == Side.SERVER) {
			// DEBUG
			System.out.println("Received Packet on Server Side from Player = "
					+ parPlayer.getEntityId());

			ByteBufInputStream bbis = new ByteBufInputStream(parBB);

			int packetTypeID = bbis.readInt();

			// DEBUG
			System.out.println("Packet type ID = " + packetTypeID);

			switch (packetTypeID) {
			case mod_IDT.PACKET_TYPE_C2S_TEST: {
				// DEBUG
				System.out.println("Test packet received");

				int testVal = bbis.readInt();

				// DEBUG
				System.out.println("Test payload value = " + testVal);

				break;
			}

			}
			bbis.close();
		}
	}
}
