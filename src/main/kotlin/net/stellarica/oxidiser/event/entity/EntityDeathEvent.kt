package net.stellarica.oxidiser.event.entity

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource

/**
 * Called when a [LivingEntity] dies.
 */
object EntityDeathEvent : net.stellarica.oxidiser.event.Event<EntityDeathEvent.EventData>() {
	data class EventData(val entity: LivingEntity, val source: DamageSource)
}