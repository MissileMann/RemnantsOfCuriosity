package io.github.missilemann.remnantsofcuriosity.item;

import static io.github.missilemann.remnantsofcuriosity.init.ItemInit.ABERRANT;

public class AberrantCurio extends RemnantItem{
    public AberrantCurio(Properties properties) {
        super(properties.rarity(ABERRANT));
    }
}
