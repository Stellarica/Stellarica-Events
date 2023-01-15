package net.stellarica.oxidizer.event.projectile

import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.util.hit.EntityHitResult

/**
 * Called when an [Entity] is hit by a [ProjectileEntity].
 */
object ProjectileHitEntityEvent : net.stellarica.oxidizer.event.Event<ProjectileHitEntityEvent.EventData>() {
	data class EventData(val entity: ProjectileEntity, val result: EntityHitResult)
}