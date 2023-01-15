package net.stellarica.oxidizer.event.entity

import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.stellarica.oxidizer.event.Event

/**
 * Called before [LivingEntity] is spawned.
 */
object EntitySpawnEvent : Event<EntitySpawnEvent.EventData>() {
	data class EventData(val entity: Entity)
}