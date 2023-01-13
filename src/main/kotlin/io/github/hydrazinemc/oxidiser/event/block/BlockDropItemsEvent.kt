package io.github.hydrazinemc.oxidiser.event.block

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.block.BlockState
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos

/**
 * Called when a block is broken and tries to drop its items from a loot table.

 * Listeners can cancel item drops by returning a failure action result such as [Event.Result.CANCEL]
 * and can additionally modify the items dropped by modifying [drops].
 */
object BlockDropItemsEvent : Event<BlockDropItemsEvent.EventData>() {
	data class EventData(
		val breaker: Entity?,
		val world: ServerWorld,
		val pos: BlockPos,
		val state: BlockState,
		val drops: List<ItemStack>
	)
}