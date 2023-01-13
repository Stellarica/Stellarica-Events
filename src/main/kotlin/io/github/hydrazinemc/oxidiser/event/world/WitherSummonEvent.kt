package io.github.hydrazinemc.oxidiser.event.world

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when a wither is attempted to be summoned by building its structure in the world.
 */
object WitherSummonEvent : Event<WitherSummonEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos)
}
