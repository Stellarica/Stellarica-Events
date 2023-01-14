package net.stellarica.oxidiser.mixin.world;

import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;
import net.stellarica.oxidiser.event.entity.EntitySpawnEvent;
import net.stellarica.oxidiser.event.world.SnowFallEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {

	@Inject(method = "spawnEntity", at = @At("HEAD"), cancellable = true)
	private void applyEntitySpawnEvent(Entity entity, CallbackInfoReturnable<Boolean> cir) {
		var result = EntitySpawnEvent.INSTANCE.call(new EntitySpawnEvent.EventData(entity));
		if (result) {
			cir.setReturnValue(false);
		}
	}

	@Redirect(method = "tickChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/biome/Biome;canSetSnow(Lnet/minecraft/world/WorldView;Lnet/minecraft/util/math/BlockPos;)Z"))
	private boolean applySnowFallEvent(Biome biome, WorldView world, BlockPos pos) {
		if (!biome.canSetSnow(world, pos)) {
			return false;
		}

		ServerWorld serverWorld = (ServerWorld) world;

		var result = SnowFallEvent.INSTANCE.call(new SnowFallEvent.EventData(serverWorld, pos));
		return !result;
	}
}
