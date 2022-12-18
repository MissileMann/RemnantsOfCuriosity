package io.github.missilemann.remnantsofcuriosity.events;


import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import io.github.missilemann.remnantsofcuriosity.init.ItemInit;
import io.github.missilemann.remnantsofcuriosity.util.ImmunityStartUp;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.registries.RegisterEvent;
import top.theillusivec4.curios.api.event.CurioEquipEvent;

//import static io.github.missilemann.remnantsofcuriosity.init.ItemInit.FINITE_BELT;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = RemnantsOfCuriosity.MODID)
    public static class ForgeEvents {
        static boolean initStarted = false;
        @SubscribeEvent
        public static void onCurioEquipped(CurioEquipEvent event) {
            System.out.println("Curio Equipped triggered");
            if (!initStarted) {
                System.out.println("Immunity Init Started");
                ImmunityStartUp.init();
                initStarted = true;
            }

        }

        @SubscribeEvent
        public static void onItemsRegistry(InterModEnqueueEvent event) {
            System.out.println("Item Registry triggered");
            ImmunityStartUp.init();
        }
    }
}
