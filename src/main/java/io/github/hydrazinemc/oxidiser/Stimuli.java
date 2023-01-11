package io.github.hydrazinemc.oxidiser;

import io.github.hydrazinemc.oxidiser.event.EventListenerMap;
import io.github.hydrazinemc.oxidiser.event.EventRegistrar;
import io.github.hydrazinemc.oxidiser.event.StimulusEvent;
import io.github.hydrazinemc.oxidiser.selector.EventListenerSelector;
import io.github.hydrazinemc.oxidiser.selector.ListenerSelectorSet;
import net.minecraft.server.MinecraftServer;

import java.util.Iterator;

public final class Stimuli {
    private static final ListenerSelectorSet SELECTORS = new ListenerSelectorSet();

    private static final StimuliSelector SELECT = new StimuliSelector(SELECTORS);

    private static final Global GLOBAL = new Global();

    static {
        SELECTORS.add(GLOBAL.selector);
    }

    private Stimuli() {
    }

    public static Global global() {
        return GLOBAL;
    }

    public static StimuliSelector select() {
        return SELECT;
    }

    public static boolean registerSelector(EventListenerSelector selector) {
        return SELECTORS.add(selector);
    }

    public static boolean unregisterSelector(EventListenerSelector selector) {
        return SELECTORS.remove(selector);
    }

    public static final class Global implements EventRegistrar {
        private final EventListenerMap listeners = new EventListenerMap();
        private final Selector selector = new Selector(this.listeners);

        @Override
        public <T> void listen(StimulusEvent<T> event, T listener) {
            this.listeners.listen(event, listener);
        }

        @Override
        public <T> void unlisten(StimulusEvent<T> event, T listener) {
            this.listeners.unlisten(event, listener);
        }

        record Selector(EventListenerMap listeners) implements EventListenerSelector {
            @Override
            public <T> Iterator<T> selectListeners(MinecraftServer server, StimulusEvent<T> event, EventSource source) {
                return this.listeners.get(event).iterator();
            }
        }
    }
}
