package io.github.missilemann.remnantsofcuriosity.events;


import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import io.github.missilemann.remnantsofcuriosity.util.Immunities;
import io.github.missilemann.remnantsofcuriosity.util.ImmunityStartUp;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.event.CurioChangeEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = RemnantsOfCuriosity.MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onCurioEquipped(CurioChangeEvent event) {

            LivingEntity player = event.getEntity();
            Collection<MobEffectInstance> effectInstances = player.getActiveEffects();
            List<MobEffect> removeEffects = new ArrayList<>();
            for (MobEffectInstance effects : effectInstances) {
                if (Immunities.isEffectImmune(player,effects.getEffect())) {
                    removeEffects.add(effects.getEffect());
                }
            }
            for (MobEffect effectToRemove : removeEffects) {
                player.removeEffect(effectToRemove);
            }
        }

        @SubscribeEvent
        public static void onDataRegistry(OnDatapackSyncEvent event) {
            ImmunityStartUp.init();
        }
    }
}
