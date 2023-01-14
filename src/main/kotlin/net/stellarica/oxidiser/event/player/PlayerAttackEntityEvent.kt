package net.stellarica.oxidiser.event.player

import net.minecraft.entity.Entity
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand
import net.minecraft.util.hit.EntityHitResult

/**
 * Called when any [ServerPlayerEntity] attempts to attack another [Entity].
 */
object PlayerAttackEntityEvent : net.stellarica.oxidiser.event.Event<PlayerAttackEntityEvent.EventData>() {
	data class EventData(
		val attacker: ServerPlayerEntity,
		val hand: Hand,
		val attacked: Entity,
		val hitResult: EntityHitResult?
	)
}