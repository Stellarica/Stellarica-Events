package io.github.hydrazinemc.oxidiser.event.player

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] attempts to regenerate health naturally.
 */
object PlayerRegenerateEvent : Event<PlayerRegenerateEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val amount: Float)
}