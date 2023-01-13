package io.github.hydrazinemc.oxidiser.event.world

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when a nether portal is attempted to be opened within the world.
 */
object NetherPortalOpenEvent : Event<NetherPortalOpenEvent.EventData>() {
	data class EventData(val world: ServerWorld, val lowerCorner: BlockPos)
}