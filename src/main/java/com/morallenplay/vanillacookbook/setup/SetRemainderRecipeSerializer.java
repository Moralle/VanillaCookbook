package com.morallenplay.vanillacookbook.setup;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class SetRemainderRecipeSerializer implements RecipeSerializer<SetRemainderRecipe> {
	
	
	
	public static final MapCodec<SetRemainderRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
			Codec.STRING.optionalFieldOf("group", "").forGetter(SetRemainderRecipe::getGroup),
            CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(SetRemainderRecipe::category),

            ItemStack.CODEC.fieldOf("result").forGetter(SetRemainderRecipe::getResult),
            Ingredient.LIST_CODEC_NONEMPTY.fieldOf("ingredients").xmap(ingredients -> {
				NonNullList<Ingredient> nonNullList = NonNullList.create();
				nonNullList.addAll(ingredients);
				return nonNullList;
			}, ingredients -> ingredients).forGetter(SetRemainderRecipe::getIngredients),
            ItemStack.CODEC.listOf().fieldOf("contained").forGetter(SetRemainderRecipe::getContained),
            ItemStack.CODEC.listOf().fieldOf("container").forGetter(SetRemainderRecipe::getContainer)
    ).apply(inst, SetRemainderRecipe::new));
	public static final StreamCodec<RegistryFriendlyByteBuf, SetRemainderRecipe> STREAM_CODEC =
            StreamCodec.composite(
            		
            		ByteBufCodecs.STRING_UTF8, SetRemainderRecipe::getGroup,
            		CraftingBookCategory.STREAM_CODEC, SetRemainderRecipe::category,
            		ItemStack.STREAM_CODEC, SetRemainderRecipe::getResult,
            		Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()), SetRemainderRecipe::getIngredients,
                    ItemStack.LIST_STREAM_CODEC, SetRemainderRecipe::getContained,
                    ItemStack.LIST_STREAM_CODEC, SetRemainderRecipe::getContainer,

            		SetRemainderRecipe::new
            );

        @Override
    public MapCodec<SetRemainderRecipe> codec() {
            return CODEC;
    }

        @Override
    public StreamCodec<RegistryFriendlyByteBuf, SetRemainderRecipe> streamCodec() {
            return STREAM_CODEC;
    }
 }
