package net.stellarica.oxidizer.event.item

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand
import net.stellarica.oxidizer.event.Event

/**
 * Called when a [ServerPlayerEntity] attempts to use an item by interacting.
 */
object ItemUseEvent : Event<ItemUseEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val hand: Hand)
}