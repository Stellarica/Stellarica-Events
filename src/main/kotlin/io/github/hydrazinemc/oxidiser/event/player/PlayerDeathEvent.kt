package io.github.hydrazinemc.oxidiser.event.player

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.entity.damage.DamageSource
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] dies.
 */
object PlayerDeathEvent : Event<PlayerDeathEvent.EventData>() {
	data class EventData(val player: ServerPlayerEntity, val source: DamageSource)
}