package com.fork.unwanted.blocks.entity.custom;

import com.fork.unwanted.blocks.entity.ModBlockEntities;
import com.fork.unwanted.items.ModItems;
import com.fork.unwanted.recipe.GemCuttingStationRecipe;
import com.fork.unwanted.recipe.GemInfuserRecipe;
import com.fork.unwanted.recipe.ModRecipes;
import com.fork.unwanted.recipe.input.GemCuttingStationRecipeInput;
import com.fork.unwanted.recipe.input.GemInfuserRecipeInput;
import com.fork.unwanted.screen.GemInfuserMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentType;
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
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.RenderUtil;

import javax.annotation.Nonnull;
import java.util.Optional;

public class GemInfuserBlockEntity extends BlockEntity implements MenuProvider, GeoBlockEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this) {};

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

    public GemInfuserBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.GEM_INFUSER_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        data = new ContainerData() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: return GemInfuserBlockEntity.this.progress;
                    case 1: return GemInfuserBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }
            @Override
            public void set(int index, int value) {
                switch(index) {
                    case 0: GemInfuserBlockEntity.this.progress = value;
                    case 1: GemInfuserBlockEntity.this.maxProgress = value;
                }
            }
            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public ItemStack getRenderStack() {
        if(itemHandler.getStackInSlot(3).isEmpty()) {
            return itemHandler.getStackInSlot(1);
        }
        else {
            return itemHandler.getStackInSlot(3);
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Gem Infuser");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new GemInfuserMenu(pContainerId, pInventory, this, this.data);

    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("gem_infuser.progress", progress);
        pTag.putInt("gem_infuser.max_progress", maxProgress);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("gem_infuser.progress");
        maxProgress = pTag.getInt("gem_infuser.max_progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, GemInfuserBlockEntity pBlockEntity) {
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

    public static boolean hasRecipe(GemInfuserBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<RecipeHolder<GemInfuserRecipe>> match = level.getRecipeManager()
                .getRecipeFor(ModRecipes.GEM_INFUSER_TYPE.get(), new GemInfuserRecipeInput(
                        entity.itemHandler.getStackInSlot(1), // Armor
                        entity.itemHandler.getStackInSlot(2)  // Gem
                ), level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().value().output())
                && hasWaterInWaterSlot(entity);
    }

    private static boolean hasWaterInWaterSlot(GemInfuserBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(0).getItem() == ModItems.BLAZING_WATER.get();
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    private static boolean hasGemInGemSlot(GemInfuserBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).getItem() == ModItems.EMBARIUM.get();
    }

    public static void craftItem(GemInfuserBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<RecipeHolder<GemInfuserRecipe>> match = level.getRecipeManager()
                .getRecipeFor(ModRecipes.GEM_INFUSER_TYPE.get(), new GemInfuserRecipeInput(
                        entity.itemHandler.getStackInSlot(1), // Armor
                        entity.itemHandler.getStackInSlot(2)  // Gem
                ), level);

        if(match.isPresent()) {
            ItemStack input = entity.itemHandler.getStackInSlot(1);

            entity.itemHandler.extractItem(0,1, false);
            entity.itemHandler.extractItem(1,1, false);
            entity.itemHandler.extractItem(2,1, false);

            ItemStack result = match.get().value().output();
            result.setDamageValue(input.getDamageValue());
//            input.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
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

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(isCrafting()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.gem_infuser.use", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        else {
            return PlayState.STOP;
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object blockEntity) {
        return RenderUtil.getCurrentTick();
    }
}