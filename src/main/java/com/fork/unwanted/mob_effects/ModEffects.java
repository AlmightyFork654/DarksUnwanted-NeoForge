package com.fork.unwanted.mob_effects;

import com.fork.unwanted.Unwanted;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, Unwanted.MOD_ID);

    public static final Holder<MobEffect> FRAGILE = MOB_EFFECTS.register("fragile",
            () -> new FragileEffect(MobEffectCategory.HARMFUL, 176171129));

    public static void  register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
