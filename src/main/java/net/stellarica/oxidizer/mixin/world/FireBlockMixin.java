package net.stellarica.oxidizer.mixin.world;

import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.GameRules;
import net.stellarica.oxidizer.event.world.FireTickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FireBlock.class)
public class FireBlockMixin {
	@Redirect(method = "scheduledTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z"))
	private boolean test(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule, BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {
		var result = FireTickEvent.INSTANCE.call(new FireTickEvent.EventData(world, pos));
		if (result) {
			return false;
		}

		return gameRules.getBoolean(GameRules.DO_FIRE_TICK);
	}
}
