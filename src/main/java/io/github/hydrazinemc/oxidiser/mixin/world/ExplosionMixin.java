package io.github.hydrazinemc.oxidiser.mixin.world;

import io.github.hydrazinemc.oxidiser.event.block.BlockDropItemsEvent;
import io.github.hydrazinemc.oxidiser.event.world.ExplosionDetonatedEvent;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collections;
import java.util.List;

@Mixin(Explosion.class)
public class ExplosionMixin {
	@Shadow
	@Final
	private World world;
	@Shadow
	@Final
	private double x;
	@Shadow
	@Final
	private double y;
	@Shadow
	@Final
	private double z;

	@Shadow
	@Final
	private @Nullable Entity entity;

	@Inject(method = "affectWorld", at = @At("HEAD"))
	private void affectWorld(boolean particles, CallbackInfo ci) {
		if (!this.world.isClient) {
			var pos = new BlockPos(this.x, this.y, this.z);
			ExplosionDetonatedEvent.INSTANCE.call(new ExplosionDetonatedEvent.EventData((Explosion) (Object) this, particles));
		}
	}

	@Redirect(method = "affectWorld", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;getDroppedStacks(Lnet/minecraft/loot/context/LootContext$Builder;)Ljava/util/List;"))
	private List<ItemStack> stimuli_dropBlock(BlockState state, LootContext.Builder builder) {
		var stacks = state.getDroppedStacks(builder);

		var pos = this.entity != null ? this.entity.getBlockPos() : new BlockPos(this.x, this.y, this.z);

		var result = BlockDropItemsEvent.INSTANCE.call(new BlockDropItemsEvent.EventData(this.entity, (ServerWorld) this.world, pos, state, stacks));

		if (!result) {
			return stacks;
		} else {
			return Collections.emptyList();
		}
	}
}
