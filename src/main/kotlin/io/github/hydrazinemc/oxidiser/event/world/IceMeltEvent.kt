package io.github.hydrazinemc.oxidiser.event.world

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when ice attempts to melt in the world.
 */
object IceMeltEvent : Event<IceMeltEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos)
}
