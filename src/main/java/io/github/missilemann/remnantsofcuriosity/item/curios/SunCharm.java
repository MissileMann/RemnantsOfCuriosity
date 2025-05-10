package io.github.missilemann.remnantsofcuriosity.item.curios;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import io.github.missilemann.remnantsofcuriosity.item.RemnantCurio;
import io.github.missilemann.remnantsofcuriosity.item.RemnantItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
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

import static io.github.missilemann.remnantsofcuriosity.init.ItemInit.CELESTIAL_CHARM;

public class SunCharm extends RemnantCurio {
    public SunCharm(Properties properties) {
        super(properties);
    }

    private static AttributeModifier attackSpeedBuff() {
        return new AttributeModifier(UUID.fromString("811193b7-6337-418b-b904-cc4641c1fd33"), "remnantsofcuriosity:sun_charm_attack_speed", 0.2, AttributeModifier.Operation.ADDITION);
    }

    private static AttributeModifier rangeBuff() {
        return new AttributeModifier(UUID.fromString("6b1efc52-5141-4116-989f-0c0fcbc7e1f0"), "remnantsofcuriosity:sun_charm_range", 1, AttributeModifier.Operation.ADDITION);
    }

    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return CuriosApi.getCuriosHelper().findFirstCurio(slotContext.entity(),CELESTIAL_CHARM.get()).isEmpty();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.suncharminfo", ChatFormatting.GOLD);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
        attributes.put(Attributes.ATTACK_SPEED,attackSpeedBuff());
        attributes.put(ForgeMod.ENTITY_REACH.get(), rangeBuff());
        return attributes;
    }
}
