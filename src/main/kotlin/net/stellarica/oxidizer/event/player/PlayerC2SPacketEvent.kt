package net.stellarica.oxidizer.event.player

import net.minecraft.network.Packet
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] sends a packets to server
 */
object PlayerC2SPacketEvent : net.stellarica.oxidizer.event.Event<PlayerC2SPacketEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val packet: Packet<*>)
}