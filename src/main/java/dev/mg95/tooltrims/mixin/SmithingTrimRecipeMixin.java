package dev.mg95.tooltrims.mixin;

import dev.mg95.tooltrims.items.ModItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.SmithingTrimRecipe;
import net.minecraft.recipe.input.SmithingRecipeInput;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SmithingTrimRecipe.class)
public class SmithingTrimRecipeMixin {
    @Unique
    private static final TagKey<Item> TRIMMABLE_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of("tooltrims", "trimmable_tools"));

    @Unique
    private static final List<Item> MATERIALS = List.of(
            Items.AMETHYST_SHARD,
            Items.COPPER_INGOT,
            Items.DIAMOND,
            Items.EMERALD,
            Items.GOLD_INGOT,
            Items.IRON_INGOT,
            Items.LAPIS_LAZULI,
            Items.NETHERITE_INGOT,
            Items.QUARTZ,
            Items.REDSTONE
    );

    @Unique
    private static final List<Item> TRIMS = List.of(
            ModItems.LINEAR_TOOL_TRIM_SMITHING_TEMPLATE,
            ModItems.TRACKS_TOOL_TRIM_SMITHING_TEMPLATE,
            ModItems.CHARGE_TOOL_TRIM_SMITHING_TEMPLATE,
            ModItems.FROST_TOOL_TRIM_SMITHING_TEMPLATE
    );

    @Inject(method = "craft(Lnet/minecraft/recipe/input/SmithingRecipeInput;Lnet/minecraft/registry/RegistryWrapper$WrapperLookup;)Lnet/minecraft/item/ItemStack;", at = @At("RETURN"), cancellable = true)
    public void craft(SmithingRecipeInput smithingRecipeInput, RegistryWrapper.WrapperLookup wrapperLookup, CallbackInfoReturnable<ItemStack> cir) {
        if (cir.getReturnValue().isEmpty()) return;

        if (!TRIMS.contains(smithingRecipeInput.template().getItem())) return;

        if (!MATERIALS.contains(smithingRecipeInput.addition().getItem())) return;


        var tool = cir.getReturnValue();
        if (tool.isIn(TRIMMABLE_TOOLS)) {
            var modelId = 311000
                    + (TRIMS.indexOf(smithingRecipeInput.template().getItem()) * 10)
                    + (MATERIALS.indexOf(smithingRecipeInput.addition().getItem()) + 1);

            tool.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(modelId));
            cir.setReturnValue(tool);
        }
    }

}
