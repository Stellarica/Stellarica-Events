package net.stellarica.oxidiser.event.entity

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource

/**
 * Called when a [LivingEntity] is damaged.
 */
object EntityDamageEvent : net.stellarica.oxidiser.event.Event<EntityDamageEvent.EventData>() {
	data class EventData(val entity: LivingEntity, val source: DamageSource, val amount: Float)
}