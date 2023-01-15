package net.stellarica.oxidizer.event.block

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction

/**
 * Called when a [ServerPlayerEntity] attempts to punch a block.
 */
object BlockPunchEvent : net.stellarica.oxidizer.event.Event<BlockPunchEvent.EventData>() {
	data class EventData(val puncher: ServerPlayerEntity, val direction: Direction, val pos: BlockPos)
}