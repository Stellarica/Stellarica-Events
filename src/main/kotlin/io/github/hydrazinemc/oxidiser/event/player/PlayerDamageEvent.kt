package io.github.hydrazinemc.oxidiser.event.player

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.entity.damage.DamageSource
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] is damaged.
 */
object PlayerDamageEvent : Event<PlayerDamageEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val source: DamageSource, val amount: Float)
}