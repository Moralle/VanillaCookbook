package com.morallenplay.vanillacookbook.item;

import net.minecraft.world.item.ChorusFruitItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;
import net.minecraftforge.fml.ModList;

public class CompatChorusItem extends ChorusFruitItem {
	private String modid;
	public CompatChorusItem(Item.Properties builder, String id) {
		super(builder);
		this.modid = id;
	}

//	@Override
//	public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
//
//		if (allowedIn(group)) {
//			if (ModList.get().isLoaded(modid)) {
//				items.add(new ItemStack(this));
//			} else {
//				items.remove(new ItemStack(this));
//			}
//		}
//	}
}