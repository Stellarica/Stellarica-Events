package net.stellarica.events.mixin;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;


@Mixin(Fluid.class)
public interface FluidAccessor {
	@Invoker
	void callOnRandomTick(World world, BlockPos pos, FluidState state, RandomGenerator random);
}
