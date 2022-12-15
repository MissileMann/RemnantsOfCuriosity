package io.github.missilemann.remnantsofcuriosity.item;

import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class RemnantItem extends Item implements ICurioItem {

    public RemnantItem(Properties properties) {
        super(properties.stacksTo(1).tab(RemnantsOfCuriosity.TAB).rarity(Rarity.EPIC).fireResistant());
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }
}
