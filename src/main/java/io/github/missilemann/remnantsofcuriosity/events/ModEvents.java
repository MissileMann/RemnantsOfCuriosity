package io.github.missilemann.remnantsofcuriosity.events;


import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import io.github.missilemann.remnantsofcuriosity.util.ImmunityStartUp;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.event.CurioEquipEvent;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = RemnantsOfCuriosity.MODID)
    public static class ForgeEvents {
        static boolean initStarted = false;
        @SubscribeEvent
        public static void onCurioEquipped(CurioEquipEvent event) {


        }

        @SubscribeEvent
        public static void onItemsRegistry(OnDatapackSyncEvent event) {
            //System.out.println("Item Registry triggered");
            ImmunityStartUp.init();
        }
    }
}
