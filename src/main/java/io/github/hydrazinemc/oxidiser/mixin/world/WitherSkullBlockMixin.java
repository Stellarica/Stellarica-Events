package io.github.hydrazinemc.oxidiser.mixin.world;

import net.minecraft.block.WitherSkullBlock;
import net.minecraft.block.entity.SkullBlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import Oxidiser;
import io.github.hydrazinemc.oxidiser.event.world.WitherSummonEvent;

@Mixin(WitherSkullBlock.class)
public class WitherSkullBlockMixin {
    @Inject(method = "onPlaced(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/SkullBlockEntity;)V", at = @At("HEAD"), cancellable = true)
    private static void onPlaced(World world, BlockPos pos, SkullBlockEntity blockEntity, CallbackInfo ci) {
        if (!world.isClient) {
            try (var invokers = Oxidiser.select().at(world, pos)) {
                var result = invokers.get(WitherSummonEvent.EVENT).onSummonWither((ServerWorld) world, pos);
                if (result == ActionResult.FAIL) {
                    ci.cancel();
                }
            }
        }
    }
}
