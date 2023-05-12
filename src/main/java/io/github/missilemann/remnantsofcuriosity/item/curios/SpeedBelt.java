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

import static io.github.missilemann.remnantsofcuriosity.init.ItemInit.EXPLORERS_BELT;
import static io.github.missilemann.remnantsofcuriosity.init.ItemInit.SPEED_BELT;

public class SpeedBelt extends RemnantCurio {

    public SpeedBelt(Properties properties) {
        super(properties);
    }

    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        if (CuriosApi.getSlotHelper().getSlotsForType(slotContext.entity(),"belt") > 1 && CuriosApi.getCuriosHelper().findFirstCurio(slotContext.entity(),EXPLORERS_BELT.get()).isPresent()) {
            return false;
        }
        else {
            return true;
        }
    }

    private static AttributeModifier speedBuff() {
        return new AttributeModifier(UUID.fromString("183e7c11-9bc1-454b-9b93-fc85533af59d"), "remnantsofcuriosity:speed_belt_buff", 0.3, AttributeModifier.Operation.MULTIPLY_BASE);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();

        attributes.put(Attributes.MOVEMENT_SPEED,speedBuff());

        return attributes;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.speedbeltinfo", ChatFormatting.AQUA);
    }
}
