package net.stellarica.events.event.projectile

import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.util.hit.EntityHitResult
import net.stellarica.events.event.Event

/**
 * Called when an [Entity] is hit by a [ProjectileEntity].
 */
object ProjectileHitEntityEvent : Event<ProjectileHitEntityEvent.EventData>() {
	data class EventData(val entity: ProjectileEntity, val result: EntityHitResult)
}