package net.stellarica.events.player

import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.events.Event

/**
 * Called when any [ServerPlayerEntity] attempts to switch items in offhand
 */
object PlayerSwapWithOffhandEvent : Event<PlayerSwapWithOffhandEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity)
}