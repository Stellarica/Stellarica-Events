package net.stellarica.oxidizer.event.player

import net.minecraft.entity.damage.DamageSource
import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.oxidizer.event.Event

/**
 * Called when a [ServerPlayerEntity] dies.
 */
object PlayerDeathEvent : Event<PlayerDeathEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val source: DamageSource)
}