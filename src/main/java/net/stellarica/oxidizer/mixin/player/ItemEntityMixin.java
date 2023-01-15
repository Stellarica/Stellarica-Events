package net.stellarica.oxidizer.mixin.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.stellarica.oxidizer.event.item.ItemPickupEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {
	ItemEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(
			method = "onPlayerCollision",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/entity/player/PlayerInventory;insertStack(Lnet/minecraft/item/ItemStack;)Z",
					shift = At.Shift.BEFORE
			),
			cancellable = true
	)
	private void onPlayerCollision(PlayerEntity player, CallbackInfo ci) {
		if (!(player instanceof ServerPlayerEntity)) {
			return;
		}

		var itemEntity = (ItemEntity) (Object) this;
		var result = ItemPickupEvent.INSTANCE.call(new ItemPickupEvent.EventData((ServerPlayerEntity) player, itemEntity, itemEntity.getStack()));

		if (result) {
			ci.cancel();
		}
	}
}
