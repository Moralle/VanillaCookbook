package com.morallenplay.vanillacookbook.setup;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class SetRemainderRecipe implements CraftingRecipe {
	
	public static final RecipeSerializer<SetRemainderRecipe> SERIALIZER = new SetRemainderRecipe.Serializer();
	
	private final ResourceLocation id;
	final String group;
	final ItemStack result;
	final NonNullList<Ingredient> ingredients;
	final NonNullList<ItemStack> contained;
	final NonNullList<ItemStack> remainder;
	private final boolean isSimple;
	   
	   public SetRemainderRecipe(ResourceLocation location, String group, ItemStack output, NonNullList<Ingredient> ingredient, NonNullList<ItemStack> contained, NonNullList<ItemStack> container) {
		   this.id = location;
		   this.group = group;
		   this.result = output;
		   this.ingredients = ingredient;
		   this.contained = contained;
		   this.remainder = container;
		   this.isSimple = ingredient.stream().allMatch(Ingredient::isSimple);
	   }
	
	@Override
	public RecipeType<?> getType() {
		return RecipeType.CRAFTING;
		   }

	@Override
	public boolean matches(CraftingContainer c, Level level) {
	      StackedContents stackedcontents = new StackedContents();
	      java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
	      int i = 0;

	      for(int j = 0; j < c.getContainerSize(); ++j) {
	         ItemStack itemstack = c.getItem(j);
	         if (!itemstack.isEmpty()) {
	            ++i;
	            if (isSimple)
	            stackedcontents.accountStack(itemstack, 1);
	            else inputs.add(itemstack);
	         }
	      }

	      return i == this.ingredients.size() && (isSimple ? stackedcontents.canCraft(this, (IntList)null) : net.minecraftforge.common.util.RecipeMatcher.findMatches(inputs,  this.ingredients) != null);
	}

	@Override
	public ItemStack assemble(CraftingContainer c) {
		return this.result.copy();
	}

	@Override
	public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
		 return p_43999_ * p_44000_ >= this.ingredients.size();
	}

	@Override
	public ItemStack getResultItem() {
		return this.result;
	}
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
	      return this.ingredients;
	   }

	@Override
	public ResourceLocation getId() {
		return this.id;
	}
	
	@Override
	public String getGroup() {
	      return this.group;
	}
	
	@Override
	public NonNullList<ItemStack> getRemainingItems(CraftingContainer container) {
	      NonNullList<ItemStack> nonnulllist = NonNullList.withSize(container.getContainerSize(), ItemStack.EMPTY);

	      for(int i = 0; i < nonnulllist.size(); ++i) {
	         ItemStack item = container.getItem(i);
	         
	         for (int j = 0; j < contained.size(); ++j) {
	        	 
	        	 if(contained.get(j).sameItem(item)) {
	        		 
	        	 	if (remainder.get(j).sameItem(Items.CARROT_ON_A_STICK.getDefaultInstance())) {
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
		return SERIALIZER;
	}
	
	@SuppressWarnings("unused")
	public static class Serializer implements RecipeSerializer<SetRemainderRecipe> {
	      private static final ResourceLocation NAME = new ResourceLocation("minecraft", "crafting_shapeless");
	      public SetRemainderRecipe fromJson(ResourceLocation location, JsonObject object) {
	         String s = GsonHelper.getAsString(object, "group", "");
	         NonNullList<Ingredient> nonnulllist = itemsFromJson(GsonHelper.getAsJsonArray(object, "ingredients"));
	         NonNullList<ItemStack> contained = containItemFromJson(GsonHelper.getAsJsonArray(object, "contained"));
	         NonNullList<ItemStack> containers = containItemFromJson(GsonHelper.getAsJsonArray(object, "containers"));
	         if (nonnulllist.isEmpty()) {
	            throw new JsonParseException("No ingredients for shapeless recipe");
	         } else {
	            ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(object, "result"));
	            return new SetRemainderRecipe(location, s, itemstack, nonnulllist, contained, containers);
	         }
	      }

	      private static NonNullList<Ingredient> itemsFromJson(JsonArray array) {
	         NonNullList<Ingredient> nonnulllist = NonNullList.create();

	         for(int i = 0; i < array.size(); ++i) {
	            Ingredient ingredient = Ingredient.fromJson(array.get(i));
	            if (true || !ingredient.isEmpty()) { // FORGE: Skip checking if an ingredient is empty during shapeless recipe deserialization to prevent complex ingredients from caching tags too early. Can not be done using a config value due to sync issues.
	               nonnulllist.add(ingredient);
	            }
	         }

	         return nonnulllist;
	      }
	      
	      private static NonNullList<ItemStack> containItemFromJson(JsonArray array) {
		         NonNullList<ItemStack> nonnulllist = NonNullList.create();

		         for(int i = 0; i < array.size(); ++i) {
		            ItemStack item = ShapedRecipe.itemStackFromJson(GsonHelper.convertToJsonObject(array.get(i), null));
		            if (true || !item.isEmpty()) {
		               nonnulllist.add(item);
		            }
		         }

		         return nonnulllist;
		      }

	      public SetRemainderRecipe fromNetwork(ResourceLocation location, FriendlyByteBuf bytebuf) {
	         String s = bytebuf.readUtf();
	         int i = bytebuf.readVarInt();
	         NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);
	         NonNullList<ItemStack> contained = NonNullList.withSize(i, ItemStack.EMPTY);
	         NonNullList<ItemStack> containers = NonNullList.withSize(i, ItemStack.EMPTY);

	         for(int j = 0; j < nonnulllist.size(); ++j) {
	            nonnulllist.set(j, Ingredient.fromNetwork(bytebuf));
	         }
	         
	         for(int k = 0; k < contained.size(); ++k) {
	        	 contained.set(k, bytebuf.readItem());
		     }
	         
	         for(int k = 0; k < containers.size(); ++k) {
	        	 containers.set(k, bytebuf.readItem());
		     }

	         ItemStack itemstack = bytebuf.readItem();
	         return new SetRemainderRecipe(location, s, itemstack, nonnulllist, contained, containers);
	      }

	      public void toNetwork(FriendlyByteBuf bytebuf, SetRemainderRecipe recipe) {
	         bytebuf.writeUtf(recipe.group);
	         bytebuf.writeVarInt(recipe.ingredients.size());
	         bytebuf.writeVarInt(recipe.contained.size());
	         bytebuf.writeVarInt(recipe.remainder.size());

	         for(Ingredient ingredient : recipe.ingredients) {
	            ingredient.toNetwork(bytebuf);
	         }
	         
	         for(ItemStack contained : recipe.contained) {
	        	 bytebuf.writeItem(contained);
		     }
	         
	         for(ItemStack containers : recipe.remainder) {
	        	 bytebuf.writeItem(containers);
		     }

	         bytebuf.writeItem(recipe.result);
	      }
	   }

}
