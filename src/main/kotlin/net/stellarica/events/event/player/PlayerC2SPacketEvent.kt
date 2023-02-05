package net.stellarica.events.event.player

import net.minecraft.network.Packet
import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.events.event.Event

/**
 * Called when a [ServerPlayerEntity] sends a packets to server
 */
object PlayerC2SPacketEvent : Event<PlayerC2SPacketEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val packet: Packet<*>)
}