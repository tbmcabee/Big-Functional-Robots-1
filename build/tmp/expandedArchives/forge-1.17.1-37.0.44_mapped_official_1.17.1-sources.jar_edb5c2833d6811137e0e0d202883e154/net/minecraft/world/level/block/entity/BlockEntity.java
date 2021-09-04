package net.minecraft.world.level.block.entity;

import javax.annotation.Nullable;
import net.minecraft.CrashReportCategory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BlockEntity extends net.minecraftforge.common.capabilities.CapabilityProvider<BlockEntity> implements net.minecraftforge.common.extensions.IForgeBlockEntity {
   private static final Logger LOGGER = LogManager.getLogger();
   private final BlockEntityType<?> type;
   @Nullable
   protected Level level;
   protected final BlockPos worldPosition;
   protected boolean remove;
   private BlockState blockState;
   private CompoundTag customTileData;

   public BlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
      super(BlockEntity.class);
      this.type = p_155228_;
      this.worldPosition = p_155229_.immutable();
      this.blockState = p_155230_;
      this.gatherCapabilities();
   }

   @Nullable
   public Level getLevel() {
      return this.level;
   }

   public void setLevel(Level p_155231_) {
      this.level = p_155231_;
   }

   public boolean hasLevel() {
      return this.level != null;
   }

   public void load(CompoundTag p_155245_) {
      if (p_155245_.contains("ForgeData")) this.customTileData = p_155245_.getCompound("ForgeData");
      if (getCapabilities() != null && p_155245_.contains("ForgeCaps")) deserializeCaps(p_155245_.getCompound("ForgeCaps"));
   }

   public CompoundTag save(CompoundTag p_58888_) {
      return this.saveMetadata(p_58888_);
   }

   private CompoundTag saveMetadata(CompoundTag p_58895_) {
      ResourceLocation resourcelocation = BlockEntityType.getKey(this.getType());
      if (resourcelocation == null) {
         throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
      } else {
         p_58895_.putString("id", resourcelocation.toString());
         p_58895_.putInt("x", this.worldPosition.getX());
         p_58895_.putInt("y", this.worldPosition.getY());
         p_58895_.putInt("z", this.worldPosition.getZ());
         if (this.customTileData != null) p_58895_.put("ForgeData", this.customTileData);
         if (getCapabilities() != null) p_58895_.put("ForgeCaps", serializeCaps());
         return p_58895_;
      }
   }

   @Nullable
   public static BlockEntity loadStatic(BlockPos p_155242_, BlockState p_155243_, CompoundTag p_155244_) {
      String s = p_155244_.getString("id");
      ResourceLocation resourcelocation = ResourceLocation.tryParse(s);
      if (resourcelocation == null) {
         LOGGER.error("Block entity has invalid type: {}", (Object)s);
         return null;
      } else {
         return Registry.BLOCK_ENTITY_TYPE.getOptional(resourcelocation).map((p_155240_) -> {
            try {
               return p_155240_.create(p_155242_, p_155243_);
            } catch (Throwable throwable) {
               LOGGER.error("Failed to create block entity {}", s, throwable);
               return null;
            }
         }).map((p_155249_) -> {
            try {
               p_155249_.load(p_155244_);
               return p_155249_;
            } catch (Throwable throwable) {
               LOGGER.error("Failed to load data for block entity {}", s, throwable);
               return null;
            }
         }).orElseGet(() -> {
            LOGGER.warn("Skipping BlockEntity with id {}", (Object)s);
            return null;
         });
      }
   }

   public void setChanged() {
      if (this.level != null) {
         setChanged(this.level, this.worldPosition, this.blockState);
      }

   }

   protected static void setChanged(Level p_155233_, BlockPos p_155234_, BlockState p_155235_) {
      p_155233_.blockEntityChanged(p_155234_);
      if (!p_155235_.isAir()) {
         p_155233_.updateNeighbourForOutputSignal(p_155234_, p_155235_.getBlock());
      }

   }

   public BlockPos getBlockPos() {
      return this.worldPosition;
   }

   public BlockState getBlockState() {
      return this.blockState;
   }

   @Nullable
   public ClientboundBlockEntityDataPacket getUpdatePacket() {
      return null;
   }

   public CompoundTag getUpdateTag() {
      return this.saveMetadata(new CompoundTag());
   }

   public boolean isRemoved() {
      return this.remove;
   }

   public void setRemoved() {
      this.remove = true;
      this.invalidateCaps();
      requestModelDataUpdate();
   }

   @Override
   public void onChunkUnloaded() {
      this.invalidateCaps();
   }

   public void clearRemoved() {
      this.remove = false;
   }

   public boolean triggerEvent(int p_58889_, int p_58890_) {
      return false;
   }

   public void fillCrashReportCategory(CrashReportCategory p_58887_) {
      p_58887_.setDetail("Name", () -> {
         return Registry.BLOCK_ENTITY_TYPE.getKey(this.getType()) + " // " + this.getClass().getCanonicalName();
      });
      if (this.level != null) {
         CrashReportCategory.populateBlockDetails(p_58887_, this.level, this.worldPosition, this.getBlockState());
         CrashReportCategory.populateBlockDetails(p_58887_, this.level, this.worldPosition, this.level.getBlockState(this.worldPosition));
      }
   }

   public boolean onlyOpCanSetNbt() {
      return false;
   }

   public BlockEntityType<?> getType() {
      return this.type;
   }

   @Override
   public CompoundTag getTileData() {
      if (this.customTileData == null)
         this.customTileData = new CompoundTag();
      return this.customTileData;
   }

   @Deprecated
   public void setBlockState(BlockState p_155251_) {
      this.blockState = p_155251_;
   }
}
