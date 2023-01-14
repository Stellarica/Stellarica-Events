package net.stellarica.oxidiser.event.item

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand

/**
 * Called when a [ServerPlayerEntity] attempts to use an item by interacting.
 */
object ItemUseEvent : net.stellarica.oxidiser.event.Event<ItemUseEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val hand: Hand)
}