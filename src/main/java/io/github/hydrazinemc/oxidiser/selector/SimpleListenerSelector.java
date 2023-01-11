package io.github.hydrazinemc.oxidiser.selector;

import io.github.hydrazinemc.oxidiser.filter.EventFilter;
import net.minecraft.server.MinecraftServer;
import io.github.hydrazinemc.oxidiser.EventSource;
import io.github.hydrazinemc.oxidiser.event.EventListenerMap;
import io.github.hydrazinemc.oxidiser.event.StimulusEvent;

import java.util.Collections;
import java.util.Iterator;

public record SimpleListenerSelector(EventFilter filter, EventListenerMap listeners) implements EventListenerSelector {
    @Override
    public <T> Iterator<T> selectListeners(MinecraftServer server, StimulusEvent<T> event, EventSource source) {
        if (this.filter.accepts(source)) {
            return this.listeners.get(event).iterator();
        } else {
            return Collections.emptyIterator();
        }
    }
}
