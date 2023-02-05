package net.stellarica.events.item

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand
import net.stellarica.events.Event

/**
 * Called when a [ServerPlayerEntity] attempts to use an item by interacting.
 */
object ItemUseEvent : Event<ItemUseEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val hand: Hand)
}