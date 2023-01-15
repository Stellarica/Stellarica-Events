package net.stellarica.oxidizer.event.projectile

import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.util.hit.BlockHitResult
import net.stellarica.oxidizer.event.Event

/**
 * Called when a [Block] is hit by a [ProjectileEntity].
 */
object ProjectileHitBlockEvent : Event<ProjectileHitBlockEvent.EventData>() {
	data class EventData(val entity: ProjectileEntity, val result: BlockHitResult)
}