package com.morallenplay.vanillacookbook.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.morallenplay.vanillacookbook.setup.Config;
import com.morallenplay.vanillacookbook.util.TooltipUtils;

import javax.annotation.Nullable;
import java.util.List;

public class TooltipItem extends Item{
	private final boolean hasFoodEffectTooltip;
	private final boolean hasCustomTooltip;

	/**
	 * Items that can be consumed by an entity.
	 * When consumed, they may affect the consumer somehow, and will give back containers if applicable, regardless of their stack size.
	 */
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
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
		
		if (this.hasCustomTooltip && Config.FOOD_SPECIAL_TOOLTIPS.get()) {
			MutableComponent textEmpty = TooltipUtils.getTranslation("tooltip." + this);
			tooltip.add(textEmpty.withStyle(ChatFormatting.BLUE));
		}
		
		if (this.hasFoodEffectTooltip && Config.FOOD_EFFECT_TOOLTIPS.get()) {
			TooltipUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
		}
	}
}
