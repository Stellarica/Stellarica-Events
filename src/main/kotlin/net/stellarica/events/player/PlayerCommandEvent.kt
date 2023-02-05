package net.stellarica.events.player

import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.events.Event

/**
 * Called when a [ServerPlayerEntity] executes a command through chat.
 */
object PlayerCommandEvent : Event<PlayerCommandEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val command: String)
}