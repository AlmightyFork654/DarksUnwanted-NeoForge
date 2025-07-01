package com.fork.unwanted.datagen;

import com.fork.unwanted.misc.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EnchantTagProvider extends EnchantmentTagsProvider {
    public EnchantTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Enchantments.MENDING)
                .add(Enchantments.MENDING);

        this.tag(ModTags.Enchantments.FROST_WALKER)
                .add(Enchantments.FROST_WALKER);

        this.tag(ModTags.Enchantments.SOUL_SPEED)
                .add(Enchantments.SOUL_SPEED);

        this.tag(ModTags.Enchantments.BINDING_CURSE)
                .add(Enchantments.BINDING_CURSE);

        this.tag(ModTags.Enchantments.VANISH_CURSE)
                .add(Enchantments.VANISHING_CURSE);

        this.tag(ModTags.Enchantments.PROT)
                .add(Enchantments.PROTECTION);

        this.tag(ModTags.Enchantments.RIPTIDE)
                .add(Enchantments.RIPTIDE);

        this.tag(ModTags.Enchantments.BOA)
                .add(Enchantments.BLAST_PROTECTION);

        this.tag(ModTags.Enchantments.SMITE)
                .add(Enchantments.SMITE);

        this.tag(ModTags.Enchantments.POWER)
                .add(Enchantments.POWER);

        this.tag(ModTags.Enchantments.UNBREAKING)
                .add(Enchantments.UNBREAKING);

        this.tag(ModTags.Enchantments.FALL)
                .add(Enchantments.FEATHER_FALLING);

        this.tag(ModTags.Enchantments.LUCK)
                .add(Enchantments.LUCK_OF_THE_SEA);

        this.tag(ModTags.Enchantments.CHANNELING)
                .add(Enchantments.CHANNELING);

        this.tag(ModTags.Enchantments.QC)
                .add(Enchantments.QUICK_CHARGE);

        this.tag(ModTags.Enchantments.SWEEP)
                .add(Enchantments.SWEEPING_EDGE);
    }
}
