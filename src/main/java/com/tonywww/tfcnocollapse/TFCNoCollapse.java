package com.tonywww.tfcnocollapse;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mod(TFCNoCollapse.MODID)
public class TFCNoCollapse {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tfcnocollapse";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static List<? extends String> DIM_LIST = null;
    public static Set<ResourceLocation> DIM_SET = null;

    public TFCNoCollapse() {
        ModLoadingContext.get().registerConfig(
                ModConfig.Type.COMMON,
                TFCNoCollapseConfig.COMMON_SPEC,
                MODID + "-common.toml"
        );

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

    }

    public static Logger getLogger() {
        return LOGGER;
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        DIM_LIST = TFCNoCollapseConfig.DIM_WITH_COLLAPSE.get();
        DIM_SET = DIM_LIST.stream()
                .map(ResourceLocation::new)
                .collect(Collectors.toSet());

        LOGGER.info("Dimensions with collapse: " + DIM_LIST);
    }
}
