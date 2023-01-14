package io.github.hydrazinemc.oxidiser.event.entity

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource

/**
 * Called when a [LivingEntity] dies.
 */
object EntityDeathEvent : Event<EntityDeathEvent.EventData>() {
	data class EventData(val entity: LivingEntity, val source: DamageSource)
}