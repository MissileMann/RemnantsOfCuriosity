package io.github.missilemann.remnantsofcuriosity.item.curios.immunitycurios;

import io.github.missilemann.remnantsofcuriosity.item.ImmunityCurio;
import io.github.missilemann.remnantsofcuriosity.item.RemnantItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class LevitationCurio extends ImmunityCurio {

    public LevitationCurio(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.levitationcurioinfo", ChatFormatting.BOLD, ChatFormatting.GOLD);
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.emptyline");
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.immunegeneric", ChatFormatting.AQUA);
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.immunelevitation", ChatFormatting.ITALIC, ChatFormatting.AQUA);
    }
}
