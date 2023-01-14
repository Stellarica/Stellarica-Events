package net.stellarica.oxidiser.event.projectile

import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.util.hit.BlockHitResult

/**
 * Called when a [Block] is hit by a [ProjectileEntity].
 */
object ProjectileHitBlockEvent : net.stellarica.oxidiser.event.Event<ProjectileHitBlockEvent.EventData>() {
	data class EventData(val entity: ProjectileEntity, val result: BlockHitResult)
}