package net.stellarica.events.world

import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.stellarica.events.Event

/**
 * Called when fire attempts to tick in the world.
 */
object FireTickEvent : Event<FireTickEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos)
}