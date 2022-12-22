package io.github.missilemann.remnantsofcuriosity.init;

import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import io.github.missilemann.remnantsofcuriosity.item.curios.*;
import io.github.missilemann.remnantsofcuriosity.item.curios.immunitycurios.*;
import io.github.missilemann.remnantsofcuriosity.item.curios.immunitycurios.combocurios.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RemnantsOfCuriosity.MODID);

    public static final RegistryObject<Item> GOBLIN_TECH = ITEMS.register("goblin_tech", () -> new GoblinTech(new Item.Properties()));
    public static final RegistryObject<Item> FINITE_BELT = ITEMS.register("finite_belt", () -> new FiniteBelt(new Item.Properties()));
    public static final RegistryObject<Item> SUN_CHARM = ITEMS.register("sun_charm", () -> new SunCharm(new Item.Properties()));
    public static final RegistryObject<Item> MOON_CHARM = ITEMS.register("moon_charm", () -> new MoonCharm(new Item.Properties()));
    public static final RegistryObject<Item> CELESTIAL_CHARM = ITEMS.register("celestial_charm", () -> new CelestialCharm(new Item.Properties()));
    public static final RegistryObject<Item> TERRA_CHARM = ITEMS.register("terra_charm", () -> new TerraCharm(new Item.Properties()));

    public static final RegistryObject<Item> NAUSEA_CURIO = ITEMS.register("nausea_curio", () -> new NauseaCurio(new Item.Properties()));
    public static final RegistryObject<Item> SLOWNESS_CURIO = ITEMS.register("slowness_curio", () -> new SlownessCurio(new Item.Properties()));
    public static final RegistryObject<Item> WEAKNESS_CURIO = ITEMS.register("weakness_curio", () -> new WeaknessCurio(new Item.Properties()));
    public static final RegistryObject<Item> MINING_FATIGUE_CURIO = ITEMS.register("mining_fatigue_curio", () -> new MiningFatigueCurio(new Item.Properties()));
    public static final RegistryObject<Item> HUNGER_CURIO = ITEMS.register("hunger_curio", () -> new HungerCurio(new Item.Properties()));
    public static final RegistryObject<Item> BAD_LUCK_CURIO = ITEMS.register("bad_luck_curio", () -> new BadLuckCurio(new Item.Properties()));
    public static final RegistryObject<Item> POISON_CURIO = ITEMS.register("poison_curio", () -> new PoisonCurio(new Item.Properties()));
    public static final RegistryObject<Item> BLINDNESS_CURIO = ITEMS.register("blindness_curio", () -> new BlindnessCurio(new Item.Properties()));
    //public static final RegistryObject<Item> WITHER_CURIO = ITEMS.register("wither_curio", () -> new WitherCurio(new Item.Properties()));
    //public static final RegistryObject<Item> LEVITATION_CURIO = ITEMS.register("levitation_curio", () -> new LevitationCurio(new Item.Properties()));
    public static final RegistryObject<Item> INFERNAL_EYE = ITEMS.register("infernal_eye", () -> new InfernalEyeCurio(new Item.Properties()));
    public static final RegistryObject<Item> ABERRANT_METAL = ITEMS.register("aberrant_metal", () -> new AberrantMetalCurio(new Item.Properties()));

}
