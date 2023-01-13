package io.github.hydrazinemc.oxidiser.event.player

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.server.network.ServerPlayerEntity

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