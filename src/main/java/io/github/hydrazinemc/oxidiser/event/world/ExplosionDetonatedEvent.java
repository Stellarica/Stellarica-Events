package io.github.hydrazinemc.oxidiser.event.world;

import net.minecraft.world.explosion.Explosion;
import io.github.hydrazinemc.oxidiser.event.StimulusEvent;

/**
 * Called when an {@link Explosion} is detonated in the world.
 * <p>
 * This event can be used to modify the blocks affected by the explosion, for example,
 * by modifying {@link Explosion#getAffectedBlocks()}
 */
public interface ExplosionDetonatedEvent {
    StimulusEvent<ExplosionDetonatedEvent> EVENT = StimulusEvent.create(ExplosionDetonatedEvent.class, ctx -> (explosion, particles) -> {
        try {
            for (var listener : ctx.getListeners()) {
                listener.onExplosionDetonated(explosion, particles);
            }
        } catch (Throwable t) {
            ctx.handleException(t);
        }
    });

    void onExplosionDetonated(Explosion explosion, boolean particles);
}
