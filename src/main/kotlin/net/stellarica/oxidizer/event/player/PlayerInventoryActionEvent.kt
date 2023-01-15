package net.stellarica.oxidizer.event.player

import net.minecraft.screen.slot.SlotActionType
import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.oxidizer.event.Event

/**
 * Called when any [ServerPlayerEntity] attempts to clicks in inventory.
 */
object PlayerInventoryActionEvent : Event<PlayerInventoryActionEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val slot: Int, val actionType: SlotActionType, val button: Int)
}