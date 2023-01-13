package io.github.hydrazinemc.oxidiser.event.block

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult

/**
 * Called when a [ServerPlayerEntity] attempts to use a block by interacting.
 */
object BlockUseEvent : Event<BlockUseEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val hand: Hand, val hitResult: BlockHitResult)
}
