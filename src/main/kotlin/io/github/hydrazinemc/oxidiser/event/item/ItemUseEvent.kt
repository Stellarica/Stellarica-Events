package io.github.hydrazinemc.oxidiser.event.item

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand

/**
 * Called when a [ServerPlayerEntity] attempts to use an item by interacting.
 */
object ItemUseEvent : Event<ItemUseEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val hand: Hand)
}