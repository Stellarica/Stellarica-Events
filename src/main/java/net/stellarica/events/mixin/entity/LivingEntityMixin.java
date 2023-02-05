package net.stellarica.events.mixin.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.world.World;
import net.stellarica.events.entity.EntityDamageEvent;
import net.stellarica.events.entity.EntityDeathEvent;
import net.stellarica.events.entity.EntityDropItemsEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	private LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(method = "damage", at = @At("HEAD"), cancellable = true)
	private void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> ci) {
		if (this.world.isClient) {
			return;
		}

		var entity = (LivingEntity) (Object) this;
		var result = EntityDamageEvent.INSTANCE.call(new EntityDamageEvent.EventData(entity, source, amount));
		if (result) {
			ci.cancel();
		}
	}

	@Inject(method = "onDeath", at = @At("HEAD"), cancellable = true)
	private void callDeathListener(DamageSource source, CallbackInfo ci) {
		if (this.world.isClient) {
			return;
		}

		var entity = (LivingEntity) (Object) this;

		var result = EntityDeathEvent.INSTANCE.call(new EntityDeathEvent.EventData(entity, source));

		// cancel death if FAIL was returned from any listener
		if (result) {
			ci.cancel();
		}
	}

	@Redirect(method = "dropLoot", at = @At(value = "INVOKE", target = "Lnet/minecraft/loot/LootTable;generateLoot(Lnet/minecraft/loot/context/LootContext;Ljava/util/function/Consumer;)V"))
	private void modifyDroppedLoot(LootTable lootTable, LootContext context, Consumer<ItemStack> lootConsumer) {
		if (this.world.isClient) {
			lootTable.generateLoot(context, lootConsumer);
			return;
		}

		var droppedStacks = lootTable.generateLoot(context);

		var result = EntityDropItemsEvent.INSTANCE.call(new EntityDropItemsEvent.EventData((LivingEntity) (Object) this, droppedStacks));
	}
}
