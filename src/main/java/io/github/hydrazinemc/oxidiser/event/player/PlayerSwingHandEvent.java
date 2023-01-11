package io.github.hydrazinemc.oxidiser.event.player;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import io.github.hydrazinemc.oxidiser.event.StimulusEvent;

/**
 * Called when a {@link ServerPlayerEntity} swings their hand.
 */
public interface PlayerSwingHandEvent {
    StimulusEvent<PlayerSwingHandEvent> EVENT = StimulusEvent.create(PlayerSwingHandEvent.class, ctx -> (player, hand) -> {
        try {
            for (var listener : ctx.getListeners()) {
                listener.onSwingHand(player, hand);
            }
        } catch (Throwable t) {
            ctx.handleException(t);
        }
    });

    void onSwingHand(ServerPlayerEntity player, Hand hand);
}
