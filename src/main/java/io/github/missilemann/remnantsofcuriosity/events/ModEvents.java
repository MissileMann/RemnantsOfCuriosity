package io.github.missilemann.remnantsofcuriosity.events;


import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import io.github.missilemann.remnantsofcuriosity.init.AttributesInit;
import io.github.missilemann.remnantsofcuriosity.util.Immunities;
import io.github.missilemann.remnantsofcuriosity.util.ImmunityStartUp;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.event.CurioChangeEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static net.minecraft.world.effect.MobEffects.LEVITATION;

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
        public static void onDamaged(LivingHurtEvent event) {
            LivingEntity player = event.getEntity();
            double attributeValue;
            float damage = event.getAmount();
            float resist;
            if (event.getSource().isExplosion()) {
                attributeValue = player.getAttributes().getValue(AttributesInit.BLAST_IMMUNITY.get());
                if (attributeValue > 0.0) {
                    resist = (float) (attributeValue / 10) * damage;
                    event.setAmount(damage - resist);
                }
            }
            else if (event.getSource().isMagic()) {
                attributeValue = player.getAttributes().getValue(AttributesInit.MAGIC_IMMUNITY.get());
                if (attributeValue > 0.0) {
                    resist = (float) (attributeValue / 10) * damage;
                    event.setAmount(damage - resist);
                }
            }
            else if (event.getSource().isProjectile()) {
                attributeValue = player.getAttributes().getValue(AttributesInit.PROJECTILE_IMMUNITY.get());
                if (attributeValue > 0.0) {
                    resist = (float) (attributeValue / 10) * damage;
                    event.setAmount(damage - resist);
                }
            }
        }

        @SubscribeEvent
        public static void onAttack(AttackEntityEvent event) {
            //event.getSource().
        }

        @SubscribeEvent
        public static void onCritAttack(CriticalHitEvent event) {
            Player player = event.getEntity();
            MobEffectInstance effect;
            LivingEntity attacked = (LivingEntity) event.getTarget();
            if (player.getAttributes().getValue(AttributesInit.LEVITATING_TOUCH.get()) > 0.0 && event.isVanillaCritical() && !attacked.hasEffect(LEVITATION)) {
                effect = new MobEffectInstance(LEVITATION,40,0);
                attacked.addEffect(effect);
            }
        }

        @SubscribeEvent
        public static void onDataRegistry(OnDatapackSyncEvent event) { ImmunityStartUp.init(); }
    }
}
