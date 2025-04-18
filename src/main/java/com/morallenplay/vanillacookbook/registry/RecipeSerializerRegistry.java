package com.morallenplay.vanillacookbook.registry;

import java.util.function.Supplier;

import com.morallenplay.vanillacookbook.VanillaCookbook;
import com.morallenplay.vanillacookbook.setup.SetRemainderRecipeSerializer;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RecipeSerializerRegistry {
	
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, VanillaCookbook.MODID);
	
	public static final Supplier<RecipeSerializer<?>> SET_REMAINDER_RECIPE = RECIPE_SERIALIZERS.register("set_remainder", SetRemainderRecipeSerializer::new);

}
