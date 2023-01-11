package io.github.hydrazinemc.oxidiser.filter;

import io.github.hydrazinemc.oxidiser.EventSource;

final class GlobalFilter implements EventFilter {
    public static final GlobalFilter INSTANCE = new GlobalFilter();

    private GlobalFilter() {
    }

    @Override
    public boolean accepts(EventSource source) {
        return true;
    }
}
