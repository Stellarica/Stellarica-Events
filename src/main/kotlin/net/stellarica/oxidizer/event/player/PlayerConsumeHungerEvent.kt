package net.stellarica.oxidizer.event.player

import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.oxidizer.event.Event

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