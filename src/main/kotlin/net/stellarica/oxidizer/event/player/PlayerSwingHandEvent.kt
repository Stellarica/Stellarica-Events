package net.stellarica.oxidizer.event.player

import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand

/**
 * Called when a [ServerPlayerEntity] swings their hand.
 */
object PlayerSwingHandEvent : net.stellarica.oxidizer.event.Event<PlayerSwingHandEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val hand: Hand)
}