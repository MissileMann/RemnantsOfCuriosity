package io.github.missilemann.remnantsofcuriosity.util;

import com.mojang.serialization.Codec;
import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.missilemann.remnantsofcuriosity.init.ItemInit.*;
import static io.github.missilemann.remnantsofcuriosity.util.ModTags.Tags.*;
import static net.minecraft.world.effect.MobEffects.*;

public class ImmunityStartUp {
    public static void init() {
        //create(WEAKNESS_CURIO, set(WEAKNESS));
        //create(SLOWNESS_CURIO, set(MOVEMENT_SLOWDOWN));
        //create(NAUSEA_CURIO, set(CONFUSION));
        //create(MINING_FATIGUE_CURIO,set(DIG_SLOWDOWN));
        //create(HUNGER_CURIO,set(HUNGER));

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

    private static void checkTags(TagKey<Item> tag, Item item) {
        if(tag == POISON_IMMUNE) {
            create(item, set(POISON));
        }
        if(tag == NAUSEA_IMMUNE) {
            create(item, set(WEAKNESS));
        }
        if(tag == SLOWNESS_IMMUNE) {
            create(item, set(MOVEMENT_SLOWDOWN));
        }
        if(tag == WEAKNESS_IMMUNE) {
            create(item, set(WEAKNESS));
        }
        if(tag == HUNGER_IMMUNE) {
            create(item, set(HUNGER));
        }
        if(tag == MINING_FATIGUE_IMMUNE) {
            create(item, set(DIG_SLOWDOWN));
        }
        if(tag == BAD_LUCK_IMMUNE) {
            create(item, set(UNLUCK));
        }
        if(tag == BLINDNESS_IMMUNE) {
            create(item, set(BLINDNESS));
        }
        if(tag == WITHER_IMMUNE) {
            create(item, set(WITHER));
        }
        if(tag == LEVITATION_IMMUNE) {
            create(item, set(LEVITATION));
        }
    }

    public static void create(RegistryObject<Item> item, Set<MobEffect> effects) {
        Immunities.add(item.get(),effects);
    }

    public static void create(Item item, Set<MobEffect> effects) {
        Immunities.add(item,effects);
    }

    @SafeVarargs
    protected static <T> Set<T> set(T... args) {
        return new HashSet<>(Arrays.asList(args));
    }
}
