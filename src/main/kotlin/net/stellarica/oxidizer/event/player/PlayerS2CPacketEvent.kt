package net.stellarica.oxidizer.event.player

import net.minecraft.network.Packet
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when packet is sent from server to [ServerPlayerEntity]
 */
object PlayerS2CPacketEvent : net.stellarica.oxidizer.event.Event<PlayerS2CPacketEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val packet: Packet<*>)
}