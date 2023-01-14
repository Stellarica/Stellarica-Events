package io.github.hydrazinemc.oxidiser.mixin.entity;

import io.github.hydrazinemc.oxidiser.event.entity.EntityShearEvent;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Shearable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShearsDispenserBehavior.class)
public class ShearsDispenserBehaviorMixin {
	@Redirect(
			method = "tryShearEntity",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/entity/Shearable;isShearable()Z"
			)
	)
	private static boolean onEntityShear(Shearable shearable, ServerWorld world, BlockPos pos) {
		if (!shearable.isShearable()) {
			return false;
		}

		// Entities are selected from the world by the LivingEntity class
		var entity = (LivingEntity) shearable;

		var result = EntityShearEvent.INSTANCE.call(new EntityShearEvent.EventData(entity, null, null, pos));
		return !result;
	}
}
