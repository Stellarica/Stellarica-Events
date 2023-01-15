package net.stellarica.oxidizer.event.block

import net.minecraft.block.BlockState
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when a block attempts to randomly tick in the world.
 */
object BlockRandomTickEvent : net.stellarica.oxidizer.event.Event<BlockRandomTickEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos, val state: BlockState)
}