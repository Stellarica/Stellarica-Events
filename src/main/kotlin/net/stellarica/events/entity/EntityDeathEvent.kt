package net.stellarica.events.entity

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.stellarica.events.Event

/**
 * Called when a [LivingEntity] dies.
 */
object EntityDeathEvent : Event<EntityDeathEvent.EventData>() {
	data class EventData(val entity: LivingEntity, val source: DamageSource)
}