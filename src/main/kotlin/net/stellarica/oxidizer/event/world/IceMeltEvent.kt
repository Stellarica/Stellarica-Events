package net.stellarica.oxidizer.event.world

import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when ice attempts to melt in the world.
 */
object IceMeltEvent : net.stellarica.oxidizer.event.Event<IceMeltEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos)
}
