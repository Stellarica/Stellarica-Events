package net.stellarica.events.block

import net.minecraft.fluid.FluidState
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.stellarica.events.Event

/**
 * Called when a fluid attempts to randomly tick in the world.
 */
object FluidRandomTickEvent : Event<FluidRandomTickEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos, val state: FluidState)
}