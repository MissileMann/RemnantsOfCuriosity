package io.github.missilemann.remnantsofcuriosity.init;

import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = RemnantsOfCuriosity.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributesInit {
    public static final HashMap<RegistryObject<Attribute>, UUID> UUIDS = new HashMap<>();
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, RemnantsOfCuriosity.MODID);

    public static final RegistryObject<Attribute> BLAST_IMMUNITY = registerAttribute("blast_immunity",(id) -> new RangedAttribute(id, 0.0D,-10.0D,10.0D).setSyncable(true),"4991f807-d3b9-48e5-9ed3-5a45102d3a4a");
    public static final RegistryObject<Attribute> MAGIC_IMMUNITY = registerAttribute("magic_immunity",(id) -> new RangedAttribute(id, 0.0D,-10.0D,10.0D).setSyncable(true),"517b3edf-d237-411f-9316-2fb08e5b4dc1");
    public static final RegistryObject<Attribute> PROJECTILE_IMMUNITY = registerAttribute("projectile_immunity",(id) -> new RangedAttribute(id, 0.0D,-10.0D,10.0D).setSyncable(true),"4f221d27-d71c-4f86-b4ea-6de8e41323f3");
    public static final RegistryObject<Attribute> LEVITATING_TOUCH = registerAttribute("levitating_touch",(id) -> new RangedAttribute(id, 0.0D,0.0D,10.0D).setSyncable(true),"95e8281d-4c4b-4eca-b6ca-a21cafa3029d");

    public static RegistryObject<Attribute> registerAttribute(String name, Function<String, Attribute> attribute, String uuid) {
        return registerAttribute(name, attribute, UUID.fromString(uuid));
    }

    public static RegistryObject<Attribute> registerAttribute(String name, Function<String, Attribute> attribute, UUID uuid) {
        RegistryObject<Attribute> registryObject = ATTRIBUTES.register(name, () -> attribute.apply(name));
        UUIDS.put(registryObject, uuid);
        return registryObject;
    }

    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent event) {
        event.getTypes().stream().filter(e -> e == EntityType.PLAYER).forEach(e -> {
            ATTRIBUTES.getEntries().forEach((v)->{
                event.add(e, v.get());
            });
        });
    }
}
