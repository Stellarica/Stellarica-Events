package net.stellarica.oxidizer.event.player

import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.oxidizer.event.Event

/**
 * Called when a [ServerPlayerEntity] attempts to regenerate health naturally.
 */
object PlayerRegenerateEvent : Event<PlayerRegenerateEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val amount: Float)
}