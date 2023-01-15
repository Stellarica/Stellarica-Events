package net.stellarica.oxidizer.event.entity

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource

/**
 * Called when a [LivingEntity] is damaged.
 */
object EntityDamageEvent : net.stellarica.oxidizer.event.Event<EntityDamageEvent.EventData>() {
	data class EventData(val entity: LivingEntity, val source: DamageSource, val amount: Float)
}