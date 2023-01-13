package io.github.hydrazinemc.oxidiser.event.player

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.network.Packet
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] sends a packets to server
 */
object PlayerC2SPacketEvent : Event<PlayerC2SPacketEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val packet: Packet<*>)
}