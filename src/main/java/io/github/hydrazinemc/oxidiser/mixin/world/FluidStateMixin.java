package io.github.hydrazinemc.oxidiser.mixin.world;

import io.github.hydrazinemc.oxidiser.event.block.FluidRandomTickEvent;
import io.github.hydrazinemc.oxidiser.mixin.FluidAccessor;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FluidState.class)
public class FluidStateMixin {
	@Redirect(method = "onRandomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/fluid/Fluid;onRandomTick(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/fluid/FluidState;Lnet/minecraft/util/random/RandomGenerator;)V"))
	private void applyFluidRandomTickEvent(Fluid fluid, World world, BlockPos pos, FluidState state, RandomGenerator random) {
		ServerWorld serverWorld = (ServerWorld) world;

		var result = FluidRandomTickEvent.INSTANCE.call(new FluidRandomTickEvent.EventData(serverWorld, pos, state));
		if (result) {
			return;
		}

		((FluidAccessor) fluid).callOnRandomTick(world, pos, state, random);
	}
}
