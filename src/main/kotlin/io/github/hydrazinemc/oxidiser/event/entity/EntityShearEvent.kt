package io.github.hydrazinemc.oxidiser.event.entity;

import io.github.hydrazinemc.oxidiser.event.Event
import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

/**
 * Called when a [net.minecraft.entity.Shearable] entity is sheared by a player or dispenser.
 * When a player is shearing, [EventData.player] and [EventData.hand] are provided.
 * When a dispenser is shearing, [EventData.pos] is provided.
 */
object EntityShearEvent: Event<EntityShearEvent.EventData>() {
    data class EventData(val entity: LivingEntity, val player: ServerPlayerEntity?, val hand: Hand?, val pos: BlockPos?)
}