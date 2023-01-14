package net.stellarica.oxidiser.event.item

import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] attempts to drop an item, from the hotbar or from the inventory.
 * Do note that the provided slot may be negative on certain circumstances, so proceed with caution.
 */
object ItemThrowEvent : net.stellarica.oxidiser.event.Event<ItemThrowEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val slot: Int, val stack: ItemStack)
}
