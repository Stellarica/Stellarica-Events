package io.github.hydrazinemc.oxidiser.event.entity

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import java.util.List

/**
 * Called when a [LivingEntity] drops its items on death.
 */
object EntityDropItemsEvent : Event<EntityDropItemsEvent.EventData>() {
	data class EventData(val dropper: LivingEntity, val items: List<ItemStack>)
}