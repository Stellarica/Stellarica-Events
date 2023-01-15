package net.stellarica.oxidizer.event.item

import net.minecraft.recipe.Recipe
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] attempts to craft an item either in a crafting table or in their inventory.
 */
object ItemCraftEvent : net.stellarica.oxidizer.event.Event<ItemCraftEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val recipe: Recipe<*>)
}