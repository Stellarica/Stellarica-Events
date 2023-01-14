package net.stellarica.oxidiser.event.block

import net.minecraft.block.entity.DispenserBlockEntity
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos

/**
 * Called when a [ServerPlayerEntity] or [DispenserBlockEntity] attempts to place fluid from bucket.
 */
object FluidPlaceEvent : net.stellarica.oxidiser.event.Event<FluidPlaceEvent.EventData>() {
	data class EventData(
		val world: ServerWorld,
		val pos: BlockPos,
		val player: ServerPlayerEntity?,
		val hitResult: BlockHitResult
	)
}
