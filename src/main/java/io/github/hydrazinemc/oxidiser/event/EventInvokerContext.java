package io.github.hydrazinemc.oxidiser.event;

public interface EventInvokerContext<T> {
    Iterable<T> getListeners();

    void handleException(Throwable throwable);
}
