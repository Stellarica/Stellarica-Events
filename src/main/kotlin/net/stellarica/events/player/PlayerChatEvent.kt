package net.stellarica.events.player

import net.minecraft.network.message.MessageType
import net.minecraft.network.message.SignedChatMessage
import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.events.Event

/**
 * Called when a [ServerPlayerEntity] sends a message in chat. Message uses its final formatting
 */
object PlayerChatEvent : Event<PlayerChatEvent.EventData>() {
	data class EventData(
		val player: ServerPlayerEntity,
		val message: SignedChatMessage,
		val messageType: MessageType.Parameters
	)
}