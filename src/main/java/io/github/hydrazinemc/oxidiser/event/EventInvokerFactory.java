package io.github.hydrazinemc.oxidiser.event;

public interface EventInvokerFactory<T> {
    T create(EventInvokerContext<T> context);
}
