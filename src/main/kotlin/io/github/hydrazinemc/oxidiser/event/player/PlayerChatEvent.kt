package io.github.hydrazinemc.oxidiser.event.player

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.network.message.MessageType
import net.minecraft.network.message.SignedChatMessage
import net.minecraft.server.network.ServerPlayerEntity

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