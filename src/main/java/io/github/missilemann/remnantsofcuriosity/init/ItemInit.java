package io.github.missilemann.remnantsofcuriosity.init;

import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import io.github.missilemann.remnantsofcuriosity.item.curios.*;
import io.github.missilemann.remnantsofcuriosity.item.curios.immunitycurios.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RemnantsOfCuriosity.MODID);

    public static final RegistryObject<Item> GOBLIN_TECH = ITEMS.register("goblin_tech", () -> new GoblinTech(new Item.Properties()));
    public static final RegistryObject<Item> FINITE_BELT = ITEMS.register("finite_belt", () -> new FiniteBelt(new Item.Properties()));
    public static final RegistryObject<Item> NAUSEA_CURIO = ITEMS.register("nausea_curio", () -> new NauseaCurio(new Item.Properties()));
    public static final RegistryObject<Item> SLOWNESS_CURIO = ITEMS.register("slowness_curio", () -> new SlownessCurio(new Item.Properties()));
    public static final RegistryObject<Item> WEAKNESS_CURIO = ITEMS.register("weakness_curio", () -> new WeaknessCurio(new Item.Properties()));
    public static final RegistryObject<Item> MINING_FATIGUE_CURIO = ITEMS.register("mining_fatigue_curio", () -> new MiningFatigueCurio(new Item.Properties()));
    public static final RegistryObject<Item> HUNGER_CURIO = ITEMS.register("hunger_curio", () -> new HungerCurio(new Item.Properties()));
}
