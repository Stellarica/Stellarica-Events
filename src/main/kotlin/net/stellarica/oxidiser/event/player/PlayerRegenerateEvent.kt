package net.stellarica.oxidiser.event.player

import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] attempts to regenerate health naturally.
 */
object PlayerRegenerateEvent : net.stellarica.oxidiser.event.Event<PlayerRegenerateEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val amount: Float)
}