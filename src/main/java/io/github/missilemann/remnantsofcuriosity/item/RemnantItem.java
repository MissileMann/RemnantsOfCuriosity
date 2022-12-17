package io.github.missilemann.remnantsofcuriosity.item;

import io.github.missilemann.remnantsofcuriosity.RemnantsOfCuriosity;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.swing.text.StyleConstants.Italic;
import static net.minecraft.world.effect.MobEffects.*;

public class RemnantItem extends Item implements ICurioItem {

    public RemnantItem(Properties properties) {
        super(properties.stacksTo(1).tab(RemnantsOfCuriosity.TAB).rarity(Rarity.EPIC).fireResistant());
    }
    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    @SafeVarargs
    protected static <T> Set<T> set(T... args) {
        return new HashSet<>(Arrays.asList(args));
    }

    public static void addLocalizedString(List<Component> list, String str, ChatFormatting style) {
        list.add(Component.translatable(str).withStyle(style));
    }

    public static void addLocalizedString(List<Component> list, String str) {
        list.add(Component.translatable(str));
    }

    public static void addLocalizedString(List<Component> list, String str, ChatFormatting style, ChatFormatting style2) {
        list.add(Component.translatable(str).withStyle(style).withStyle(style2));
    }
}
