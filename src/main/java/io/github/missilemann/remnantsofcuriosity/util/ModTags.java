package io.github.missilemann.remnantsofcuriosity.util;

import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;

public class ModTags {
    public static class Tags{
        public static final TagKey<Item> POISON_IMMUNE = create("poison_immune");
        public static final TagKey<Item> NAUSEA_IMMUNE = create("nausea_immune");
        public static final TagKey<Item> SLOWNESS_IMMUNE = create("slowness_immune");
        public static final TagKey<Item> WEAKNESS_IMMUNE = create("weakness_immune");
        public static final TagKey<Item> HUNGER_IMMUNE = create("hunger_immune");
        public static final TagKey<Item> MINING_FATIGUE_IMMUNE = create("mining_fatigue_immune");
        public static final TagKey<Item> BAD_LUCK_IMMUNE = create("bad_luck_immune");
        public static final TagKey<Item> BLINDNESS_IMMUNE = create("blindness_immune");
        public static final TagKey<Item> WITHER_IMMUNE = create("wither_immune");
        public static final TagKey<Item> LEVITATION_IMMUNE = create("levitation_immune");

        private static TagKey<Item> create(String location) {
            return ItemTags.create(new ResourceLocation(RemnantsOfCuriosity.MODID, location));
        }
    }

}
