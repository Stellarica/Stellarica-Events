package io.github.hydrazinemc.oxidiser.event.player

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand

/**
 * Called when a [ServerPlayerEntity] swings their hand.
 */
object PlayerSwingHandEvent : Event<PlayerSwingHandEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val hand: Hand)
}