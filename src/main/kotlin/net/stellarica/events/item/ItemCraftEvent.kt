package net.stellarica.events.item

import net.minecraft.recipe.Recipe
import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.events.Event

/**
 * Called when a [ServerPlayerEntity] attempts to craft an item either in a crafting table or in their inventory.
 */
object ItemCraftEvent : Event<ItemCraftEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val recipe: Recipe<*>)
}