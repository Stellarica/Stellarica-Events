package net.stellarica.oxidizer.event.block

import net.minecraft.block.BlockState
import net.minecraft.entity.LivingEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when a [LivingEntity] attempts to trample a block, such as farmland or turtle eggs.
 */

object BlockTrampleEvent : net.stellarica.oxidizer.event.Event<BlockTrampleEvent.EventData>() {
	data class EventData(
		val entity: LivingEntity,
		val world: ServerWorld,
		val pos: BlockPos,
		val from: BlockState,
		val to: BlockState
	)
}