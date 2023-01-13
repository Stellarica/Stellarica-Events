package io.github.hydrazinemc.oxidiser.event.world

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when snow attempts to fall in the world.
 */
object SnowFallEvent : Event<SnowFallEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos)
}