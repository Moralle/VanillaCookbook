package com.morallenplay.vanillacookbook.setup;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class Tags {
	
	public static final TagKey<Item> EASTER_EGG_ITEMS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("vanillacookbook:easter_egg_items"));
}
