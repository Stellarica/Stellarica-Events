package io.github.hydrazinemc.oxidiser.event.player

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.network.Packet
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when packet is sent from server to [ServerPlayerEntity]
 */
object PlayerS2CPacketEvent : Event<PlayerS2CPacketEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val packet: Packet<*>)
}