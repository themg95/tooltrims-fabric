package dev.mg95.tooltrims.items;

import dev.mg95.tooltrims.ToolTrims;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item LINEAR_TOOL_TRIM_SMITHING_TEMPLATE = register(
            new ToolSmithingTemplateItem(
                    PolymerResourcePackUtils.requestModel(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE, Identifier.of("tooltrims", "item/linear_tool_trim_smithing_template")),
                    Text.translatable("tool_trim_pattern.tooltrims.linear")
            ),
            "linear_tool_trim_smithing_template"
    );

    public static final Item TRACKS_TOOL_TRIM_SMITHING_TEMPLATE = register(
            new ToolSmithingTemplateItem(
                    PolymerResourcePackUtils.requestModel(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE, Identifier.of("tooltrims", "item/tracks_tool_trim_smithing_template")),
                    Text.translatable("tool_trim_pattern.tooltrims.tracks")
            ),
            "tracks_tool_trim_smithing_template"
    );

    public static final Item CHARGE_TOOL_TRIM_SMITHING_TEMPLATE = register(
            new ToolSmithingTemplateItem(
                    PolymerResourcePackUtils.requestModel(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, Identifier.of("tooltrims", "item/charge_tool_trim_smithing_template")),
                    Text.translatable("tool_trim_pattern.tooltrims.charge")
            ),
            "charge_tool_trim_smithing_template"
    );

    public static final Item FROST_TOOL_TRIM_SMITHING_TEMPLATE = register(
            new ToolSmithingTemplateItem(
                    PolymerResourcePackUtils.requestModel(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, Identifier.of("tooltrims", "item/frost_tool_trim_smithing_template")),
                    Text.translatable("tool_trim_pattern.tooltrims.frost")
            ),
            "frost_tool_trim_smithing_template"
    );


    public static final ItemGroup ITEM_GROUP = PolymerItemGroupUtils.builder()
            .displayName(Text.translatable("itemGroup.tooltrims.tooltrims"))
            .icon(Items.SMITHING_TABLE::getDefaultStack).entries((context, entries) -> {
                entries.add(LINEAR_TOOL_TRIM_SMITHING_TEMPLATE);
                entries.add(TRACKS_TOOL_TRIM_SMITHING_TEMPLATE);
                entries.add(CHARGE_TOOL_TRIM_SMITHING_TEMPLATE);
                entries.add(FROST_TOOL_TRIM_SMITHING_TEMPLATE);
            }).build();


    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(ToolTrims.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }


    public static void initialize() {
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of(ToolTrims.MOD_ID, "tooltrims"), ITEM_GROUP);
    }
}
