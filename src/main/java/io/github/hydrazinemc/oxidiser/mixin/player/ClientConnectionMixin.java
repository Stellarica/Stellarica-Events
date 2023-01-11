package io.github.hydrazinemc.oxidiser.mixin.player;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import Oxidiser;
import io.github.hydrazinemc.oxidiser.event.player.PlayerC2SPacketEvent;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {
    @Inject(method = "handlePacket", at = @At("HEAD"), cancellable = true)
    private static void onPacket(Packet<?> packet, PacketListener listener, CallbackInfo ci) {
        if (listener instanceof ServerPlayNetworkHandler handler) {
            try (var invokers = Oxidiser.select().forEntity(handler.player)) {
                var result = invokers.get(PlayerC2SPacketEvent.EVENT).onPacket(handler.player, packet);
                if (result == ActionResult.FAIL) {
                    ci.cancel();
                }
            }
        }
    }
}
