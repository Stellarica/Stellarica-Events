package io.github.hydrazinemc.oxidiser.event.entity;

import io.github.hydrazinemc.oxidiser.event.Event
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;

/**
 * Called when a [LivingEntity] is damaged.
     */
    object EntityDamageEvent: Event<EntityDamageEvent.EventData>() {
        data class EventData(val entity: LivingEntity, val source: DamageSource, val amount: Float)
}