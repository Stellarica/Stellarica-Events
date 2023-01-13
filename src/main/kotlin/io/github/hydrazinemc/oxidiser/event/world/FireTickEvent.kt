package io.github.hydrazinemc.oxidiser.event.world

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when fire attempts to tick in the world.
 */
object FireTickEvent : Event<FireTickEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos)
}