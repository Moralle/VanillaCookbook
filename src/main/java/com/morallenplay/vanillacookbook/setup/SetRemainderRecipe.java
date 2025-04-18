package com.morallenplay.vanillacookbook.setup;

import java.util.List;

import com.morallenplay.vanillacookbook.registry.RecipeSerializerRegistry;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class SetRemainderRecipe implements CraftingRecipe {
	
	//public static final RecipeSerializer<SetRemainderRecipe> SERIALIZER = new SetRemainderRecipe.Serializer();
	
	final String group;
	final CraftingBookCategory category;
	final ItemStack result;
	final NonNullList<Ingredient> ingredients;
	final List<ItemStack> contained;
	final List<ItemStack> remainder;
	private final boolean isSimple;
	   
	   public SetRemainderRecipe(String group, CraftingBookCategory category, ItemStack output, List<Ingredient> ingredients, List<ItemStack> contained, List<ItemStack> container) {
		   this.group = group;
		   this.category = category;
		   this.result = output;
		   this.ingredients = NonNullList.of(Ingredient.EMPTY, ingredients.toArray(Ingredient[]::new));
		   this.contained = contained;
		   this.remainder = container;
		   this.isSimple = ingredients.stream().allMatch(Ingredient::isSimple);
	   }
	
	@Override
	public RecipeType<?> getType() {
		return RecipeType.CRAFTING;
		}

	@Override
	public boolean matches(CraftingInput input, Level level) {
        if (input.ingredientCount() != this.ingredients.size()) {
            return false;
        } else if (!isSimple) {
            var nonEmptyItems = new java.util.ArrayList<ItemStack>(input.ingredientCount());
            for (var item : input.items())
                if (!item.isEmpty())
                    nonEmptyItems.add(item);
            return net.neoforged.neoforge.common.util.RecipeMatcher.findMatches(nonEmptyItems, this.ingredients) != null;
        } else {
            return input.size() == 1 && this.ingredients.size() == 1
                ? this.ingredients.getFirst().test(input.getItem(0))
                : input.stackedContents().canCraft(this, null);
        }
    }
	
	@Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        return this.result.copy();
    }

	@Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.ingredients.size();
    }

	@Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.result;
    }
	
	
	@Override
    public String getGroup() {
        return this.group;
    }
	
	@Override
    public CraftingBookCategory category() {
        return this.category;
    }
	
	public ItemStack getResult() {
        return this.result;
    }
	
	@Override
    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }
	
	public List<ItemStack> getContained() {
        return this.contained;
    }
	
	public List<ItemStack> getContainer() {
        return this.remainder;
    }
	
	@Override
	public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
	      NonNullList<ItemStack> nonnulllist = NonNullList.withSize(input.size(), ItemStack.EMPTY);

	      for(int i = 0; i < nonnulllist.size(); ++i) {
	         ItemStack item = input.getItem(i);
	         
	         for (int j = 0; j < contained.size(); ++j) {
	        	 
	        	 if(contained.get(j).is(item.getItem())) {
	        		 
	        	 	if (remainder.get(j).is(Items.CARROT_ON_A_STICK.getDefaultInstance().getItem())) {
	        	 		ItemStack itemstack = item.copy();
	                    itemstack.setCount(1);
	                    nonnulllist.set(i, itemstack);
	        	 	} else {
	        	 		nonnulllist.set(i, remainder.get(j).copy());
	        	 	}
	        	 }
	      	 }
	         
	      }

	      return nonnulllist;
	   }

	@Override
	public RecipeSerializer<?> getSerializer() {
		return RecipeSerializerRegistry.SET_REMAINDER_RECIPE.get();
	}
	
}