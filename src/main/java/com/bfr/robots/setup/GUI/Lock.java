package com.bfr.robots.setup.GUI;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Nameable;
import net.minecraft.network.chat.Component;
import net.minecraft.world.LockCode;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nonnull;

/**
 * Default implementation of {@link ILock}.
 *
 * @author Choonster
 */
public class Lock implements INBTSerializable<CompoundTag> {
	/**
	 * The lock code.
	 */
	@Nonnull
	private LockCode code = LockCode.NO_LOCK;

	private final Nameable nameProvider;

	public Lock(final Nameable nameProvider) {
		this.nameProvider = nameProvider;
	}

	public boolean isLocked() {
		// An empty ItemStack can only unlock an empty lock code
		return !getLockCode().unlocksWith(ItemStack.EMPTY);
	}

	public LockCode getLockCode() {
		return code;
	}

	public void setLockCode(final LockCode code) {
		this.code = code;
	}

	@Override
	public CompoundTag serializeNBT() {
		final CompoundTag tagCompound = new CompoundTag();

		code.addToTag(tagCompound);

		return tagCompound;
	}

	@Override
	public void deserializeNBT(final CompoundTag nbt) {
		code = LockCode.fromTag(nbt);
	}

	public Component getDisplayName() {
		return nameProvider.getDisplayName();
	}
}
