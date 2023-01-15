package net.stellarica.oxidizer.event.entity

import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity

/**
 * Called before [LivingEntity] is spawned.
 */
object EntitySpawnEvent : net.stellarica.oxidizer.event.Event<EntitySpawnEvent.EventData>() {
	data class EventData(val entity: Entity)
}