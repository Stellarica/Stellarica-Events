package io.github.hydrazinemc.oxidiser.event.player

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] executes a command through chat.
 */
object PlayerCommandEvent : Event<PlayerCommandEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val command: String)
}