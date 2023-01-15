package net.stellarica.oxidizer.event.entity

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource

/**
 * Called when a [LivingEntity] dies.
 */
object EntityDeathEvent : net.stellarica.oxidizer.event.Event<EntityDeathEvent.EventData>() {
	data class EventData(val entity: LivingEntity, val source: DamageSource)
}