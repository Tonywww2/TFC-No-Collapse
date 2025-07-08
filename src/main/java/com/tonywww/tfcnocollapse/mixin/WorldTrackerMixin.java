package com.tonywww.tfcnocollapse.mixin;

import com.tonywww.tfcnocollapse.TFCNoCollapse;
import net.dries007.tfc.util.collections.BufferedList;
import net.dries007.tfc.util.tracker.Collapse;
import net.dries007.tfc.util.tracker.TickEntry;
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
import java.util.List;

import static com.tonywww.tfcnocollapse.TFCNoCollapse.DIM_SET;
import static com.tonywww.tfcnocollapse.TFCNoCollapseConfig.ENABLE_DEBUG_LOG;

@Mixin(WorldTracker.class)
public abstract class WorldTrackerMixin {

    @Shadow(remap = false)
    @Final
    private Level level;


    @Shadow(remap = false)
    @Final
    private List<Collapse> collapsesInProgress;

    @Shadow(remap = false)
    @Final
    private BufferedList<BlockPos> isolatedPositions;

    @Shadow(remap = false)
    @Final
    private BufferedList<TickEntry> landslideTicks;

    @Inject(at = @At("HEAD"), method = "addLandslidePos(Lnet/minecraft/core/BlockPos;)V", cancellable = true, remap = false)
    public void addLandslidePos(BlockPos centerPos, CallbackInfo ci) {
        if (ENABLE_DEBUG_LOG.get()) {
            TFCNoCollapse.getLogger().debug("No Collapse [addLandslidePos]: {}{}", DIM_SET, this.level.dimension().location());
        }
        if (DIM_SET == null) return;
        ResourceLocation dim = this.level.dimension().location();
        if (!DIM_SET.contains(dim)) {
//            landslideTicks.clear();
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "addIsolatedPos(Lnet/minecraft/core/BlockPos;)V", cancellable = true, remap = false)
    public void addIsolatedPos(BlockPos centerPos, CallbackInfo ci) {
        if (ENABLE_DEBUG_LOG.get()) {
            TFCNoCollapse.getLogger().debug("No Collapse [addIsolatedPos]: {}{}", DIM_SET, this.level.dimension().location());
        }
        if (DIM_SET == null) return;
        ResourceLocation dim = this.level.dimension().location();
        if (!DIM_SET.contains(dim)) {
//            isolatedPositions.clear();
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "addCollapseData(Lnet/dries007/tfc/util/tracker/Collapse;)V", cancellable = true, remap = false)
    public void addCollapseData(Collapse collapse, CallbackInfo ci) {
        if (ENABLE_DEBUG_LOG.get()) {
            TFCNoCollapse.getLogger().debug("No Collapse [addCollapseData]: {}{}", DIM_SET, this.level.dimension().location());
        }
        if (DIM_SET == null) return;
        ResourceLocation dim = this.level.dimension().location();
        if (!DIM_SET.contains(dim)) {
//            collapsesInProgress.clear();
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "addCollapsePositions(Lnet/minecraft/core/BlockPos;Ljava/util/Collection;)V", cancellable = true, remap = false)
    public void addCollapsePositions(BlockPos centerPos, Collection<BlockPos> positions, CallbackInfo ci) {
        if (ENABLE_DEBUG_LOG.get()) {
            TFCNoCollapse.getLogger().debug("No Collapse [addCollapsePositions]: {}{}", DIM_SET, this.level.dimension().location());
        }
        if (DIM_SET == null) return;
        ResourceLocation dim = this.level.dimension().location();
        if (!DIM_SET.contains(dim)) {
//            collapsesInProgress.clear();
            ci.cancel();
        }
    }
}