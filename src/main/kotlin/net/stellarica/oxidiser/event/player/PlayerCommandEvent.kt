package net.stellarica.oxidiser.event.player

import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] executes a command through chat.
 */
object PlayerCommandEvent : net.stellarica.oxidiser.event.Event<PlayerCommandEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val command: String)
}