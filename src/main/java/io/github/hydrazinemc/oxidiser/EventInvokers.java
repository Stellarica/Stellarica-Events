package io.github.hydrazinemc.oxidiser;

import io.github.hydrazinemc.oxidiser.event.StimulusEvent;
import org.jetbrains.annotations.NotNull;

public interface EventInvokers extends AutoCloseable {
    @NotNull
    <T> T get(StimulusEvent<T> event);

    @Override
    void close();
}
