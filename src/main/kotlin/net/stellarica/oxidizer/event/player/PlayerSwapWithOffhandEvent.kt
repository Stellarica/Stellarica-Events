package net.stellarica.oxidizer.event.player

import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when any [ServerPlayerEntity] attempts to switch items in offhand
 */
object PlayerSwapWithOffhandEvent : net.stellarica.oxidizer.event.Event<PlayerSwapWithOffhandEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity)
}