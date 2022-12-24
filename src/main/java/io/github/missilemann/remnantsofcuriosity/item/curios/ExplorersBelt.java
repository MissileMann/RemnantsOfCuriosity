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
import net.minecraftforge.common.ForgeMod;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

import static io.github.missilemann.remnantsofcuriosity.init.ItemInit.*;

public class ExplorersBelt extends RemnantItem{

    public ExplorersBelt(Properties properties) {
        super(properties);
    }

    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return CuriosApi.getCuriosHelper().findFirstCurio(slotContext.entity(),TERRA_CHARM.get()).isEmpty() && (CuriosApi.getCuriosHelper().findFirstCurio(slotContext.entity(),SPEED_BELT.get()).isEmpty()
                && CuriosApi.getSlotHelper().getSlotsForType(slotContext.entity(),"belt") > 1);
    }

    private static AttributeModifier stepBuff() {
        return new AttributeModifier(UUID.fromString("b001a380-35f2-48de-8a32-431eb7caed5b"), "remnantsofcuriosity:explorers_belt_step_height", 0.5, AttributeModifier.Operation.ADDITION);
    }

    private static AttributeModifier speedBuff() {
        return new AttributeModifier(UUID.fromString("005bc8b9-f3a5-463d-a7fa-114e07a48681"), "remnantsofcuriosity:explorers_belt_buff", 0.03, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = HashMultimap.create();

        attributes.put(Attributes.MOVEMENT_SPEED,speedBuff());
        attributes.put(ForgeMod.STEP_HEIGHT_ADDITION.get(), stepBuff());

        return attributes;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        RemnantItem.addLocalizedString(list, "tooltip.remnantsofcuriosity.explorersbeltinfo", ChatFormatting.AQUA);
    }
}
