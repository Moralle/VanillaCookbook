package com.morallenplay.vanillacookbook.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import com.morallenplay.vanillacookbook.setup.Config;
import com.morallenplay.vanillacookbook.util.TooltipUtils;

import java.util.List;

public class TooltipItem extends Item{
	private final boolean hasFoodEffectTooltip;
	private final boolean hasCustomTooltip;

	public TooltipItem(Properties properties) {
		super(properties);
		this.hasFoodEffectTooltip = false;
		this.hasCustomTooltip = false;
	}

	public TooltipItem(Properties properties, boolean hasFoodEffectTooltip) {
		super(properties);
		this.hasFoodEffectTooltip = hasFoodEffectTooltip;
		this.hasCustomTooltip = false;
	}

	public TooltipItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		super(properties);
		this.hasFoodEffectTooltip = hasFoodEffectTooltip;
		this.hasCustomTooltip = hasCustomTooltip;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
		
		if (this.hasCustomTooltip && Config.FOOD_SPECIAL_TOOLTIPS.get()) {
			MutableComponent textEmpty = TooltipUtils.getTranslation("tooltip." + BuiltInRegistries.ITEM.getKey(this).getPath());
			tooltip.add(textEmpty.withStyle(ChatFormatting.BLUE));
		}
		
		if (this.hasFoodEffectTooltip && Config.FOOD_EFFECT_TOOLTIPS.get()) {
			TooltipUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
		}
	}
}
