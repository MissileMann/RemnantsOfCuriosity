package io.github.missilemann.remnantsofcuriosity.util;

import com.google.common.collect.HashMultimap;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.*;

public class Immunities {
    private static final HashMultimap<MobEffect, Item> immuneList = HashMultimap.create();
    public static void add(Item item, Set<MobEffect> effects) {
        for (MobEffect effect : effects) {
            System.out.println(item.toString() + " and " + effect.toString() + " added to immune list");
            immuneList.put(effect, item);
        }
    }

    public static boolean isEffectImmune(LivingEntity player, MobEffect effect) {
        Set<Item> items = immuneList.get(effect);

        for (Item item : items) {
            Optional<SlotResult> slot = CuriosApi.getCuriosHelper().findFirstCurio(player,item);
            if (slot.isPresent() && immuneList.get(effect).contains(item)) {
                return false;
                //CuriosApi.
            }
        }
        return true;
    }
}
