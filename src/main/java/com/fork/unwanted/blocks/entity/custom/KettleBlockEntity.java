package com.fork.unwanted.blocks.entity.custom;

import com.fork.unwanted.blocks.entity.ModBlockEntities;
import com.fork.unwanted.component.ModDataComponents;
import com.fork.unwanted.misc.ModTags;
import com.fork.unwanted.recipe.KettleRecipe;
import com.fork.unwanted.recipe.ModRecipes;
import com.fork.unwanted.recipe.input.KettleRecipeInput;
import com.fork.unwanted.screen.KettleMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class KettleBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 12;

    public KettleBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.KETTLE_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        data = new ContainerData() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: return KettleBlockEntity.this.progress;
                    case 1: return KettleBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }
            @Override
            public void set(int index, int value) {
                switch(index) {
                    case 0: KettleBlockEntity.this.progress = value;
                    case 1: KettleBlockEntity.this.maxProgress = value;
                }
            }
            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Kettle");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new KettleMenu(pContainerId, pInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("kettle.progress", progress);
        pTag.putInt("kettle.max_progress", maxProgress);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("kettle.progress");
        maxProgress = pTag.getInt("kettle.max_progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, KettleBlockEntity pBlockEntity) {
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

    private static boolean hasRecipe(KettleBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<RecipeHolder<KettleRecipe>> match = level.getRecipeManager()
                .getRecipeFor(ModRecipes.KETTLE_TYPE.get(), new KettleRecipeInput(
                        entity.itemHandler.getStackInSlot(0), // Base
                        entity.itemHandler.getStackInSlot(1)  // Ingredient
                ), level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().value().output())
                && dataComponentsMatch(inventory, match.get().value().assemble(new KettleRecipeInput(inventory.getItem(0), inventory.getItem(1)), level.registryAccess()));
    }

    private static void craftItem(KettleBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<RecipeHolder<KettleRecipe>> match = level.getRecipeManager()
                .getRecipeFor(ModRecipes.KETTLE_TYPE.get(), new KettleRecipeInput(
                        entity.itemHandler.getStackInSlot(0), // Base
                        entity.itemHandler.getStackInSlot(1)  // Ingredient
                ), level);

        if (match.isPresent()) {
            ItemStack craftedItem = match.get().value().assemble(
                    new KettleRecipeInput(inventory.getItem(0), inventory.getItem(1)), level.registryAccess());

            entity.itemHandler.extractItem(0, 1, false);
            entity.itemHandler.extractItem(1, 1, false);

            ItemStack outputStack = entity.itemHandler.getStackInSlot(2);
            if (outputStack.isEmpty()) {
                entity.itemHandler.setStackInSlot(2, craftedItem);
            } else {
                outputStack.grow(1);
            }

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(2).getItem() == output.getItem() || inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }

    private static boolean dataComponentsMatch(SimpleContainer inventory, ItemStack output) {
        ItemStack itemInSlot2 = inventory.getItem(2);
        if (itemInSlot2.isEmpty()) {
            return true;
        }

        String slot2TeaType = itemInSlot2.getOrDefault(ModDataComponents.TEA_TYPE.get(), "");
        List<String> slot2Additions = itemInSlot2.getOrDefault(ModDataComponents.TEA_ADDITION.get(), List.of());
        List<String> slot2Modifiers = itemInSlot2.getOrDefault(ModDataComponents.TEA_MODIFIER.get(), List.of());
        String slot2Teleport = itemInSlot2.getOrDefault(ModDataComponents.TEA_TELEPORT.get(), "");

        String outputTeaType = output.getOrDefault(ModDataComponents.TEA_TYPE.get(), "");
        List<String> outputAdditions = output.getOrDefault(ModDataComponents.TEA_ADDITION.get(), List.of());
        List<String> outputModifiers = output.getOrDefault(ModDataComponents.TEA_MODIFIER.get(), List.of());
        String outputTeleport = output.getOrDefault(ModDataComponents.TEA_TELEPORT.get(), "");

        return slot2TeaType.equals(outputTeaType)
                && slot2Additions.equals(outputAdditions)
                && slot2Modifiers.equals(outputModifiers)
                && slot2Teleport.equals(outputTeleport);
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