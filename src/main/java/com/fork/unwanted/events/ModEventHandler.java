package com.fork.unwanted.events;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.mob_effects.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = Unwanted.MOD_ID)
public class ModEventHandler {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(ModEffects.FRAGILE)) {
            MobEffectInstance effect = entity.getEffect(ModEffects.FRAGILE);
            int amplifier = effect.getAmplifier();
            float multiplier = (amplifier + 1) * 0.5F;
            float factor = 1.0F + multiplier;
            float currentDamage = event.getContainer().getOriginalDamage();
            float newDamage = currentDamage * factor;
            event.getContainer().setNewDamage(newDamage);
        }
    }
}