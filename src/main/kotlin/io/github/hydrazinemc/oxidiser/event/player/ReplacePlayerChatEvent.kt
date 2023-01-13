package io.github.hydrazinemc.oxidiser.event.player

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.network.message.MessageType
import net.minecraft.network.message.SignedChatMessage
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] sends a message in chat. This event can be used to cancel a chat message
 * from being sent. Importantly, the handler must distribute this chat message and/or its header.
 * If the message is not correctly distributed, other clients' chat signing chains will detect a break and disconnect.
 *
 * [net.minecraft.network.message.SentMessage] can be used to automatically dispatch headers to other players
 *
 * @see ServerPlayerEntity.sendChatMessage(SentMessage, boolean, MessageType.Parameters)
 * @see net.minecraft.server.PlayerManager.sendMessageHeader
 * @see PlayerChatEvent to cancel chat events without modification
 */ // todo: some of these are not accurate with QM. Fix
object ReplacePlayerChatEvent : Event<ReplacePlayerChatEvent.EventData>() {
	data class EventData(
		val player: ServerPlayerEntity,
		val message: SignedChatMessage,
		val messageType: MessageType.Parameters
	)
}