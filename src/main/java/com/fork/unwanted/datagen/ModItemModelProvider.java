package com.fork.unwanted.datagen;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.items.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Unwanted.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //items
        basicItem(ModItems.ROUGH_RUBY.getId());
        basicItem(ModItems.RUBY.getId());
        basicItem(ModItems.PURE_RUBY.getId());
        basicItem(ModItems.TORRID_STEEL_INGOT.getId());
        basicItem(ModItems.TORRID_STEEL_NUGGET.getId());
        basicItem(ModItems.TORRID_STEEL_POWDER.getId());
        basicItem(ModItems.EMBARIUM.getId());
        basicItem(ModItems.MARBLE_SHARD.getId());
        basicItem(ModItems.BLAZING_WATER.getId());
        basicItem(ModItems.PURE_BLAZE_POWDER.getId());
        basicItem(ModItems.PROFUNDIUM_INGOT.getId());
        basicItem(ModItems.PROFUNDIUM_SCRAP.getId());
        basicItem(ModItems.PROFUNDIUM_FLAKE.getId());

//        basicItem(ModItems.TEA_CUP);
        basicItem(ModItems.CUP_OF_WATER.getId());
//        basicItem(ModItems.GRASSY_TEA);
//        basicItem(ModItems.WARPED_TEA);
//        basicItem(ModItems.CRIMSON_TEA);
//        basicItem(ModItems.LEAVY_TEA);
//        basicItem(ModItems.KELPED_TEA);
//        basicItem(ModItems.VINEY_TEA);
//        basicItem(ModItems.GLOWY_TEA);
//        basicItem(ModItems.SCULKED_TEA);
//        basicItem(ModItems.ROOTED_TEA);

        basicItem(ModItems.DARKNESS_MUSIC_DISK.getId());
        basicItem(ModItems.CAVE_WHISPERS_MUSIC_DISK.getId());

        handheldItem(ModItems.CHISEL);
        handheldItem(ModItems.NETHERITE_CHISEL);
        handheldItem(ModItems.TORRID_STEEL_SWORD);
        handheldItem(ModItems.TORRID_STEEL_PICKAXE);
        handheldItem(ModItems.TORRID_STEEL_AXE);
        handheldItem(ModItems.TORRID_STEEL_SHOVEL);
        handheldItem(ModItems.TORRID_STEEL_HOE);
        handheldItem(ModItems.EMBARIUM_SWORD);
        handheldItem(ModItems.EMBARIUM_PICKAXE);
        handheldItem(ModItems.EMBARIUM_AXE);
        handheldItem(ModItems.EMBARIUM_SHOVEL);
        handheldItem(ModItems.EMBARIUM_HOE);
        handheldItem(ModItems.TORRID_EMBARIUM_SWORD);
        handheldItem(ModItems.TORRID_EMBARIUM_PICKAXE);
        handheldItem(ModItems.TORRID_EMBARIUM_AXE);
        handheldItem(ModItems.TORRID_EMBARIUM_SHOVEL);
        handheldItem(ModItems.TORRID_EMBARIUM_HOE);
        handheldItem(ModItems.PROFUNDIUM_SWORD);
        handheldItem(ModItems.PROFUNDIUM_PICKAXE);
        handheldItem(ModItems.PROFUNDIUM_AXE);
        handheldItem(ModItems.PROFUNDIUM_SHOVEL);
        handheldItem(ModItems.PROFUNDIUM_HOE);
        handheldItem(ModItems.WOODEN_TORRID_SWORD);
        handheldItem(ModItems.WOODEN_TORRID_PICKAXE);
        handheldItem(ModItems.WOODEN_TORRID_AXE);
        handheldItem(ModItems.WOODEN_TORRID_SHOVEL);
        handheldItem(ModItems.WOODEN_TORRID_HOE);
        handheldItem(ModItems.WOODEN_EMBARIUM_SWORD);
        handheldItem(ModItems.WOODEN_EMBARIUM_PICKAXE);
        handheldItem(ModItems.WOODEN_EMBARIUM_AXE);
        handheldItem(ModItems.WOODEN_EMBARIUM_SHOVEL);
        handheldItem(ModItems.WOODEN_EMBARIUM_HOE);
        handheldItem(ModItems.WOODEN_TORRID_EMBARIUM_SWORD);
        handheldItem(ModItems.WOODEN_TORRID_EMBARIUM_PICKAXE);
        handheldItem(ModItems.WOODEN_TORRID_EMBARIUM_AXE);
        handheldItem(ModItems.WOODEN_TORRID_EMBARIUM_SHOVEL);
        handheldItem(ModItems.WOODEN_TORRID_EMBARIUM_HOE);
        handheldItem(ModItems.STONE_TORRID_SWORD);
        handheldItem(ModItems.STONE_TORRID_PICKAXE);
        handheldItem(ModItems.STONE_TORRID_AXE);
        handheldItem(ModItems.STONE_TORRID_SHOVEL);
        handheldItem(ModItems.STONE_TORRID_HOE);
        handheldItem(ModItems.STONE_EMBARIUM_SWORD);
        handheldItem(ModItems.STONE_EMBARIUM_PICKAXE);
        handheldItem(ModItems.STONE_EMBARIUM_AXE);
        handheldItem(ModItems.STONE_EMBARIUM_SHOVEL);
        handheldItem(ModItems.STONE_EMBARIUM_HOE);
        handheldItem(ModItems.STONE_TORRID_EMBARIUM_SWORD);
        handheldItem(ModItems.STONE_TORRID_EMBARIUM_PICKAXE);
        handheldItem(ModItems.STONE_TORRID_EMBARIUM_AXE);
        handheldItem(ModItems.STONE_TORRID_EMBARIUM_SHOVEL);
        handheldItem(ModItems.STONE_TORRID_EMBARIUM_HOE);
        handheldItem(ModItems.GOLDEN_TORRID_SWORD);
        handheldItem(ModItems.GOLDEN_TORRID_PICKAXE);
        handheldItem(ModItems.GOLDEN_TORRID_AXE);
        handheldItem(ModItems.GOLDEN_TORRID_SHOVEL);
        handheldItem(ModItems.GOLDEN_TORRID_HOE);
        handheldItem(ModItems.GOLDEN_EMBARIUM_SWORD);
        handheldItem(ModItems.GOLDEN_EMBARIUM_PICKAXE);
        handheldItem(ModItems.GOLDEN_EMBARIUM_AXE);
        handheldItem(ModItems.GOLDEN_EMBARIUM_SHOVEL);
        handheldItem(ModItems.GOLDEN_EMBARIUM_HOE);
        handheldItem(ModItems.GOLDEN_TORRID_EMBARIUM_SWORD);
        handheldItem(ModItems.GOLDEN_TORRID_EMBARIUM_PICKAXE);
        handheldItem(ModItems.GOLDEN_TORRID_EMBARIUM_AXE);
        handheldItem(ModItems.GOLDEN_TORRID_EMBARIUM_SHOVEL);
        handheldItem(ModItems.GOLDEN_TORRID_EMBARIUM_HOE);
        handheldItem(ModItems.IRON_TORRID_SWORD);
        handheldItem(ModItems.IRON_TORRID_PICKAXE);
        handheldItem(ModItems.IRON_TORRID_AXE);
        handheldItem(ModItems.IRON_TORRID_SHOVEL);
        handheldItem(ModItems.IRON_TORRID_HOE);
        handheldItem(ModItems.IRON_EMBARIUM_SWORD);
        handheldItem(ModItems.IRON_EMBARIUM_PICKAXE);
        handheldItem(ModItems.IRON_EMBARIUM_AXE);
        handheldItem(ModItems.IRON_EMBARIUM_SHOVEL);
        handheldItem(ModItems.IRON_EMBARIUM_HOE);
        handheldItem(ModItems.IRON_TORRID_EMBARIUM_SWORD);
        handheldItem(ModItems.IRON_TORRID_EMBARIUM_PICKAXE);
        handheldItem(ModItems.IRON_TORRID_EMBARIUM_AXE);
        handheldItem(ModItems.IRON_TORRID_EMBARIUM_SHOVEL);
        handheldItem(ModItems.IRON_TORRID_EMBARIUM_HOE);
        handheldItem(ModItems.DIAMOND_TORRID_SWORD);
        handheldItem(ModItems.DIAMOND_TORRID_PICKAXE);
        handheldItem(ModItems.DIAMOND_TORRID_AXE);
        handheldItem(ModItems.DIAMOND_TORRID_SHOVEL);
        handheldItem(ModItems.DIAMOND_TORRID_HOE);
        handheldItem(ModItems.DIAMOND_EMBARIUM_SWORD);
        handheldItem(ModItems.DIAMOND_EMBARIUM_PICKAXE);
        handheldItem(ModItems.DIAMOND_EMBARIUM_AXE);
        handheldItem(ModItems.DIAMOND_EMBARIUM_SHOVEL);
        handheldItem(ModItems.DIAMOND_EMBARIUM_HOE);
        handheldItem(ModItems.DIAMOND_TORRID_EMBARIUM_SWORD);
        handheldItem(ModItems.DIAMOND_TORRID_EMBARIUM_PICKAXE);
        handheldItem(ModItems.DIAMOND_TORRID_EMBARIUM_AXE);
        handheldItem(ModItems.DIAMOND_TORRID_EMBARIUM_SHOVEL);
        handheldItem(ModItems.DIAMOND_TORRID_EMBARIUM_HOE);
        handheldItem(ModItems.NETHERITE_TORRID_SWORD);
        handheldItem(ModItems.NETHERITE_TORRID_PICKAXE);
        handheldItem(ModItems.NETHERITE_TORRID_AXE);
        handheldItem(ModItems.NETHERITE_TORRID_SHOVEL);
        handheldItem(ModItems.NETHERITE_TORRID_HOE);
        handheldItem(ModItems.NETHERITE_EMBARIUM_SWORD);
        handheldItem(ModItems.NETHERITE_EMBARIUM_PICKAXE);
        handheldItem(ModItems.NETHERITE_EMBARIUM_AXE);
        handheldItem(ModItems.NETHERITE_EMBARIUM_SHOVEL);
        handheldItem(ModItems.NETHERITE_EMBARIUM_HOE);
        handheldItem(ModItems.NETHERITE_TORRID_EMBARIUM_SWORD);
        handheldItem(ModItems.NETHERITE_TORRID_EMBARIUM_PICKAXE);
        handheldItem(ModItems.NETHERITE_TORRID_EMBARIUM_AXE);
        handheldItem(ModItems.NETHERITE_TORRID_EMBARIUM_SHOVEL);
        handheldItem(ModItems.NETHERITE_TORRID_EMBARIUM_HOE);
        handheldItem(ModItems.PROFUNDIUM_TORRID_SWORD);
        handheldItem(ModItems.PROFUNDIUM_TORRID_PICKAXE);
        handheldItem(ModItems.PROFUNDIUM_TORRID_AXE);
        handheldItem(ModItems.PROFUNDIUM_TORRID_SHOVEL);
        handheldItem(ModItems.PROFUNDIUM_TORRID_HOE);
        handheldItem(ModItems.PROFUNDIUM_EMBARIUM_SWORD);
        handheldItem(ModItems.PROFUNDIUM_EMBARIUM_PICKAXE);
        handheldItem(ModItems.PROFUNDIUM_EMBARIUM_AXE);
        handheldItem(ModItems.PROFUNDIUM_EMBARIUM_SHOVEL);
        handheldItem(ModItems.PROFUNDIUM_EMBARIUM_HOE);
        handheldItem(ModItems.PROFUNDIUM_TORRID_EMBARIUM_SWORD);
        handheldItem(ModItems.PROFUNDIUM_TORRID_EMBARIUM_PICKAXE);
        handheldItem(ModItems.PROFUNDIUM_TORRID_EMBARIUM_AXE);
        handheldItem(ModItems.PROFUNDIUM_TORRID_EMBARIUM_SHOVEL);
        handheldItem(ModItems.PROFUNDIUM_TORRID_EMBARIUM_HOE);

        basicItem(ModItems.WOODEN_SPEAR_HEAD.getId());

        trimmedArmorItem(ModItems.TORRID_HELMET);
        trimmedArmorItem(ModItems.TORRID_CHESTPLATE);
        trimmedArmorItem(ModItems.TORRID_LEGGINGS);
        trimmedArmorItem(ModItems.TORRID_BOOTS);
        trimmedArmorItem(ModItems.EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.TORRID_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.TORRID_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.TORRID_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.TORRID_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.PROFUNDIUM_HELMET);
        trimmedArmorItem(ModItems.PROFUNDIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.PROFUNDIUM_LEGGINGS);
        trimmedArmorItem(ModItems.PROFUNDIUM_BOOTS);
//        trimmedArmorItem(ModItems.LEATHER_TORRID_HELMET);
//        trimmedArmorItem(ModItems.LEATHER_TORRID_CHESTPLATE);
//        trimmedArmorItem(ModItems.LEATHER_TORRID_LEGGINGS);
//        trimmedArmorItem(ModItems.LEATHER_TORRID_BOOTS);
//        trimmedArmorItem(ModItems.LEATHER_EMBARIUM_HELMET);
//        trimmedArmorItem(ModItems.LEATHER_EMBARIUM_CHESTPLATE);
//        trimmedArmorItem(ModItems.LEATHER_EMBARIUM_LEGGINGS);
//        trimmedArmorItem(ModItems.LEATHER_EMBARIUM_BOOTS);
//        trimmedArmorItem(ModItems.LEATHER_TORRID_EMBARIUM_HELMET);
//        trimmedArmorItem(ModItems.LEATHER_TORRID_EMBARIUM_CHESTPLATE);
//        trimmedArmorItem(ModItems.LEATHER_TORRID_EMBARIUM_LEGGINGS);
//        trimmedArmorItem(ModItems.LEATHER_TORRID_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.CHAIN_TORRID_HELMET);
        trimmedArmorItem(ModItems.CHAIN_TORRID_CHESTPLATE);
        trimmedArmorItem(ModItems.CHAIN_TORRID_LEGGINGS);
        trimmedArmorItem(ModItems.CHAIN_TORRID_BOOTS);
        trimmedArmorItem(ModItems.CHAIN_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.CHAIN_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.CHAIN_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.CHAIN_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.CHAIN_TORRID_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.CHAIN_TORRID_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.CHAIN_TORRID_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.CHAIN_TORRID_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.GOLDEN_TORRID_HELMET);
        trimmedArmorItem(ModItems.GOLDEN_TORRID_CHESTPLATE);
        trimmedArmorItem(ModItems.GOLDEN_TORRID_LEGGINGS);
        trimmedArmorItem(ModItems.GOLDEN_TORRID_BOOTS);
        trimmedArmorItem(ModItems.GOLDEN_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.GOLDEN_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.GOLDEN_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.GOLDEN_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.GOLDEN_TORRID_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.GOLDEN_TORRID_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.GOLDEN_TORRID_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.GOLDEN_TORRID_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.IRON_TORRID_HELMET);
        trimmedArmorItem(ModItems.IRON_TORRID_CHESTPLATE);
        trimmedArmorItem(ModItems.IRON_TORRID_LEGGINGS);
        trimmedArmorItem(ModItems.IRON_TORRID_BOOTS);
        trimmedArmorItem(ModItems.IRON_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.IRON_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.IRON_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.IRON_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.IRON_TORRID_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.IRON_TORRID_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.IRON_TORRID_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.IRON_TORRID_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.DIAMOND_TORRID_HELMET);
        trimmedArmorItem(ModItems.DIAMOND_TORRID_CHESTPLATE);
        trimmedArmorItem(ModItems.DIAMOND_TORRID_LEGGINGS);
        trimmedArmorItem(ModItems.DIAMOND_TORRID_BOOTS);
        trimmedArmorItem(ModItems.DIAMOND_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.DIAMOND_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.DIAMOND_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.DIAMOND_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.DIAMOND_TORRID_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.DIAMOND_TORRID_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.DIAMOND_TORRID_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.DIAMOND_TORRID_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.NETHERITE_TORRID_HELMET);
        trimmedArmorItem(ModItems.NETHERITE_TORRID_CHESTPLATE);
        trimmedArmorItem(ModItems.NETHERITE_TORRID_LEGGINGS);
        trimmedArmorItem(ModItems.NETHERITE_TORRID_BOOTS);
        trimmedArmorItem(ModItems.NETHERITE_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.NETHERITE_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.NETHERITE_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.NETHERITE_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.NETHERITE_TORRID_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.NETHERITE_TORRID_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.NETHERITE_TORRID_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.NETHERITE_TORRID_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.PROFUNDIUM_TORRID_HELMET);
        trimmedArmorItem(ModItems.PROFUNDIUM_TORRID_CHESTPLATE);
        trimmedArmorItem(ModItems.PROFUNDIUM_TORRID_LEGGINGS);
        trimmedArmorItem(ModItems.PROFUNDIUM_TORRID_BOOTS);
        trimmedArmorItem(ModItems.PROFUNDIUM_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.PROFUNDIUM_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.PROFUNDIUM_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.PROFUNDIUM_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.PROFUNDIUM_TORRID_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.PROFUNDIUM_TORRID_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.PROFUNDIUM_TORRID_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.PROFUNDIUM_TORRID_EMBARIUM_BOOTS);

        basicItem(ModItems.ELYTRA_GLIDER.get());
        basicItem(ModItems.MECHANICAL_ELYTRA.get());

//        //block-items

//        evenSimplerPillarBlockItem(ModBlocks.MARBLE_PILLAR);

        wallItem(ModBlocks.MARBLE_WALL, ModBlocks.MARBLE);
        wallItem(ModBlocks.POLISHED_MARBLE_WALL, ModBlocks.POLISHED_MARBLE);
        wallItem(ModBlocks.SMOOTH_MARBLE_WALL, ModBlocks.SMOOTH_MARBLE);
        wallItem(ModBlocks.MARBLE_BRICKS_WALL, ModBlocks.MARBLE_BRICKS);
        wallItem(ModBlocks.CRACKED_MARBLE_BRICKS_WALL, ModBlocks.CRACKED_MARBLE_BRICKS);
        wallItem(ModBlocks.MOSSY_MARBLE_BRICKS_WALL, ModBlocks.MOSSY_MARBLE_BRICKS);

        fenceItem(ModBlocks.EBONY_FENCE, ModBlocks.EBONY_PLANKS);

        IronBarsItem(ModBlocks.TORRID_STEEL_BARS);
        basicItem(ModBlocks.TORRID_STEEL_DOOR.asItem());
        basicItem(ModBlocks.TORRID_STEEL_BARS_DOOR.asItem());
        basicItem(ModBlocks.EBONY_DOOR.asItem());

        buttonItem(ModBlocks.TORRID_STEEL_BUTTON, ModBlocks.TORRID_STEEL_BLOCK);
        buttonItem(ModBlocks.MARBLE_BUTTON, ModBlocks.MARBLE);
        buttonItem(ModBlocks.EBONY_BUTTON, ModBlocks.EBONY_PLANKS);

        evenSimplerBlockItem(ModBlocks.DOUBLE_POLISHED_MARBLE_SLAB);
        evenSimplerBlockItem(ModBlocks.DOUBLE_SMOOTH_MARBLE_SLAB);


        saplingItem(ModBlocks.TORRID_BUSH);
        saplingItem(ModBlocks.EBONY_SAPLING);

        basicItem(ModItems.EBONY_SIGN.get());
        basicItem(ModItems.EBONY_HANGING_SIGN.get());

        basicItem(ModItems.EBONY_BOAT.get());
        basicItem(ModItems.EBONY_CHEST_BOAT.get());

//        evenSimplerBlockItem(ModBlocks.GEM_CUTTING_STATION);
//        evenSimplerBlockItem(ModBlocks.GEM_INFUSER);
//        evenSimplerBlockItem(ModBlocks.TORRID_FURNACE);
//        evenSimplerBlockItem(ModBlocks.KETTLE);

        evenSimplerBlockItem(ModBlocks.SPEEDER_BLOCK);
        evenSimplerBlockItem(ModBlocks.RED_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.ORANGE_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.YELLOW_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.LIME_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.GREEN_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.CYAN_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.LIGHT_BLUE_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.BLUE_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.PURPLE_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.MAGENTA_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.PINK_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.LIGHT_GRAY_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.GRAY_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.BROWN_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.WHITE_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.BLACK_BOUNCER_BLOCK);

        evenSimplerBlockItem(ModBlocks.EMBARIUM_LAMP_BLOCK);
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = Unwanted.MOD_ID; // Change this to your mod id

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID,"block/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(DeferredBlock<Block> block) {
        this.withExistingParent(Unwanted.MOD_ID + ":" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                modLoc("block/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath()));
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder IronBarsItem(DeferredBlock<IronBarsBlock> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID,"block/" + item.getId().getPath()));
    }
}
