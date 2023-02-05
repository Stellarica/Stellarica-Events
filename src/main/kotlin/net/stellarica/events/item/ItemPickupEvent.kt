package net.stellarica.events.item

import net.minecraft.entity.ItemEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.events.Event

/**
 * Called when a [ServerPlayerEntity] attempts to pick up an item entity from the world.
 */
object ItemPickupEvent : Event<ItemPickupEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val entity: ItemEntity, val stack: ItemStack)
}