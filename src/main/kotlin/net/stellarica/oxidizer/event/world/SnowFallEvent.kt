package net.stellarica.oxidizer.event.world

import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.stellarica.oxidizer.event.Event

/**
 * Called when snow attempts to fall in the world.
 */
object SnowFallEvent : Event<SnowFallEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos)
}