package io.github.missilemann.remnantsofcuriosity.util;

import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static io.github.missilemann.remnantsofcuriosity.init.ItemInit.*;
import static net.minecraft.world.effect.MobEffects.*;

public class ImmunityStartUp {
    /*public static void initializeImmunities() {
        create(weakness_curio, set(WEAKNESS));
        create(slowness_curio, set(MOVEMENT_SLOWDOWN));
        create(nausea_curio, set(CONFUSION));
        create(mining_fatigue_curio,set(DIG_SLOWDOWN));
        create(hunger_curio,set(HUNGER));
        ForgeRegistries.ITEMS.getCodec();
    }

    public static void create(Item item, Set<MobEffect> effects) {
        Immunities.add(item,effects);
    }

    @SafeVarargs
    protected static <T> Set<T> set(T... args) {
        return new HashSet<>(Arrays.asList(args));
    }*/
}
