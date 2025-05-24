package io.github.missilemann.remnantsofcuriosity;

import io.github.missilemann.remnantsofcuriosity.init.AttributesInit;
import io.github.missilemann.remnantsofcuriosity.init.ItemInit;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RemnantsOfCuriosity.MODID)
public class RemnantsOfCuriosity {
    public static final String MODID = "remnantsofcuriosity";

    public RemnantsOfCuriosity(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ItemInit.registerTab(modEventBus);

        modEventBus.addListener(this::addCreative);

        ItemInit.ITEMS.register(modEventBus);
        AttributesInit.ATTRIBUTES.register(modEventBus);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

}
