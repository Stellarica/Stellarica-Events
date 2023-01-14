package io.github.hydrazinemc.oxidiser.mixin.projectile;

import io.github.hydrazinemc.oxidiser.event.projectile.ProjectileHitBlockEvent;
import io.github.hydrazinemc.oxidiser.event.projectile.ProjectileHitEntityEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ProjectileEntity.class)
public abstract class ProjectileEntityMixin extends Entity {
	public ProjectileEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(method = "onCollision", at = @At("HEAD"), cancellable = true)
	private void onCollision(HitResult hitResult, CallbackInfo ci) {
		if (this.world.isClient) {
			return;
		}

		var self = (ProjectileEntity) (Object) this;
		if (hitResult.getType() == HitResult.Type.ENTITY) {
			var result = ProjectileHitEntityEvent.INSTANCE.call(new ProjectileHitEntityEvent.EventData(self, (EntityHitResult) hitResult));
			if (result) {
				ci.cancel();
			}
		} else if (hitResult.getType() == HitResult.Type.BLOCK) {
			var result = ProjectileHitBlockEvent.INSTANCE.call(new ProjectileHitBlockEvent.EventData(self, (BlockHitResult) hitResult));
			if (result) {
				ci.cancel();
			}
		}
	}
}
