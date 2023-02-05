package net.stellarica.events.mixin.world;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.stellarica.events.event.block.BlockRandomTickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(AbstractBlock.AbstractBlockState.class)
public class AbstractBlockStateMixin {
	@Redirect(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;randomTick(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/random/RandomGenerator;)V"))
	private void applyBlockRandomTickEvent(Block block, BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {

		var result = BlockRandomTickEvent.INSTANCE.call(new BlockRandomTickEvent.EventData(world, pos, state));
		if (result) {
			return;
		}

		block.randomTick(state, world, pos, random);
	}
}
