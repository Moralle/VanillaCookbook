package com.morallenplay.vanillacookbook.setup;

import com.google.gson.JsonObject;
import com.morallenplay.vanillacookbook.VanillaCookbook;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class FDConfigCondition implements ICondition {
	
	private final ResourceLocation location;
	
	public FDConfigCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}
	
	@Override
	public boolean test() {
		return !Config.FD_ITEMS.get();
	}
	
	public static class Serializer implements IConditionSerializer<FDConfigCondition> {
		
		private final ResourceLocation location;
		
		public Serializer() {
			this.location = new ResourceLocation(VanillaCookbook.MOD_ID, "fd_config");
		}
		
		@Override
		public ResourceLocation getID() {
			return this.location;
		}
		
		@Override
		public FDConfigCondition read(JsonObject json) {
			return new FDConfigCondition(this.location);
		}
		
		@Override
		public void write(JsonObject json, FDConfigCondition value) {
			
		}
	}
}
