package net.stellarica.oxidizer.event.player

import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.oxidizer.event.Event

/**
 * Called when any [ServerPlayerEntity] attempts to switch items in offhand
 */
object PlayerSwapWithOffhandEvent : Event<PlayerSwapWithOffhandEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity)
}