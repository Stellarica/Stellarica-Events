package net.stellarica.events.player

import net.minecraft.entity.damage.DamageSource
import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.events.Event

/**
 * Called when a [ServerPlayerEntity] is damaged.
 */
object PlayerDamageEvent : Event<PlayerDamageEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val source: DamageSource, val amount: Float)
}