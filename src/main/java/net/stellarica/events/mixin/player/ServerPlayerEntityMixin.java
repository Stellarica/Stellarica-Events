package net.stellarica.events.mixin.player;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.stellarica.events.event.item.ItemThrowEvent;
import net.stellarica.events.event.player.PlayerDamageEvent;
import net.stellarica.events.event.player.PlayerDeathEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {
	@Inject(method = "onDeath", at = @At("HEAD"), cancellable = true)
	private void onDeath(DamageSource source, CallbackInfo ci) {
		var player = (ServerPlayerEntity) (Object) this;

		var result = PlayerDeathEvent.INSTANCE.call(new PlayerDeathEvent.EventData(player, source));
		if (result) {
			if (player.getHealth() <= 0.0F) {
				player.setHealth(player.getMaxHealth());
			}
			ci.cancel();
		}
	}

	@Inject(method = "damage", at = @At("HEAD"), cancellable = true)
	private void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> ci) {
		var player = (ServerPlayerEntity) (Object) this;

		var result = PlayerDamageEvent.INSTANCE.call(new PlayerDamageEvent.EventData(player, source, amount));
		if (result) {
			ci.cancel();
		}
	}

	@Inject(method = "dropSelectedItem", at = @At("HEAD"), cancellable = true)
	private void dropSelectedItem(boolean dropEntireStack, CallbackInfoReturnable<Boolean> ci) {
		var player = (ServerPlayerEntity) (Object) this;
		int slot = player.getInventory().selectedSlot;
		var stack = player.getInventory().getStack(slot);

		var result = ItemThrowEvent.INSTANCE.call(new ItemThrowEvent.EventData(player, slot, stack));
		if (result) {
			player.networkHandler.sendPacket(new ScreenHandlerSlotUpdateS2CPacket(ScreenHandlerSlotUpdateS2CPacket.UPDATE_PLAYER_INVENTORY_SYNC_ID, 0, slot, stack));
			ci.setReturnValue(false);
		}
	}
}
