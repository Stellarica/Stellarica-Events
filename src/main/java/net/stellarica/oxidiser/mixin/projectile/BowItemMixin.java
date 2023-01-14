package net.stellarica.oxidiser.mixin.projectile;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.stellarica.oxidiser.event.projectile.ArrowFireEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BowItem.class)
public class BowItemMixin {
	@Inject(
			method = "onStoppedUsing",
			at = @At(value = "INVOKE", shift = Shift.BEFORE, target = "Lnet/minecraft/world/World;spawnEntity(Lnet/minecraft/entity/Entity;)Z"),
			locals = LocalCapture.CAPTURE_FAILHARD,
			cancellable = true
	)
	public void onStoppedUsing(
			ItemStack tool,
			World world,
			LivingEntity user,
			int remainingUseTicks,
			CallbackInfo ci,
			PlayerEntity player,
			boolean infinite,
			ItemStack arrowStack,
			int progressTicks,
			float progress,
			boolean creativeOnlyPickup,
			ArrowItem item,
			PersistentProjectileEntity projectile
	) {
		if (!(player instanceof ServerPlayerEntity)) {
			return;
		}


		var result = ArrowFireEvent.INSTANCE.call(new ArrowFireEvent.EventData((ServerPlayerEntity) player, tool, item, remainingUseTicks, projectile));

		if (result) {
			ci.cancel();
		}
	}
}
