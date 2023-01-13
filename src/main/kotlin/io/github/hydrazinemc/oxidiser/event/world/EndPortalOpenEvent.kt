package io.github.hydrazinemc.oxidiser.event.world

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.block.pattern.BlockPattern
import net.minecraft.item.ItemUsageContext

/**
 * Called when an end portal attempts to be opened within the world.
 */
object EndPortalOpenEvent : Event<EndPortalOpenEvent.EventData>() {
	data class EventData(val context: ItemUsageContext, val patternResult: BlockPattern.Result)
}