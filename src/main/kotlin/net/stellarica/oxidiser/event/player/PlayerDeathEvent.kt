package net.stellarica.oxidiser.event.player

import net.minecraft.entity.damage.DamageSource
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] dies.
 */
object PlayerDeathEvent : net.stellarica.oxidiser.event.Event<PlayerDeathEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val source: DamageSource)
}