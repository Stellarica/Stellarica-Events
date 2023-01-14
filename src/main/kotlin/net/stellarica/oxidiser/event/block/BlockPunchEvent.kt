package net.stellarica.oxidiser.event.block

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction

/**
 * Called when a [ServerPlayerEntity] attempts to punch a block.
 */
object BlockPunchEvent : net.stellarica.oxidiser.event.Event<BlockPunchEvent.EventData>() {
	data class EventData(val puncher: ServerPlayerEntity, val direction: Direction, val pos: BlockPos)
}