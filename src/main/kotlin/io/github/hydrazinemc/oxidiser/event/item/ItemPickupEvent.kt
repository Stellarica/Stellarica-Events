package io.github.hydrazinemc.oxidiser.event.item

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.entity.ItemEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] attempts to pick up an item entity from the world.
 */
object ItemPickupEvent : Event<ItemPickupEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val entity: ItemEntity, val stack: ItemStack)
}