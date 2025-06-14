package com.fork.unwanted.mob_effects;

import com.fork.unwanted.Unwanted;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.Holder;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, Unwanted.MOD_ID);

    public static final Holder<Potion> FRAGILE_POTION = POTIONS.register("fragile_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FRAGILE, 1200, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
