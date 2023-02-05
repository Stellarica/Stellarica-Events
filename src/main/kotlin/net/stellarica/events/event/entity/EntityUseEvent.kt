package net.stellarica.events.event.entity

import net.minecraft.entity.Entity
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand
import net.minecraft.util.hit.EntityHitResult
import net.stellarica.events.event.Event

/**
 * Called when a [ServerPlayerEntity] attempts to use an entity by interacting.
 */
object EntityUseEvent : Event<EntityUseEvent.EventData>() {
	data class EventData(
		val player: ServerPlayerEntity,
		val entity: Entity,
		val hand: Hand,
		val hitResult: EntityHitResult?
	)
}
