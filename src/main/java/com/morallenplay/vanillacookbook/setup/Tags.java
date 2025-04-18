package com.morallenplay.vanillacookbook.setup;

import com.morallenplay.vanillacookbook.VanillaCookbook;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class Tags {
	
	public static final TagKey<Item> EASTER_EGG_ITEMS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(VanillaCookbook.MODID, "easter_egg_items"));
}
