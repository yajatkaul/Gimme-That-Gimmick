package com.provismet.cobblemon.gimmick;

import com.provismet.cobblemon.gimmick.commands.GTGCommands;
import com.provismet.cobblemon.gimmick.handlers.CobblemonEventHandler;
import com.provismet.cobblemon.gimmick.handlers.DynamaxEventHandler;
import com.provismet.cobblemon.gimmick.handlers.UltraBurstEventHandler;
import com.provismet.cobblemon.gimmick.registry.GTGBlocks;
import com.provismet.cobblemon.gimmick.registry.GTGDynamicRegistries;
import com.provismet.cobblemon.gimmick.registry.GTGDynamicRegistryKeys;
import com.provismet.cobblemon.gimmick.registry.GTGEnchantmentComponents;
import com.provismet.cobblemon.gimmick.registry.GTGItemDataComponents;
import com.provismet.cobblemon.gimmick.registry.GTGItemGroup;
import com.provismet.cobblemon.gimmick.registry.GTGItems;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class GimmeThatGimmickServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer () {
        PolymerResourcePackUtils.markAsRequired();
        PolymerResourcePackUtils.addModAssets(GimmeThatGimmickMain.MODID);

        GTGDynamicRegistryKeys.register();

        GTGItems.init();
        GTGBlocks.init();
        GTGItemDataComponents.init();
        GTGEnchantmentComponents.init();
        GTGItemGroup.register();
        GTGCommands.register();

        CobblemonEventHandler.register();
        UltraBurstEventHandler.register();
        DynamaxEventHandler.register();

        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            GTGDynamicRegistries.loadRegistries(server.getRegistryManager());
        });
    }
}
