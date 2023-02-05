package net.stellarica.events.mixin.projectile;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.stellarica.events.event.projectile.ArrowFireEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(CrossbowItem.class)
public class CrossbowItemMixin {
	@Inject(
			method = "shoot",
			at = @At(value = "INVOKE", shift = Shift.BEFORE, target = "Lnet/minecraft/world/World;spawnEntity(Lnet/minecraft/entity/Entity;)Z"),
			locals = LocalCapture.CAPTURE_FAILHARD,
			cancellable = true
	)
	private static void shoot(
			World world,
			LivingEntity user,
			Hand hand,
			ItemStack tool,
			ItemStack projectileStack,
			float soundPitch,
			boolean creative,
			float speed,
			float divergence,
			float simulated,
			CallbackInfo ci,
			boolean firework,
			ProjectileEntity projectile
	) {
		if (!(user instanceof ServerPlayerEntity)) {
			return;
		}

		Item projectileItem = projectileStack.getItem();
		if (!(projectileItem instanceof ArrowItem) || !(projectile instanceof PersistentProjectileEntity)) {
			return;
		}

		var result = ArrowFireEvent.INSTANCE.call(new ArrowFireEvent.EventData((ServerPlayerEntity) user, tool, (ArrowItem) projectileItem, -1, (PersistentProjectileEntity) projectile));

		if (result) {
			ci.cancel();
		}
	}
}
