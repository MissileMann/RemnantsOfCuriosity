package io.github.missilemann.remnantsofcuriosity.item.curios;

import io.github.missilemann.remnantsofcuriosity.item.RemnantItem;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class GoblinTech extends RemnantItem {

    public GoblinTech(Properties properties) {
        super(properties);
    }

    private static AttributeModifier healthBuff() {
        return new AttributeModifier(UUID.fromString("50f83ec8-2ed5-421b-ad4e-25a53deded89"), "remnantsofcuriosity:goblin_tech_health", 4, AttributeModifier.Operation.ADDITION);
    }

    private static AttributeModifier knockbackBuff() {
        return new AttributeModifier(UUID.fromString("ee02b286-e773-4002-9732-bf8e51e8de04"), "remnantsofcuriosity:goblin_tech_knockback", 0.2, AttributeModifier.Operation.ADDITION);
    }
    public void onEquip(SlotContext slotContext, ItemStack stack, ItemStack newStack){
        AttributeInstance health = slotContext.entity().getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance kbRes = slotContext.entity().getAttribute(Attributes.KNOCKBACK_RESISTANCE);
        if (health != null && !health.hasModifier(healthBuff())) {
            health.addPermanentModifier(healthBuff());
        }
        if (kbRes != null && !kbRes.hasModifier(knockbackBuff())) {
            kbRes.addPermanentModifier(knockbackBuff());
        }
    }

    public void onUnequip(SlotContext slotContext, ItemStack stack, ItemStack newStack) {
        AttributeInstance health = slotContext.entity().getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance kbRes = slotContext.entity().getAttribute(Attributes.KNOCKBACK_RESISTANCE);
        if (health != null && health.hasModifier(healthBuff())) {
            health.removeModifier(healthBuff());
            if (slotContext.entity().getHealth() > slotContext.entity().getMaxHealth()) {
                slotContext.entity().setHealth(slotContext.entity().getMaxHealth());
            }
        }
        if (kbRes != null && kbRes.hasModifier(knockbackBuff())) {
            kbRes.removeModifier(knockbackBuff());
        }
    }
}
