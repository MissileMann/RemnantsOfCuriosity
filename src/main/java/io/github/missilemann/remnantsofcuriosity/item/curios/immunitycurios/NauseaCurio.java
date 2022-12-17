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

import static net.minecraft.world.effect.MobEffects.CONFUSION;

public class NauseaCurio extends RemnantItem {
    MobEffect immunity = CONFUSION;
    public NauseaCurio(Properties properties) {
        super(properties);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack stack, ItemStack newStack) {
        slotContext.entity().removeEffect(immunity);
    }

    @Override
    public void curioTick(SlotContext slot, ItemStack stack) {
        if(slot.entity().hasEffect(immunity)) {
            slot.entity().removeEffect(immunity);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.nauseacurioinfo", ChatFormatting.BOLD, ChatFormatting.GOLD);
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.immunegeneric", ChatFormatting.AQUA);
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.immunenausea", ChatFormatting.ITALIC, ChatFormatting.AQUA);
    }
}
