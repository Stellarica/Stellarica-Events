package net.stellarica.events.mixin.player;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.stellarica.events.player.PlayerRegenerateEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
	@Redirect(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;heal(F)V"))
	private void attemptPeacefulRegeneration(PlayerEntity player, float amount) {
		if (!(player instanceof ServerPlayerEntity)) {
			player.heal(amount);
			return;
		}

		var result = PlayerRegenerateEvent.INSTANCE.call(new PlayerRegenerateEvent.EventData((ServerPlayerEntity) player, amount));

		if (!result) {
			player.heal(amount);
		}
	}
}
