package net.stellarica.events.event.world

import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.stellarica.events.event.Event

/**
 * Called when ice attempts to melt in the world.
 */
object IceMeltEvent : Event<IceMeltEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos)
}
