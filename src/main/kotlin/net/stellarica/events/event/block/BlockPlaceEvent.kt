package net.stellarica.events.event.block

import net.minecraft.block.BlockState
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.stellarica.events.event.Event

/**
 * Called when a [ServerPlayerEntity] attempts to place a block.
 */
object BlockPlaceEvent : Event<BlockPlaceEvent.EventData>() {
	data class EventData(
		val player: ServerPlayerEntity?,
		val world: ServerWorld,
		val pos: BlockPos,
		val state: BlockState
	)
}