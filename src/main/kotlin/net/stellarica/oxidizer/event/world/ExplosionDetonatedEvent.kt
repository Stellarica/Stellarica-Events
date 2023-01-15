package net.stellarica.oxidizer.event.world

import net.minecraft.world.explosion.Explosion
import net.stellarica.oxidizer.event.Event

/**
 * Called when an [Explosion] is detonated in the world.
 * This event can be used to modify the blocks affected by the explosion, for example,
 * by modifying [Explosion.affectedBlocks]
 */
object ExplosionDetonatedEvent : Event<ExplosionDetonatedEvent.EventData>() {
	data class EventData(val explosion: Explosion, val particles: Boolean)
}