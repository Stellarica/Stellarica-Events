package net.stellarica.oxidizer.mixin.block;

import net.minecraft.block.DropperBlock;
import net.minecraft.block.entity.DispenserBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPointerImpl;
import net.minecraft.util.math.BlockPos;
import net.stellarica.oxidizer.event.block.DispenserActivateEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(DropperBlock.class)
public class DropperBlockMixin {
	@Inject(
			method = "dispense",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/item/ItemStack;isEmpty()Z",
					shift = At.Shift.BEFORE,
					ordinal = 0
			),
			locals = LocalCapture.CAPTURE_FAILHARD,
			cancellable = true
	)
	private void useDispenser(ServerWorld world, BlockPos pos, CallbackInfo ci,
							  BlockPointerImpl blockPointerImpl, DispenserBlockEntity dispenserBlockEntity, int slot, ItemStack itemStack) {
		var result = DispenserActivateEvent.INSTANCE.call(new DispenserActivateEvent.EventData(world, pos, dispenserBlockEntity, slot, itemStack));
		if (result) {
			ci.cancel();
		}
	}
}
