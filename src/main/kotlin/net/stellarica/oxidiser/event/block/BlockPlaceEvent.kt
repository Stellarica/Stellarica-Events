package net.stellarica.oxidiser.event.block

import net.minecraft.block.BlockState
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when a [ServerPlayerEntity] attempts to place a block.
 */
object BlockPlaceEvent : net.stellarica.oxidiser.event.Event<BlockPlaceEvent.EventData>() {
	data class EventData(
		val player: ServerPlayerEntity?,
		val world: ServerWorld,
		val pos: BlockPos,
		val state: BlockState
	)
}