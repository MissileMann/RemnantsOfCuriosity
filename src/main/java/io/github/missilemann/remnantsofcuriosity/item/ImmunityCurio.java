package io.github.missilemann.remnantsofcuriosity.item;

import net.minecraft.world.item.Rarity;

public class ImmunityCurio extends RemnantItem{
    public ImmunityCurio(Properties properties) {
        super(properties.rarity(Rarity.EPIC));
    }
}
