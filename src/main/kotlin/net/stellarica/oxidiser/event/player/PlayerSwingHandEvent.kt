package net.stellarica.oxidiser.event.player

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand

/**
 * Called when a [ServerPlayerEntity] swings their hand.
 */
object PlayerSwingHandEvent : net.stellarica.oxidiser.event.Event<PlayerSwingHandEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val hand: Hand)
}