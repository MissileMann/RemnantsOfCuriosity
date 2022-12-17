package io.github.missilemann.remnantsofcuriosity.mixins;

import io.github.missilemann.remnantsofcuriosity.util.Immunities;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {
    @Inject(method = "canBeAffected", at = @At("HEAD"), cancellable = true)
    private void isImmuneToEffect(MobEffectInstance effectInstance, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;

        MobEffect effect = effectInstance.getEffect();


        if (!Immunities.isEffectImmune(self,effect)) {
            cir.setReturnValue(false);
        }
    }
}
