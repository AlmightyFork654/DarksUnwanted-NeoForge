package com.fork.unwanted.datagen;

import com.fork.unwanted.Unwanted;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Unwanted.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //item models
    }
}
