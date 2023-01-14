package net.stellarica.oxidiser.event.world

import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when fire attempts to tick in the world.
 */
object FireTickEvent : net.stellarica.oxidiser.event.Event<FireTickEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos)
}