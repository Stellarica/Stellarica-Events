package net.stellarica.events.player

import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.events.Event

/**
 * Called when a [ServerPlayerEntity] loses hunger.
 */
object PlayerConsumeHungerEvent : Event<PlayerConsumeHungerEvent.EventData>() {
	data class EventData(
		val player: ServerPlayerEntity,
		val foodLevel: Int,
		val saturation: Float,
		val exhaustion: Float
	)
}