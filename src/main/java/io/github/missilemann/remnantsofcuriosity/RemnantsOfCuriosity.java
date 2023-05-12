package io.github.missilemann.remnantsofcuriosity;

import io.github.missilemann.remnantsofcuriosity.init.AttributesInit;
import io.github.missilemann.remnantsofcuriosity.init.ItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod(RemnantsOfCuriosity.MODID)
public class RemnantsOfCuriosity {
    public static final String MODID = "remnantsofcuriosity";

    public RemnantsOfCuriosity() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::enqueueIMC);
        ItemInit.ITEMS.register(bus);
        AttributesInit.ATTRIBUTES.register(bus);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.HANDS.getMessageBuilder().size(1).build());
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.CHARM.getMessageBuilder().size(2).build());
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.BELT.getMessageBuilder().size(1).build());
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                () -> new SlotTypeMessage.Builder("waist")
                        .priority(181)
                        .size(2)
                        .icon(new ResourceLocation("curios:slot/waist_slot"))
                        .build());
    }

    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return ItemInit.GOBLIN_TECH.get().getDefaultInstance();
        }
    };

}
