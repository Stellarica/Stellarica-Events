package net.stellarica.events.mixin.player;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.Difficulty;
import net.stellarica.events.event.player.PlayerConsumeHungerEvent;
import net.stellarica.events.event.player.PlayerRegenerateEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(HungerManager.class)
public class HungerManagerMixin {
	@Shadow
	private int foodLevel;
	@Shadow
	private float exhaustion;
	@Shadow
	private float foodSaturationLevel;

	@Inject(method = "update", at = @At("HEAD"))
	private void update(PlayerEntity player, CallbackInfo ci) {
		if (!(player instanceof ServerPlayerEntity)) {
			return;
		}

		if (this.exhaustion > 4.0F) {
			var result = PlayerConsumeHungerEvent.INSTANCE.call(new PlayerConsumeHungerEvent.EventData((ServerPlayerEntity) player, this.foodLevel, this.foodSaturationLevel, this.exhaustion));

			if (result) {
				this.exhaustion = 0.0F;
			}
		}
	}

	@Inject(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;heal(F)V", shift = At.Shift.BEFORE, ordinal = 0), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
	private void attemptRegeneration(PlayerEntity player, CallbackInfo ci, Difficulty difficulty, boolean naturalRegeneration, float amount) {
		if (!(player instanceof ServerPlayerEntity)) {
			return;
		}

		var result = PlayerRegenerateEvent.INSTANCE.call(new PlayerRegenerateEvent.EventData((ServerPlayerEntity) player, amount));

		if (result) {
			ci.cancel();
		}
	}

	@Inject(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;heal(F)V", shift = At.Shift.BEFORE, ordinal = 1), cancellable = true)
	private void attemptSecondaryRegeneration(PlayerEntity player, CallbackInfo ci) {
		if (!(player instanceof ServerPlayerEntity)) {
			return;
		}

		var result = PlayerRegenerateEvent.INSTANCE.call(new PlayerRegenerateEvent.EventData((ServerPlayerEntity) player, 1.0F));

		if (result) {
			ci.cancel();
		}
	}
}
