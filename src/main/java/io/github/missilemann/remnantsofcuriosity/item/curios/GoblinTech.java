package io.github.missilemann.remnantsofcuriosity.item.curios;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import io.github.missilemann.remnantsofcuriosity.item.RemnantItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.SlotContext;
import net.minecraftforge.common.ForgeMod.*;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class GoblinTech extends RemnantItem {

    public GoblinTech(Properties properties) {
        super(properties);
    }

    private static AttributeModifier healthBuff() {
        return new AttributeModifier(UUID.fromString("50f83ec8-2ed5-421b-ad4e-25a53deded89"), "remnantsofcuriosity:goblin_tech_health", 4, AttributeModifier.Operation.ADDITION);
    }

    private static AttributeModifier knockbackBuff() {
        return new AttributeModifier(UUID.fromString("ee02b286-e773-4002-9732-bf8e51e8de04"), "remnantsofcuriosity:goblin_tech_knockback", 0.2, AttributeModifier.Operation.ADDITION);
    }
    @Override
    public void onUnequip(SlotContext slotContext, ItemStack stack, ItemStack newStack) {
        if (slotContext.entity().getHealth() > slotContext.entity().getMaxHealth()) {
            slotContext.entity().setHealth(slotContext.entity().getMaxHealth());
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.goblintechinfo", ChatFormatting.GREEN);
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.goblintechinfo2", ChatFormatting.AQUA);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();
        attributes.put(Attributes.MAX_HEALTH,healthBuff());
        attributes.put(Attributes.KNOCKBACK_RESISTANCE,knockbackBuff());
        return attributes;
    }
}
