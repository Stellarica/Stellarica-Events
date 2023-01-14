package net.stellarica.oxidiser.event.player

import net.minecraft.screen.slot.SlotActionType
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when any [ServerPlayerEntity] attempts to clicks in inventory.
 */
object PlayerInventoryActionEvent : net.stellarica.oxidiser.event.Event<PlayerInventoryActionEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val slot: Int, val actionType: SlotActionType, val button: Int)
}