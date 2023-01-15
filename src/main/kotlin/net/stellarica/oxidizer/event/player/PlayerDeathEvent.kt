package net.stellarica.oxidizer.event.player

import net.minecraft.entity.damage.DamageSource
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] dies.
 */
object PlayerDeathEvent : net.stellarica.oxidizer.event.Event<PlayerDeathEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val source: DamageSource)
}