package net.stellarica.events.entity

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.stellarica.events.Event

/**
 * Called when a [LivingEntity] is damaged.
 */
object EntityDamageEvent : Event<EntityDamageEvent.EventData>() {
	data class EventData(val entity: LivingEntity, val source: DamageSource, val amount: Float)
}