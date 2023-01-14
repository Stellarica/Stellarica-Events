package io.github.hydrazinemc.oxidiser.event.entity

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity

/**
 * Called before [LivingEntity] is spawned.
 */
object EntitySpawnEvent : Event<EntitySpawnEvent.EventData>() {
	data class EventData(val entity: Entity)
}