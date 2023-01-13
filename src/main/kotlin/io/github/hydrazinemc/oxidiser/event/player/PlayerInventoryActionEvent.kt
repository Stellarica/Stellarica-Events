package io.github.hydrazinemc.oxidiser.event.player

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.screen.slot.SlotActionType
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when any [ServerPlayerEntity] attempts to clicks in inventory.
 */
object PlayerInventoryActionEvent : Event<PlayerInventoryActionEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val slot: Int, val actionType: SlotActionType, val button: Int)
}