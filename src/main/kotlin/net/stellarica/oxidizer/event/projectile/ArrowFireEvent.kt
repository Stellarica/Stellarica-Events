package net.stellarica.oxidizer.event.projectile

import net.minecraft.entity.projectile.ArrowEntity
import net.minecraft.entity.projectile.PersistentProjectileEntity
import net.minecraft.item.ArrowItem
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.stellarica.oxidizer.event.Event

/**
 * Called when a [ServerPlayerEntity] fires an [ArrowEntity] from a bow or crossbow.
 */
object ArrowFireEvent : Event<ArrowFireEvent.EventData>() {
	data class EventData(
		val user: ServerPlayerEntity,
		val tool: ItemStack,
		val arrowItem: ArrowItem,
		val remainingUseTicks: Int,
		val projectile: PersistentProjectileEntity
	)
}