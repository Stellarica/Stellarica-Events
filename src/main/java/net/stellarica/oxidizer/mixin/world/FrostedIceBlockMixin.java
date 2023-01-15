package net.stellarica.oxidizer.mixin.world;

import net.minecraft.block.BlockState;
import net.minecraft.block.FrostedIceBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.stellarica.oxidizer.event.world.IceMeltEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FrostedIceBlock.class)
public class FrostedIceBlockMixin {
	@Inject(method = "increaseAge", at = @At("HEAD"), cancellable = true)
	private void applyIceMeltEvent(BlockState state, World world, BlockPos pos, CallbackInfoReturnable<Boolean> ci) {
		if (!world.isClient) {
			var result = IceMeltEvent.INSTANCE.call(new IceMeltEvent.EventData((ServerWorld) world, pos));
			if (result) {
				ci.cancel();
			}
		}
	}
}
