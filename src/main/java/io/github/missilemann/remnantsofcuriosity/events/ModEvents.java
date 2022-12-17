package io.github.missilemann.remnantsofcuriosity.events;


import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.event.CurioEquipEvent;

import static io.github.missilemann.remnantsofcuriosity.init.ItemInit.FINITE_BELT;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = RemnantsOfCuriosity.MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onCurioEquipped(CurioEquipEvent event) {
            //if (event.getStack().getItem().equals(FiniteBelt));
        }
    }
}
