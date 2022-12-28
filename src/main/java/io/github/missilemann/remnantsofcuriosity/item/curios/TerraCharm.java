package io.github.missilemann.remnantsofcuriosity.item.curios;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import io.github.missilemann.remnantsofcuriosity.item.RemnantItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeMod;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

import static io.github.missilemann.remnantsofcuriosity.init.ItemInit.EXPLORERS_BELT;

public class TerraCharm extends RemnantItem {
    public TerraCharm(Properties properties) {
        super(properties);
    }

    private static AttributeModifier stepBuff() {
        return new AttributeModifier(UUID.fromString("04a9833c-79d7-46a1-8ec2-8132cd93c7c8"), "remnantsofcuriosity:terra_charm_step_height", 0.5, AttributeModifier.Operation.ADDITION);
    }

    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return CuriosApi.getCuriosHelper().findFirstCurio(slotContext.entity(),EXPLORERS_BELT.get()).isEmpty();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.terracharminfo", ChatFormatting.GOLD);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
        attributes.put(ForgeMod.STEP_HEIGHT_ADDITION.get(), stepBuff());
        return attributes;
    }
}


