package net.stellarica.events.block

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.stellarica.events.Event

/**
 * Called when a [ServerPlayerEntity] attempts to use a block by interacting.
 */
object BlockUseEvent : Event<BlockUseEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val hand: Hand, val hitResult: BlockHitResult)
}
