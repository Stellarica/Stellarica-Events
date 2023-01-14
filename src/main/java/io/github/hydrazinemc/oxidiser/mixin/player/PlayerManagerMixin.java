package io.github.hydrazinemc.oxidiser.mixin.player;

import io.github.hydrazinemc.oxidiser.event.player.ReplacePlayerChatEvent;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedChatMessage;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Predicate;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {
	@Inject(
			method = "broadcast(Lnet/minecraft/network/message/SignedChatMessage;Ljava/util/function/Predicate;Lnet/minecraft/server/network/ServerPlayerEntity;Lnet/minecraft/network/message/MessageType$Parameters;)V",
			at = @At("HEAD"),
			cancellable = true
	)
	private void broadcastChatMessage(final SignedChatMessage message, final Predicate<ServerPlayerEntity> shouldSendFiltered, final @Nullable ServerPlayerEntity senderPlayer, final MessageType.Parameters messageType, final CallbackInfo ci) {
		if (senderPlayer != null) {
			if (ReplacePlayerChatEvent.INSTANCE.call(new ReplacePlayerChatEvent.EventData(senderPlayer, message, messageType))) {
				ci.cancel();
			}
		}
	}
}
