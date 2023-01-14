package net.stellarica.oxidiser.event.item

import net.minecraft.entity.ItemEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] attempts to pick up an item entity from the world.
 */
object ItemPickupEvent : net.stellarica.oxidiser.event.Event<ItemPickupEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val entity: ItemEntity, val stack: ItemStack)
}