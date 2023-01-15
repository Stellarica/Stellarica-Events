package net.stellarica.oxidizer.mixin.player;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.stellarica.oxidizer.event.player.PlayerC2SPacketEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {
	@Inject(method = "handlePacket", at = @At("HEAD"), cancellable = true)
	private static void onPacket(Packet<?> packet, PacketListener listener, CallbackInfo ci) {
		if (listener instanceof ServerPlayNetworkHandler handler) {
			var result = PlayerC2SPacketEvent.INSTANCE.call(new PlayerC2SPacketEvent.EventData(handler.player, packet));
			if (result) {
				ci.cancel();
			}
		}
	}
}
