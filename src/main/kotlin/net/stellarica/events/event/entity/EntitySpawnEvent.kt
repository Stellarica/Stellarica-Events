package net.stellarica.events.event.entity

import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.stellarica.events.event.Event

/**
 * Called before [LivingEntity] is spawned.
 */
object EntitySpawnEvent : Event<EntitySpawnEvent.EventData>() {
	data class EventData(val entity: Entity)
}