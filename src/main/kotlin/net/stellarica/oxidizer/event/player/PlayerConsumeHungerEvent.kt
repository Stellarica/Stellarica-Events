package net.stellarica.oxidizer.event.player

import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] loses hunger.
 */
object PlayerConsumeHungerEvent : net.stellarica.oxidizer.event.Event<PlayerConsumeHungerEvent.EventData>() {
	data class EventData(
		val player: ServerPlayerEntity,
		val foodLevel: Int,
		val saturation: Float,
		val exhaustion: Float
	)
}