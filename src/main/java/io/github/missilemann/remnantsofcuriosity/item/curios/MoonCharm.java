package io.github.missilemann.remnantsofcuriosity.item.curios;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
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
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

import static io.github.missilemann.remnantsofcuriosity.init.ItemInit.*;

public class MoonCharm extends RemnantItem {
    public MoonCharm(Properties properties) {
        super(properties);
    }

    private static AttributeModifier armorBuff() {
        return new AttributeModifier(UUID.fromString("5b3849fa-9b1c-46b9-9f40-6199bafdd60d"), "remnantsofcuriosity:moon_charm_armor", 3, AttributeModifier.Operation.ADDITION);
    }

    private static AttributeModifier knockbackBuff() {
        return new AttributeModifier(UUID.fromString("4ffc3807-c890-4dd0-ba2d-62db6898ed07"), "remnantsofcuriosity:moon_charm_knockback", 0.2, AttributeModifier.Operation.ADDITION);
    }

    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return CuriosApi.getCuriosHelper().findFirstCurio(slotContext.entity(),CELESTIAL_CHARM.get()).isEmpty();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.mooncharminfo", ChatFormatting.GOLD);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
        attributes.put(Attributes.ARMOR_TOUGHNESS,armorBuff());
        attributes.put(Attributes.KNOCKBACK_RESISTANCE,knockbackBuff());
        return attributes;
    }
}
