package net.stellarica.events.event.player

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand
import net.stellarica.events.event.Event

/**
 * Called when a [ServerPlayerEntity] swings their hand.
 */
object PlayerSwingHandEvent : Event<PlayerSwingHandEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val hand: Hand)
}