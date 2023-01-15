package net.stellarica.oxidizer.event.block

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult

/**
 * Called when a [ServerPlayerEntity] attempts to use a block by interacting.
 */
object BlockUseEvent : net.stellarica.oxidizer.event.Event<BlockUseEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val hand: Hand, val hitResult: BlockHitResult)
}
