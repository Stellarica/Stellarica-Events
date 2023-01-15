package net.stellarica.oxidizer.event.entity

import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.stellarica.oxidizer.event.Event
import java.util.List

/**
 * Called when a [LivingEntity] drops its items on death.
 */
object EntityDropItemsEvent : Event<EntityDropItemsEvent.EventData>() {
	data class EventData(val dropper: LivingEntity, val items: List<ItemStack>)
}