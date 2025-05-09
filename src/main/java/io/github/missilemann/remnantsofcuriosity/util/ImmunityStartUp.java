package io.github.missilemann.remnantsofcuriosity.util;

import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.github.missilemann.remnantsofcuriosity.util.ModTags.Tags.*;
import static net.minecraft.world.effect.MobEffects.*;

public class ImmunityStartUp {
    public static void init() {
        Immunities.resetImmuneList();
        for (Item item : ForgeRegistries.ITEMS.getValues()) {
            checkTags(item);
        }
    }
    private static void checkTags(Item item) {
        List<TagKey<Item>> tags = item.getDefaultInstance().getTags().toList();
        for (TagKey<Item> tag : tags) {
            checkTags(tag,item);
        }
    }


    //change this to enum in the future
    private static void checkTags(TagKey<Item> tag, Item item) {
        if(tag == POISON_IMMUNE) {
            create(item, POISON);
        }
        if(tag == NAUSEA_IMMUNE) {
            create(item, CONFUSION);
        }
        if(tag == SLOWNESS_IMMUNE) {
            create(item, MOVEMENT_SLOWDOWN);
        }
        if(tag == WEAKNESS_IMMUNE) {
            create(item, WEAKNESS);
        }
        if(tag == HUNGER_IMMUNE) {
            create(item, HUNGER);
        }
        if(tag == MINING_FATIGUE_IMMUNE) {
            create(item, DIG_SLOWDOWN);
        }
        if(tag == BAD_LUCK_IMMUNE) {
            create(item, UNLUCK);
        }
        if(tag == BLINDNESS_IMMUNE) {
            create(item, BLINDNESS);
        }
        if(tag == WITHER_IMMUNE) {
            create(item, (WITHER));
        }
        if(tag == LEVITATION_IMMUNE) {
            create(item, LEVITATION);
        }
    }

    public static void create(RegistryObject<Item> item, Set<MobEffect> effects) {
        Immunities.add(item.get(),effects);
    }

    public static void create(Item item, MobEffect effect) { Immunities.add(item,effect); }

    public static void create(Item item, Set<MobEffect> effects) {
        Immunities.add(item,effects);
    }

    @SafeVarargs
    protected static <T> Set<T> set(T... args) {
        return new HashSet<>(Arrays.asList(args));
    }
}
