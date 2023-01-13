package io.github.hydrazinemc.oxidiser.event.block

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.block.BlockState
import net.minecraft.entity.LivingEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when a [LivingEntity] attempts to trample a block, such as farmland or turtle eggs.
 */

object BlockTrampleEvent : Event<BlockTrampleEvent.EventData>() {
	data class EventData(
		val entity: LivingEntity,
		val world: ServerWorld,
		val pos: BlockPos,
		val from: BlockState,
		val to: BlockState
	)
}