package net.stellarica.oxidiser.event.player

import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] loses hunger.
 */
object PlayerConsumeHungerEvent : net.stellarica.oxidiser.event.Event<PlayerConsumeHungerEvent.EventData>() {
	data class EventData(
		val player: ServerPlayerEntity,
		val foodLevel: Int,
		val saturation: Float,
		val exhaustion: Float
	)
}