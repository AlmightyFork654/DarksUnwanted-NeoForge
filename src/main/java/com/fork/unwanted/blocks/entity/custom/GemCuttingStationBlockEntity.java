package com.fork.unwanted.blocks.entity.custom;

import com.fork.unwanted.blocks.entity.ModBlockEntities;
import com.fork.unwanted.items.ModItems;
import com.fork.unwanted.misc.ModTags;
import com.fork.unwanted.recipe.GemCuttingStationRecipe;
import com.fork.unwanted.recipe.ModRecipes;
import com.fork.unwanted.recipe.input.GemCuttingStationRecipeInput;
import com.fork.unwanted.screen.GemCuttingStationMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Optional;

public class GemCuttingStationBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()){
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;

    public GemCuttingStationBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.GEM_CUTTING_STATION_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        data = new ContainerData() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: return GemCuttingStationBlockEntity.this.progress;
                    case 1: return GemCuttingStationBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }
            @Override
            public void set(int index, int value) {
                switch(index) {
                    case 0: GemCuttingStationBlockEntity.this.progress = value;
                    case 1: GemCuttingStationBlockEntity.this.maxProgress = value;
                }
            }
            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public ItemStack getRenderStack() {
            return itemHandler.getStackInSlot(2);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Gem Cutting Station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new GemCuttingStationMenu(pContainerId, pInventory, this, this.data);

    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("gem_cutting_station.progress", progress);
        pTag.putInt("gem_cutting_station.max_progress", maxProgress);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("gem_cutting_station.progress");
        maxProgress = pTag.getInt("gem_cutting_station.max_progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, GemCuttingStationBlockEntity pBlockEntity) {
        if(hasRecipe(pBlockEntity)) {
            pBlockEntity.progress++;
            setChanged(pLevel, pPos, pState);
            if(pBlockEntity.progress > pBlockEntity.maxProgress) {
                craftItem(pBlockEntity);
                pBlockEntity.resetProgress();
            }
        } else {
            pBlockEntity.resetProgress();
            setChanged(pLevel, pPos, pState);
        }
    }

    private static boolean hasRecipe(GemCuttingStationBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<RecipeHolder<GemCuttingStationRecipe>> match = level.getRecipeManager()
                .getRecipeFor(ModRecipes.GEM_CUTTING_TYPE.get(), new GemCuttingStationRecipeInput(
                        entity.itemHandler.getStackInSlot(1), // Gem
                        entity.itemHandler.getStackInSlot(2)  // Chisel
                ), level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().value().output())
                && hasWaterInWaterSlot(entity) && hasToolsInToolSlot(entity);
    }

    private static boolean hasWaterInWaterSlot(GemCuttingStationBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(0).getItem() == ModItems.BLAZING_WATER.get();
    }

    private static boolean hasToolsInToolSlot(GemCuttingStationBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).is(ModTags.Items.CHISELS);
    }

    private static void craftItem(GemCuttingStationBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

//        Optional<RecipeHolder<GemCuttingStationRecipe>> match = level.getRecipeManager()
//                .getRecipeFor(ModRecipes.GEM_CUTTING_TYPE.get(), new GemCuttingStationRecipeInput(), level);

        Optional<RecipeHolder<GemCuttingStationRecipe>> match = level.getRecipeManager()
                .getRecipeFor(ModRecipes.GEM_CUTTING_TYPE.get(), new GemCuttingStationRecipeInput(
                        entity.itemHandler.getStackInSlot(1), // Gem
                        entity.itemHandler.getStackInSlot(2)  // Chisel
                ), level);

        if(match.isPresent()) {
            entity.itemHandler.extractItem(0,1, false);
            entity.itemHandler.extractItem(1,1, false);
            //entity.itemHandler.extractItem(2,1, false);
//            entity.itemHandler.getStackInSlot(2).hurt(1, RandomSource.create(), null);
//            entity.itemHandler.getStackInSlot(2).setDamageValue(entity.itemHandler.getStackInSlot(2).getDamageValue() -1);

            ItemStack chisel = entity.itemHandler.getStackInSlot(2);
            if (!chisel.isEmpty() && chisel.isDamageableItem()) {
                int newDamage = chisel.getDamageValue() + 1;
                if (newDamage >= chisel.getMaxDamage()) {
                    entity.itemHandler.setStackInSlot(2, ItemStack.EMPTY);
                } else {
                    chisel.setDamageValue(newDamage);
                    entity.itemHandler.setStackInSlot(2, chisel);
                }
            }
            entity.itemHandler.setStackInSlot(3, new ItemStack(match.get().value().output().getItem(),
                    entity.itemHandler.getStackInSlot(3).getCount() + 1));

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(3).getItem() == output.getItem() || inventory.getItem(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}