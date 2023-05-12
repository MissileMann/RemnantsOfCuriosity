package io.github.missilemann.remnantsofcuriosity.item;

import net.minecraft.world.item.Rarity;

public class RemnantCurio extends RemnantItem {
    public RemnantCurio(Properties properties) {
        super(properties.rarity(Rarity.RARE));
    }
}
