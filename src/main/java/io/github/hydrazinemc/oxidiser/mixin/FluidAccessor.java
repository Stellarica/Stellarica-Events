package io.github.hydrazinemc.oxidiser.mixin;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.random.RandomGenerator;

@Mixin(Fluid.class)
public interface FluidAccessor {
	@Invoker
	void callOnRandomTick(World world, BlockPos pos, FluidState state, RandomGenerator random);
}
