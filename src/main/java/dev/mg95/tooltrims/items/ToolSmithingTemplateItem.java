package dev.mg95.tooltrims.items;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ToolSmithingTemplateItem extends SmithingTemplateItem implements PolymerItem {
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = Identifier.ofVanilla("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = Identifier.ofVanilla("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = Identifier.ofVanilla("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.ofVanilla("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.ofVanilla("item/empty_slot_pickaxe");
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = Identifier.ofVanilla("item/empty_slot_ingot");
    private static final Identifier EMPTY_SLOT_REDSTONE_DUST_TEXTURE = Identifier.ofVanilla("item/empty_slot_redstone_dust");
    private static final Identifier EMPTY_SLOT_QUARTZ_TEXTURE = Identifier.ofVanilla("item/empty_slot_quartz");
    private static final Identifier EMPTY_SLOT_EMERALD_TEXTURE = Identifier.ofVanilla("item/empty_slot_emerald");
    private static final Identifier EMPTY_SLOT_DIAMOND_TEXTURE = Identifier.ofVanilla("item/empty_slot_diamond");
    private static final Identifier EMPTY_SLOT_LAPIS_LAZULI_TEXTURE = Identifier.ofVanilla("item/empty_slot_lapis_lazuli");
    private static final Identifier EMPTY_SLOT_AMETHYST_SHARD_TEXTURE = Identifier.ofVanilla("item/empty_slot_amethyst_shard");

    private final PolymerModelData model;
    public ToolSmithingTemplateItem(PolymerModelData model, Text name) {
        super(
                Text.translatable("item.tooltrims.smithing_template.tool_trim.applies_to").formatted(Formatting.BLUE),
                Text.translatable("item.minecraft.smithing_template.armor_trim.ingredients").formatted(Formatting.BLUE),
                name.copy().formatted(Formatting.GRAY),
                Text.translatable("item.tooltrims.smithing_template.armor_trim.base_slot_description"),
                Text.translatable("item.minecraft.smithing_template.armor_trim.additions_slot_description"),
                List.of(EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE),
                List.of(EMPTY_SLOT_INGOT_TEXTURE, EMPTY_SLOT_REDSTONE_DUST_TEXTURE, EMPTY_SLOT_LAPIS_LAZULI_TEXTURE, EMPTY_SLOT_QUARTZ_TEXTURE, EMPTY_SLOT_DIAMOND_TEXTURE, EMPTY_SLOT_EMERALD_TEXTURE, EMPTY_SLOT_AMETHYST_SHARD_TEXTURE)
        );

        this.model = model;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return this.model.item();
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return this.model.value();
    }
}
