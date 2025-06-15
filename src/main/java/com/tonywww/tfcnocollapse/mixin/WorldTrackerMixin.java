package com.tonywww.tfcnocollapse.mixin;

import com.tonywww.tfcnocollapse.TFCNoCollapse;
import net.dries007.tfc.util.tracker.Collapse;
import net.dries007.tfc.util.tracker.WorldTracker;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;

import static com.tonywww.tfcnocollapse.TFCNoCollapse.DIM_SET;

@Mixin(WorldTracker.class)
public abstract class WorldTrackerMixin {

    @Shadow(remap = false)
    @Final
    private Level level;


    @Inject(at = @At("HEAD"), method = "addLandslidePos(Lnet/minecraft/core/BlockPos;)V", cancellable = true, remap = false)
    public void addLandslidePos(BlockPos centerPos, CallbackInfo ci) {
//        TFCNoCollapse.getLogger().debug("NOCOLDEBUG: " + DIM_SET + this.level.dimension().location());
        if (DIM_SET == null) return;
        ResourceLocation dim = this.level.dimension().location();
        if (!DIM_SET.contains(dim)) {
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "addIsolatedPos(Lnet/minecraft/core/BlockPos;)V", cancellable = true, remap = false)
    public void addIsolatedPos(BlockPos centerPos, CallbackInfo ci) {
//        TFCNoCollapse.getLogger().debug("NOCOLDEBUG: " + DIM_SET + this.level.dimension().location());
        if (DIM_SET == null) return;
        ResourceLocation dim = this.level.dimension().location();
        if (!DIM_SET.contains(dim)) {
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "addCollapseData(Lnet/dries007/tfc/util/tracker/Collapse;)V", cancellable = true, remap = false)
    public void addCollapseData(Collapse collapse, CallbackInfo ci) {
//        TFCNoCollapse.getLogger().debug("NOCOLDEBUG: " + DIM_SET + this.level.dimension().location());
        if (DIM_SET == null) return;
        ResourceLocation dim = this.level.dimension().location();
        if (!DIM_SET.contains(dim)) {
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "addCollapsePositions(Lnet/minecraft/core/BlockPos;Ljava/util/Collection;)V", cancellable = true, remap = false)
    public void addCollapsePositions(BlockPos centerPos, Collection<BlockPos> positions, CallbackInfo ci) {
//        TFCNoCollapse.getLogger().debug("NOCOLDEBUG: " + DIM_SET + this.level.dimension().location());
        if (DIM_SET == null) return;
        ResourceLocation dim = this.level.dimension().location();
        if (!DIM_SET.contains(dim)) {
            ci.cancel();
        }
    }
}