package io.github.hydrazinemc.oxidiser.event.projectile

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.util.hit.EntityHitResult

/**
 * Called when an [Entity] is hit by a [ProjectileEntity].
 */
object ProjectileHitEntityEvent : Event<ProjectileHitEntityEvent.EventData>() {
	data class EventData(val entity: ProjectileEntity, val result: EntityHitResult)
}