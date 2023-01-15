package net.stellarica.oxidizer.event.world

import net.minecraft.block.BlockState
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.stellarica.oxidizer.event.Event

/**
 * Called when fluid attempts to flow in the world.
 */
object FluidFlowEvent : Event<FluidFlowEvent.EventData>() {
	data class EventData(
		val world: ServerWorld,
		val fluidPos: BlockPos,
		val fluidBlock: BlockState,
		val flowDirection: Direction,
		val flowTo: BlockPos,
		val flowToBlock: BlockState
	)
}