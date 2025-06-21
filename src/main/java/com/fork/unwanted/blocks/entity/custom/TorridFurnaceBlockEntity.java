package com.fork.unwanted.blocks.entity.custom;

import com.fork.unwanted.blocks.entity.ModBlockEntities;
import com.fork.unwanted.misc.ModTags;
import com.fork.unwanted.recipe.KettleRecipe;
import com.fork.unwanted.recipe.ModRecipes;
import com.fork.unwanted.recipe.TorridFurnaceRecipe;
import com.fork.unwanted.recipe.input.KettleRecipeInput;
import com.fork.unwanted.recipe.input.TorridFurnaceRecipeInput;
import com.fork.unwanted.screen.TorridFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Optional;

public class TorridFurnaceBlockEntity extends BlockEntity implements MenuProvider {
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
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public TorridFurnaceBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.TORRID_FURNACE_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: return TorridFurnaceBlockEntity.this.progress;
                    case 1: return TorridFurnaceBlockEntity.this.maxProgress;
                    case 2: return TorridFurnaceBlockEntity.this.fuelTime;
                    case 3: return TorridFurnaceBlockEntity.this.maxFuelTime;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch(index) {
                    case 0: TorridFurnaceBlockEntity.this.progress = value;
                    case 1: TorridFurnaceBlockEntity.this.maxProgress = value;
                    case 2: TorridFurnaceBlockEntity.this.fuelTime = value;
                    case 3: TorridFurnaceBlockEntity.this.maxFuelTime = value;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    public  ItemStack getRenderStack() {
        if(itemHandler.getStackInSlot(3).isEmpty()) {
            return itemHandler.getStackInSlot(2);
        }
        else {
            return itemHandler.getStackInSlot(3);
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Torrid Furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new TorridFurnaceMenu(pContainerId, pInventory, this, this.data);

    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("torrid_furnace.progress", progress);
        pTag.putInt("torrid_furnace.max_progress", maxProgress);
        pTag.putInt("torrid_furnace.fuelTime", fuelTime);
        pTag.putInt("torrid_furnace.maxFuelTime", maxFuelTime);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("torrid_furnace.progress");
        maxProgress = pTag.getInt("torrid_furnace.max_progress");
        fuelTime = pTag.getInt("torrid_furnace.fuelTime");
        maxFuelTime = pTag.getInt("torrid_furnace.maxFuelTime");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    private void consumeFuel() {
        if(!itemHandler.getStackInSlot(0).isEmpty()) {
            this.fuelTime = EventHooks.getItemBurnTime(this.itemHandler.extractItem(0, 1, false), this.itemHandler.getStackInSlot(0).getBurnTime(RecipeType.SMELTING) ,RecipeType.SMELTING); //error?
            this.maxFuelTime = this.fuelTime;
        }
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, TorridFurnaceBlockEntity pBlockEntity) {
        if(hasRecipe(pBlockEntity)) {
            if (hasFuelInFuelSlot(pBlockEntity) && !isConsumingFuel(pBlockEntity)) {
                pBlockEntity.consumeFuel();
            }
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
        if(isConsumingFuel(pBlockEntity)) {
            pBlockEntity.fuelTime--;
        }
    }

    private static boolean hasRecipe(TorridFurnaceBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<RecipeHolder<TorridFurnaceRecipe>> match = level.getRecipeManager()
                .getRecipeFor(ModRecipes.TORRID_FURNACE_TYPE.get(), new TorridFurnaceRecipeInput(
                        entity.itemHandler.getStackInSlot(1), // Ingot
                        entity.itemHandler.getStackInSlot(2)  // Armor/Tool
                ), level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().value().output())
                && (hasFuelInFuelSlot(entity) || isConsumingFuel(entity));
    }

    private static boolean hasFuelInFuelSlot(TorridFurnaceBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(0).is(ModTags.Items.ALL_FUELS);
    }

    private static boolean isConsumingFuel (TorridFurnaceBlockEntity entity) {
        return entity.fuelTime > 0;
    }

    private static void craftItem(TorridFurnaceBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<RecipeHolder<TorridFurnaceRecipe>> match = level.getRecipeManager()
                .getRecipeFor(ModRecipes.TORRID_FURNACE_TYPE.get(), new TorridFurnaceRecipeInput(
                        entity.itemHandler.getStackInSlot(1), // Ingot
                        entity.itemHandler.getStackInSlot(2)  // Armor/Tool
                ), level);

        if(match.isPresent()) {
            ItemStack input = entity.itemHandler.getStackInSlot(2);

            entity.itemHandler.extractItem(1,1, false);
            entity.itemHandler.extractItem(2,1, false);

            ItemStack result = match.get().value().output();
            result.setDamageValue(input.getDamageValue());
            result.set(DataComponents.ENCHANTMENTS, input.get(DataComponents.ENCHANTMENTS));
            if(input.has(DataComponents.CUSTOM_NAME)) {
                result.set(DataComponents.CUSTOM_NAME, input.getHoverName());
            }
            result.set(DataComponents.REPAIR_COST, input.get(DataComponents.REPAIR_COST));
            entity.itemHandler.setStackInSlot(3, result);

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