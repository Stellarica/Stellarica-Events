package net.stellarica.oxidiser.event.block

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when a [ServerPlayerEntity] attempts to break a block.
 */
object BlockBreakEvent : net.stellarica.oxidiser.event.Event<BlockBreakEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val world: ServerWorld, val pos: BlockPos)
}