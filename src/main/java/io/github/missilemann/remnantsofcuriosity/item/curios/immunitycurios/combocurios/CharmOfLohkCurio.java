package io.github.missilemann.remnantsofcuriosity.item.curios.immunitycurios.combocurios;

import io.github.missilemann.remnantsofcuriosity.item.ImmunityCurio;
import io.github.missilemann.remnantsofcuriosity.item.RemnantItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class CharmOfLohkCurio extends ImmunityCurio {
    public CharmOfLohkCurio(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.charmlohkinfo", ChatFormatting.BOLD, ChatFormatting.GOLD);
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.emptyline");
        if (Screen.hasShiftDown()) {
            RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.immunegeneric", ChatFormatting.AQUA);
            RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.immuneweakness", ChatFormatting.ITALIC, ChatFormatting.AQUA);
            RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.immuneminingfatigue", ChatFormatting.ITALIC, ChatFormatting.AQUA);
        }
        else {
            RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.immunehidden", ChatFormatting.GRAY);
        }

    }
}
