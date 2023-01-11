package com.morallenplay.vanillacookbook.setup;

import com.google.gson.JsonObject;
import com.morallenplay.vanillacookbook.VanillaCookbook;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class NPConfigCondition implements ICondition {
	private final ResourceLocation location;
	
	public NPConfigCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}
	
	@Override
	public boolean test(ICondition.IContext context) {
		return !Config.NP_ITEMS.get();
	}
	
	public static class Serializer implements IConditionSerializer<NPConfigCondition> {
		
		private final ResourceLocation location;
		
		public Serializer() {
			this.location = new ResourceLocation(VanillaCookbook.MOD_ID, "np_config");
		}
		
		@Override
		public ResourceLocation getID() {
			return this.location;
		}
		
		@Override
		public NPConfigCondition read(JsonObject json) {
			return new NPConfigCondition(this.location);
		}
		
		@Override
		public void write(JsonObject json, NPConfigCondition value) {
			
		}
	}
}

