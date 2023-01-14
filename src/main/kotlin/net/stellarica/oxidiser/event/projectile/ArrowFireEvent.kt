package net.stellarica.oxidiser.event.projectile

import net.minecraft.entity.projectile.ArrowEntity
import net.minecraft.entity.projectile.PersistentProjectileEntity
import net.minecraft.item.ArrowItem
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity

/**
 * Called when a [ServerPlayerEntity] fires an [ArrowEntity] from a bow or crossbow.
 */
object ArrowFireEvent : net.stellarica.oxidiser.event.Event<ArrowFireEvent.EventData>() {
	data class EventData(
		val user: ServerPlayerEntity,
		val tool: ItemStack,
		val arrowItem: ArrowItem,
		val remainingUseTicks: Int,
		val projectile: PersistentProjectileEntity
	)
}