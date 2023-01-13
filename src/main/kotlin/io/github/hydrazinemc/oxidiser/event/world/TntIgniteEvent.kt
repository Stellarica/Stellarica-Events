package io.github.hydrazinemc.oxidiser.event.world

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.entity.LivingEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when TNT is ignited within the world.
 */
object TntIgniteEvent : Event<TntIgniteEvent.EventData>() {
	data class EventData(val world: ServerWorld, val pos: BlockPos, val igniter: LivingEntity?)
}