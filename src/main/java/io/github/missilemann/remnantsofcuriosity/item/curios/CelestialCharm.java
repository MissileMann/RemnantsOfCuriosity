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
import net.minecraftforge.common.ForgeMod;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

import static io.github.missilemann.remnantsofcuriosity.init.ItemInit.*;

public class CelestialCharm extends RemnantItem {
    public CelestialCharm(Properties properties) {
        super(properties);
    }

    private static AttributeModifier armorBuff() {
        return new AttributeModifier(UUID.fromString("a0ef13e0-8002-11ed-b911-e3fbf6e8644d"), "remnantsofcuriosity:cel_charm_armor", 3, AttributeModifier.Operation.ADDITION);
    }

    private static AttributeModifier knockbackBuff() {
        return new AttributeModifier(UUID.fromString("a0ef1534-8002-11ed-b912-1b0128ab6733"), "remnantsofcuriosity:cel_charm_knockback", 0.1, AttributeModifier.Operation.ADDITION);
    }

    private static AttributeModifier attackSpeedBuff() {
        return new AttributeModifier(UUID.fromString("a0ef1566-8002-11ed-b913-bb83ee420126"), "remnantsofcuriosity:cel_charm_attack_speed", 0.2, AttributeModifier.Operation.ADDITION);
    }

    private static AttributeModifier rangeBuff() {
        return new AttributeModifier(UUID.fromString("a0ef158e-8002-11ed-b914-e36e4678d855"), "remnantsofcuriosity:cel_charm_range", 1, AttributeModifier.Operation.ADDITION);
    }

    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return CuriosApi.getCuriosHelper().findFirstCurio(slotContext.entity(),MOON_CHARM.get()).isEmpty() && CuriosApi.getCuriosHelper().findFirstCurio(slotContext.entity(),SUN_CHARM.get()).isEmpty();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.celestialcharminfo", ChatFormatting.GOLD);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
        attributes.put(Attributes.ATTACK_SPEED,attackSpeedBuff());
        attributes.put(ForgeMod.ATTACK_RANGE.get(), rangeBuff());
        attributes.put(Attributes.ARMOR_TOUGHNESS,armorBuff());
        attributes.put(Attributes.KNOCKBACK_RESISTANCE,knockbackBuff());
        return attributes;
    }
}
