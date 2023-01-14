package net.stellarica.oxidiser

import net.fabricmc.fabric.api.event.player.AttackEntityCallback
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents
import net.fabricmc.fabric.api.event.player.UseBlockCallback
import net.fabricmc.fabric.api.event.player.UseEntityCallback
import net.fabricmc.fabric.api.event.player.UseItemCallback
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.ActionResult
import net.minecraft.util.TypedActionResult
import net.stellarica.oxidiser.event.block.BlockBreakEvent
import net.stellarica.oxidiser.event.block.BlockUseEvent
import net.stellarica.oxidiser.event.entity.EntityUseEvent
import net.stellarica.oxidiser.event.item.ItemUseEvent
import net.stellarica.oxidiser.event.player.PlayerAttackEntityEvent
import net.stellarica.oxidiser.event.player.PlayerChatEvent
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer

class OxidiserInitializer : ModInitializer {
	override fun onInitialize(mod: ModContainer) {
		UseEntityCallback.EVENT.register(UseEntityCallback { player, _, hand, entity, hit ->
			if (player is ServerPlayerEntity) {

				val result = EntityUseEvent.call(EntityUseEvent.EventData(player, entity, hand, hit))

				if (result) {
					return@UseEntityCallback ActionResult.FAIL
				}
			}

			return@UseEntityCallback ActionResult.PASS
		})

		UseItemCallback.EVENT.register(UseItemCallback { player, _, hand ->
			if (player is ServerPlayerEntity) {
				if (ItemUseEvent.call(ItemUseEvent.EventData(player, hand))) {
					return@UseItemCallback TypedActionResult.fail(player.getStackInHand(hand))
				}

			}
			return@UseItemCallback TypedActionResult.pass(player.getStackInHand(hand))
		})

		UseBlockCallback.EVENT.register(UseBlockCallback { player, _, hand, hitResult ->
			if (player is ServerPlayerEntity) {
				if (BlockUseEvent.call(BlockUseEvent.EventData(player, hand, hitResult))) {
					return@UseBlockCallback ActionResult.FAIL
				}
			}
			return@UseBlockCallback ActionResult.PASS
		})

		PlayerBlockBreakEvents.BEFORE.register(PlayerBlockBreakEvents.Before { world, player, pos, state, entity ->
			if (player is ServerPlayerEntity) {
				return@Before !BlockBreakEvent.call(BlockBreakEvent.EventData(player, world as ServerWorld, pos))
			}
			return@Before true
		})

		AttackEntityCallback.EVENT.register(AttackEntityCallback { player, world, hand, entity, hitResult ->
			if (player is ServerPlayerEntity) {
				val result =
					PlayerAttackEntityEvent.call(PlayerAttackEntityEvent.EventData(player, hand, entity, hitResult))
				if (result) return@AttackEntityCallback ActionResult.FAIL
			}
			return@AttackEntityCallback ActionResult.PASS
		})

		ServerMessageEvents.ALLOW_CHAT_MESSAGE.register(ServerMessageEvents.AllowChatMessage { message, sender, params ->
			return@AllowChatMessage !PlayerChatEvent.call(PlayerChatEvent.EventData(sender, message, params))
		})
	}
}
