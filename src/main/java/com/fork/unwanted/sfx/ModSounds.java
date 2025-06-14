package com.fork.unwanted.sfx;

import com.fork.unwanted.Unwanted;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Unwanted.MOD_ID);

    public static Supplier<SoundEvent> DARKNESS = registerSoundEvent("darkness");
    public static final ResourceKey<JukeboxSong>  DARKNESS_KEY = createSong("darkness");
    public static Supplier<SoundEvent> CAVE_WHISPERS = registerSoundEvent("cave_whispers");
    public static final ResourceKey<JukeboxSong>  CAVE_WHISPERS_KEY = createSong("cave_whispers");

    public static Supplier<SoundEvent> EMBARIUM_BREAK = registerSoundEvent("embarium_break");
    public static Supplier<SoundEvent> EMBARIUM_STEP = registerSoundEvent("embarium_step");
    public static Supplier<SoundEvent> EMBARIUM_PLACE = registerSoundEvent("embarium_place");
    public static Supplier<SoundEvent> EMBARIUM_HIT = registerSoundEvent("embarium_hit");
    public static Supplier<SoundEvent> EMBARIUM_FALL = registerSoundEvent("embarium_fall");

    public static final DeferredSoundType  EMBARIUM_SOUNDS = new DeferredSoundType(1f, 1f,
            ModSounds.EMBARIUM_BREAK, ModSounds.EMBARIUM_STEP, ModSounds.EMBARIUM_PLACE,
            ModSounds.EMBARIUM_HIT, ModSounds.EMBARIUM_FALL);

    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
