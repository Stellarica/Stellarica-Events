package net.stellarica.events.mixin.world;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.stellarica.events.event.world.FluidFlowEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FlowableFluid.class)
public class FlowableFluidMixin {
	@Inject(method = "canFlow", at = @At("RETURN"), cancellable = true)
	private void applyFluidFlowEvent(BlockView blockView, BlockPos fluidPos, BlockState fluidBlockState, Direction flowDirection, BlockPos flowTo, BlockState flowToBlockState, FluidState fluidState, Fluid fluid, CallbackInfoReturnable<Boolean> ci) {
		if (!(blockView instanceof ServerWorld world)) {
			return;
		}

		var result = FluidFlowEvent.INSTANCE.call(new FluidFlowEvent.EventData(world, fluidPos, fluidBlockState, flowDirection, flowTo, flowToBlockState));
		if (result) {
			ci.setReturnValue(false);
		}
	}
}
