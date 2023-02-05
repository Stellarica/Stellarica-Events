package net.stellarica.events.block

import net.minecraft.block.entity.DispenserBlockEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.stellarica.events.Event

/**
 * Called when a [DispenserBlockEntity] is activated and is not empty.
 */
object DispenserActivateEvent : Event<DispenserActivateEvent.EventData>() {
	data class EventData(
		val world: ServerWorld,
		val pos: BlockPos,
		val dispenser: DispenserBlockEntity,
		val slot: Int,
		val stackToDispense: ItemStack
	)
}