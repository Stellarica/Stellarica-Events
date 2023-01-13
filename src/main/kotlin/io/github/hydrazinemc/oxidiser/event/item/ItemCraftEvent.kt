package io.github.hydrazinemc.oxidiser.event.item

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.recipe.Recipe
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] attempts to craft an item either in a crafting table or in their inventory.
 */
object ItemCraftEvent : Event<ItemCraftEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val recipe: Recipe<*>)
}