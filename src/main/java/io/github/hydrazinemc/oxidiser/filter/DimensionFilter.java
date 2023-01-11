package io.github.hydrazinemc.oxidiser.filter;

import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;
import io.github.hydrazinemc.oxidiser.EventSource;

record DimensionFilter(RegistryKey<World> dimension) implements EventFilter {
    @Override
    public boolean accepts(EventSource source) {
        var dimension = source.getDimension();
        return dimension == null || dimension == this.dimension;
    }
}
