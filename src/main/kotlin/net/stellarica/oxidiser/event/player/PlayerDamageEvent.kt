package net.stellarica.oxidiser.event.player

import net.minecraft.entity.damage.DamageSource
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] is damaged.
 */
object PlayerDamageEvent : net.stellarica.oxidiser.event.Event<PlayerDamageEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val source: DamageSource, val amount: Float)
}