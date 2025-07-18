package com.tonywww.tfcnocollapse;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class TFCNoCollapseConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> DIM_WITH_COLLAPSE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_DEBUG_LOG;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        DIM_WITH_COLLAPSE = builder
                .comment("Dimension with Collapse")
                .defineList(
                        "dimension_with_collapse",
                        List.of("minecraft:overworld"),
                        entry -> entry instanceof String
                );

        ENABLE_DEBUG_LOG = builder
                .comment("Enable debug log")
                .define("enable_debug_log",
                        false);

        COMMON_SPEC = builder.build();
    }

}