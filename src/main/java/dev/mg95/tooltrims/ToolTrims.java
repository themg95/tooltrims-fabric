package dev.mg95.tooltrims;

import dev.mg95.tooltrims.items.ModItems;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;

public class ToolTrims implements ModInitializer {
    public static final String MOD_ID = "tooltrims";
    @Override
    public void onInitialize() {
        ModItems.initialize();
        PolymerResourcePackUtils.addModAssets(MOD_ID);
        PolymerResourcePackUtils.markAsRequired();
    }
}
