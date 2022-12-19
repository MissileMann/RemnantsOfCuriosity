package io.github.missilemann.remnantsofcuriosity.item.curios.immunitycurios;

import io.github.missilemann.remnantsofcuriosity.item.RemnantItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN;

public class SlownessCurio extends RemnantItem {
    MobEffect immunity = MOVEMENT_SLOWDOWN;
    public SlownessCurio(Properties properties) {
        super(properties);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack stack, ItemStack newStack) {
        slotContext.entity().removeEffect(immunity);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.slownesscurioinfo", ChatFormatting.BOLD, ChatFormatting.GOLD);
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.immunegeneric", ChatFormatting.AQUA);
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.immuneslowness", ChatFormatting.ITALIC, ChatFormatting.AQUA);
    }
}
