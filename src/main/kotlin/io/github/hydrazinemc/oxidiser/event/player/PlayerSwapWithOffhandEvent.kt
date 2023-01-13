package io.github.hydrazinemc.oxidiser.event.player

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when any [ServerPlayerEntity] attempts to switch items in offhand
 */
object PlayerSwapWithOffhandEvent : Event<PlayerSwapWithOffhandEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity)
}