package net.stellarica.oxidizer.mixin.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.stellarica.oxidizer.event.block.BlockBreakEvent;
import net.stellarica.oxidizer.event.block.BlockTrampleEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FarmlandBlock.class)
public class FarmlandBlockMixin {
	@Inject(method = "onLandedUpon", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FarmlandBlock;setToDirt(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V", shift = At.Shift.BEFORE), cancellable = true)
	private void breakFarmland(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci) {
		if (world instanceof ServerWorld serverWorld && entity instanceof LivingEntity livingEntity) {
			var trampleResult = BlockTrampleEvent.INSTANCE.call(new BlockTrampleEvent.EventData(livingEntity, serverWorld, pos, state, Blocks.DIRT.getDefaultState()));
			if (trampleResult) {
				ci.cancel();
				return;
			}

			if (livingEntity instanceof ServerPlayerEntity player) {
				var breakResult = BlockBreakEvent.INSTANCE.call(new BlockBreakEvent.EventData(player, serverWorld, pos));
				if (breakResult) {
					ci.cancel();
				}
			}
		}
	}
}
