package net.stellarica.events.block

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.stellarica.events.Event

/**
 * Called when a [ServerPlayerEntity] attempts to break a block.
 */
object BlockBreakEvent : Event<BlockBreakEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val world: ServerWorld, val pos: BlockPos)
}