package com.morallenplay.vanillacookbook.registry;

import com.morallenplay.vanillacookbook.VanillaCookbook;
import com.morallenplay.vanillacookbook.setup.SetRemainderRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeRegistry {
	
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, VanillaCookbook.MOD_ID);
	
	public static final RegistryObject<RecipeSerializer<?>> SET_REMAINDER_RECIPE = RECIPE_SERIALIZERS.register("set_remainder", SetRemainderRecipe.Serializer::new);

}
