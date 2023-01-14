package net.stellarica.oxidiser.event.world

import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when snow attempts to fall in the world.
 */
object SnowFallEvent : net.stellarica.oxidiser.event.Event<SnowFallEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos)
}