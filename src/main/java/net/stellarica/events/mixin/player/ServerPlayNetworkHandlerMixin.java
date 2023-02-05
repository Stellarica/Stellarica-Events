package net.stellarica.events.mixin.player;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketSendListener;
import net.minecraft.network.packet.c2s.play.ChatCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.stellarica.events.event.player.PlayerCommandEvent;
import net.stellarica.events.event.player.PlayerInventoryActionEvent;
import net.stellarica.events.event.player.PlayerS2CPacketEvent;
import net.stellarica.events.event.player.PlayerSwapWithOffhandEvent;
import net.stellarica.events.event.player.PlayerSwingHandEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin {
	@Shadow
	public ServerPlayerEntity player;

	@Inject(method = "onHandSwing", at = @At("HEAD"))
	private void onHandSwing(HandSwingC2SPacket packet, CallbackInfo ci) {
		var hand = packet.getHand();
		PlayerSwingHandEvent.INSTANCE.call(new PlayerSwingHandEvent.EventData(this.player, hand));
	}

	@Inject(method = "sendPacket(Lnet/minecraft/network/Packet;Lnet/minecraft/network/PacketSendListener;)V", at = @At("HEAD"), cancellable = true)
	private void onPacket(Packet<?> packet, PacketSendListener listener, CallbackInfo ci) {
		var result = PlayerS2CPacketEvent.INSTANCE.call(new PlayerS2CPacketEvent.EventData(this.player, packet));
		if (result) {
			ci.cancel();
		}
	}

	@Inject(method = "onClickSlot", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/packet/c2s/play/ClickSlotC2SPacket;getRevision()I"), cancellable = true)
	private void onInventoryAction(ClickSlotC2SPacket packet, CallbackInfo ci) {

		var result = PlayerInventoryActionEvent.INSTANCE.call(new PlayerInventoryActionEvent.EventData(this.player, packet.getSlot(), packet.getActionType(), packet.getButton()));
		if (result) {
			ci.cancel();
		}
	}

	@Inject(method = "onPlayerAction", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;getStackInHand(Lnet/minecraft/util/Hand;)Lnet/minecraft/item/ItemStack;", ordinal = 0), cancellable = true)
	private void onSwapWithOffhand(PlayerActionC2SPacket packet, CallbackInfo ci) {
		var result = PlayerSwapWithOffhandEvent.INSTANCE.call(new PlayerSwapWithOffhandEvent.EventData(this.player));
		if (result) {
			ci.cancel();
		}
	}

	@Inject(method = "onChatCommand", at = @At("HEAD"), cancellable = true)
	private void onCommandExecution(ChatCommandC2SPacket packet, CallbackInfo ci) {
		var result = PlayerCommandEvent.INSTANCE.call(new PlayerCommandEvent.EventData(this.player, packet.command()));
		if (result) {
			ci.cancel();
		}
	}
}
