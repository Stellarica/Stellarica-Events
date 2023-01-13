package io.github.hydrazinemc.oxidiser.event.projectile

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.util.hit.BlockHitResult

/**
 * Called when a [Block] is hit by a [ProjectileEntity].
 */
object ProjectileHitBlockEvent : Event<ProjectileHitBlockEvent.EventData>() {
	data class EventData(val entity: ProjectileEntity, val result: BlockHitResult)
}