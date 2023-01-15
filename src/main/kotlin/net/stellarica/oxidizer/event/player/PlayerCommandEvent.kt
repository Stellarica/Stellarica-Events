package net.stellarica.oxidizer.event.player

import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.oxidizer.event.Event

/**
 * Called when a [ServerPlayerEntity] executes a command through chat.
 */
object PlayerCommandEvent : Event<PlayerCommandEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val command: String)
}