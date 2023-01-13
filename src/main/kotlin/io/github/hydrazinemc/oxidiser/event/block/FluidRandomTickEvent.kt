package io.github.hydrazinemc.oxidiser.event.block

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.fluid.FluidState
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when a fluid attempts to randomly tick in the world.
 */
object FluidRandomTickEvent : Event<FluidRandomTickEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos, val state: FluidState)
}