package io.github.hydrazinemc.oxidiser.event.world;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import io.github.hydrazinemc.oxidiser.event.StimulusEvent;

/**
 * Called when a wither is attempted to be summoned by building its structure in the world.
 *
 * <p>Upon return:
 * <ul>
 * <li>{@link ActionResult#SUCCESS} cancels further handlers and allows the wither to be summoned.
 * <li>{@link ActionResult#FAIL} cancels further handlers and does not allow the wither to be summoned.
 * <li>{@link ActionResult#PASS} moves on to the next listener.</ul>
 */
public interface WitherSummonEvent {
    StimulusEvent<WitherSummonEvent> EVENT = StimulusEvent.create(WitherSummonEvent.class, ctx -> (world, pos) -> {
        try {
            for (var listener : ctx.getListeners()) {
                var result = listener.onSummonWither(world, pos);
                if (result != ActionResult.PASS) {
                    return result;
                }
            }
        } catch (Throwable t) {
            ctx.handleException(t);
        }
        return ActionResult.PASS;
    });

    ActionResult onSummonWither(ServerWorld world, BlockPos pos);
}
