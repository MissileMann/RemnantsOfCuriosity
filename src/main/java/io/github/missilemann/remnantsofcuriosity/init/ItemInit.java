package io.github.missilemann.remnantsofcuriosity.init;

import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import io.github.missilemann.remnantsofcuriosity.item.curios.GoblinTech;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Rarity.EPIC;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RemnantsOfCuriosity.MODID);

    public static final RegistryObject<Item> GOBLIN_TECH = ITEMS.register("goblin_tech", () -> new GoblinTech(new Item.Properties()));
    public static final RegistryObject<Item> FINITE_BELT = ITEMS.register("finite_belt", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(EPIC)));
    public static final RegistryObject<Item> NAUSEA_CURIO = ITEMS.register("nausea_curio", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(EPIC)));
    public static final RegistryObject<Item> SLOWNESS_CURIO = ITEMS.register("slowness_curio", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(EPIC)));
    public static final RegistryObject<Item> WEAKNESS_CURIO = ITEMS.register("weakness_curio", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(EPIC)));
    public static final RegistryObject<Item> MINING_FATIGUE_CURIO = ITEMS.register("mining_fatigue_curio", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(EPIC)));
    public static final RegistryObject<Item> HUNGER_CURIO = ITEMS.register("hunger_curio", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).rarity(EPIC)));
}
