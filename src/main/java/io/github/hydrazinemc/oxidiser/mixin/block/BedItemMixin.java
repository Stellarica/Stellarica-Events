package io.github.hydrazinemc.oxidiser.mixin.block;

import io.github.hydrazinemc.oxidiser.event.block.BlockPlaceEvent;
import net.minecraft.block.BlockState;
import net.minecraft.item.BedItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BedItem.class)
public class BedItemMixin {

	@Inject(method = "place(Lnet/minecraft/item/ItemPlacementContext;Lnet/minecraft/block/BlockState;)Z", at = @At("HEAD"), cancellable = true)
	private void onPlace(ItemPlacementContext context, BlockState state, CallbackInfoReturnable<Boolean> ci) {
		if (!(context.getPlayer() instanceof ServerPlayerEntity player)) {
			return;
		}
		var blockPos = context.getBlockPos();

		var result = BlockPlaceEvent.INSTANCE.call(new BlockPlaceEvent.EventData(player, player.getWorld(), blockPos, state, context));

		if (result) {
			// notify the client that this action did not go through
			int slot = context.getHand() == Hand.MAIN_HAND ? player.getInventory().selectedSlot : 40;
			var stack = context.getStack();
			player.networkHandler.sendPacket(new ScreenHandlerSlotUpdateS2CPacket(ScreenHandlerSlotUpdateS2CPacket.UPDATE_PLAYER_INVENTORY_SYNC_ID, 0, slot, stack));

			ci.setReturnValue(false);
		}

	}
}
