package net.stellarica.events.block

import net.minecraft.block.BlockState
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.stellarica.events.Event

/**
 * Called when a block attempts to randomly tick in the world.
 */
object BlockRandomTickEvent : Event<BlockRandomTickEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos, val state: BlockState)
}