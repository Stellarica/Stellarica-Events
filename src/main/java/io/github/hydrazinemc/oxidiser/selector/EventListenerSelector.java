package io.github.hydrazinemc.oxidiser.selector;

import net.minecraft.server.MinecraftServer;
import io.github.hydrazinemc.oxidiser.EventSource;
import io.github.hydrazinemc.oxidiser.event.StimulusEvent;

import java.util.Iterator;

/**
 * Handles a lookup from a {@link StimulusEvent} and {@link EventSource} to return an iterator of event listeners.
 * The listener selector is responsible for processing any filtering logic based on the given {@link EventSource}.
 *
 * @see SimpleListenerSelector
 */
public interface EventListenerSelector {
    <T> Iterator<T> selectListeners(MinecraftServer server, StimulusEvent<T> event, EventSource source);
}
