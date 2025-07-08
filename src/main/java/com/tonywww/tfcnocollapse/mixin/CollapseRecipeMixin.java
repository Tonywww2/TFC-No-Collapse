package com.tonywww.tfcnocollapse.mixin;

import com.tonywww.tfcnocollapse.TFCNoCollapse;
import net.dries007.tfc.common.recipes.CollapseRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.tonywww.tfcnocollapse.TFCNoCollapse.DIM_SET;
import static com.tonywww.tfcnocollapse.TFCNoCollapseConfig.ENABLE_DEBUG_LOG;

@Mixin(CollapseRecipe.class)
public class CollapseRecipeMixin {

    @Inject(at = @At("HEAD"), method = "tryTriggerCollapse(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)Z", cancellable = true, remap = false)
    private static void tryTriggerCollapse(Level level, BlockPos pos, CallbackInfoReturnable<Boolean> ci) {
        if (ENABLE_DEBUG_LOG.get()) {
            TFCNoCollapse.getLogger().debug("No Collapse [tryTriggerCollapse]: {}{}", DIM_SET, level.dimension().location());
        }

        if (DIM_SET == null) return;
        ResourceLocation dim = level.dimension().location();
        if (!DIM_SET.contains(dim)) {
            ci.cancel();
        }
    }
}
