package com.morallenplay.vanillacookbook.registry;

import com.morallenplay.vanillacookbook.VanillaCookbook;
import com.morallenplay.vanillacookbook.item.CactusSliceItem;
import com.morallenplay.vanillacookbook.item.CheeseItem;
import com.morallenplay.vanillacookbook.item.ChorusJuiceItem;
import com.morallenplay.vanillacookbook.item.CompatCheeseItem;
import com.morallenplay.vanillacookbook.item.CompatChorusItem;
import com.morallenplay.vanillacookbook.item.CompatItem;
import com.morallenplay.vanillacookbook.item.CureItem;
import com.morallenplay.vanillacookbook.item.IceCreamItem;
import com.morallenplay.vanillacookbook.item.JuiceItem;
import com.morallenplay.vanillacookbook.item.MilkBottleItem;
import com.morallenplay.vanillacookbook.item.SludgeItem;
import com.morallenplay.vanillacookbook.item.ContainerItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ItemRegistry {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VanillaCookbook.MOD_ID);
	
	private static final Map<String, RegistryObject<Item>> itemMap = new LinkedHashMap<>();
	
	public static final RegistryObject<Item> COOKED_BAMBOO = registerItem("cooked_bamboo", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).build())));
	public static final RegistryObject<Item> COOKED_BEETROOT = registerItem("cooked_beetroot", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).build())));
	public static final RegistryObject<Item> COOKED_EGG = registerItem("cooked_egg", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.45F).build())));
	public static final RegistryObject<Item> GRILLED_MELON = registerItem("grilled_melon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.45F).build())));
	public static final RegistryObject<Item> BAKED_APPLE = registerItem("baked_apple", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.4F).build())));
	public static final RegistryObject<Item> COOKED_TURTLE_EGG = registerItem("cooked_turtle_egg", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).build())));
	public static final RegistryObject<Item> CACTUS_SLICE = registerItem("cactus_slice", () -> new CactusSliceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).build()), 2.0F, 0.5F));
	public static final RegistryObject<Item> COOKED_CACTUS_SLICE = registerItem("cooked_cactus_slice", () -> new CactusSliceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.75F).build()), 1.0F, 0.25F));
	public static final RegistryObject<Item> CHEESE = registerItem("cheese", () -> new CheeseItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).build())));
	public static final RegistryObject<Item> GARDEN_SOUP = registerItem("garden_soup", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> PUMPKIN_SOUP = registerItem("pumpkin_soup", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.75F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> FISH_STEW = registerItem("fish_stew", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.2F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> VEGETABLE_STEW = registerItem("vegetable_stew", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> MEATY_STEW = registerItem("meaty_stew", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(1.0F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> CHICKEN_SOUP = registerItem("chicken_soup", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.8F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> INK_SOUP = registerItem("ink_soup", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.1F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> GLOW_INK_SOUP = registerItem("glow_ink_soup", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.15F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100, 0), 0.1F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> FUNGUS_STEW = registerItem("fungus_stew", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> SMOLDERING_STEW = registerItem("smoldering_stew", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> PLAIN_SALAD = registerItem("plain_salad", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> KELP_SALAD = registerItem("kelp_salad", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> FRUIT_SALAD = registerItem("fruit_salad", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> GOLDEN_FRUIT_SALAD = registerItem("golden_fruit_salad", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.75F).effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> ROOT_SALAD = registerItem("root_salad", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.1F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> MASHED_POTATOES = registerItem("mashed_potatoes", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.65F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> APPLE_SAUCE = registerItem("apple_sauce", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> MUSHROOM_SCRAMBLED_EGGS = registerItem("mushroom_scrambled_eggs", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.65F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> PUDDING = registerItem("pudding", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> CHOCOLATE_PUDDING = registerItem("chocolate_pudding", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.75F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> JELLY = registerItem("jelly", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.45F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> MAGMA_JELLY = registerItem("magma_jelly", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.45F).build()).craftRemainder(Items.BOWL).stacksTo(16)));
	public static final RegistryObject<Item> APPLE_PIE = registerItem("apple_pie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.3F).build())));
	public static final RegistryObject<Item> BEETROOT_PIE = registerItem("beetroot_pie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.35F).build())));
	public static final RegistryObject<Item> BERRY_PIE = registerItem("berry_pie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(0.3F).build())));
	public static final RegistryObject<Item> WART_PIE = registerItem("wart_pie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.25F).build())));
	public static final RegistryObject<Item> POISONOUS_PIE = registerItem("poisonous_pie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(0.72F).effect(() -> new MobEffectInstance(MobEffects.POISON, 300, 2), 1F).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 1F).build())));
	public static final RegistryObject<Item> BERRY_COOKIE = registerItem("berry_cookie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build())));
	public static final RegistryObject<Item> HONEY_COOKIE = registerItem("honey_cookie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).build())));
	public static final RegistryObject<Item> POTATO_COOKIE = registerItem("potato_cookie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build())));
	public static final RegistryObject<Item> PUMPKIN_COOKIE = registerItem("pumpkin_cookie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build())));
	public static final RegistryObject<Item> SUNFLOWER_SEED_COOKIE = registerItem("sunflower_seed_cookie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build())));
	public static final RegistryObject<Item> PANCAKE = registerItem("pancake", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.66F).build())));
	public static final RegistryObject<Item> BERRY_PANCAKE = registerItem("berry_pancake", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.65F).build())));
	public static final RegistryObject<Item> HONEY_PANCAKE = registerItem("honey_pancake", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(9).saturationMod(0.7F).build())));
	public static final RegistryObject<Item> BACON_PANCAKE = registerItem("bacon_pancake", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).build())));
	public static final RegistryObject<Item> CREEPE = registerItem("creepe", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build())));
	public static final RegistryObject<Item> BROWNIE = registerItem("brownie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.55F).build())));
	public static final RegistryObject<Item> BERRY_BROWNIE = registerItem("berry_brownie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(0.5F).build())));
	public static final RegistryObject<Item> ICE_CREAM = registerItem("ice_cream", () -> new IceCreamItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));
	public static final RegistryObject<Item> CHOCOLATE_ICE_CREAM = registerItem("chocolate_ice_cream", () -> new IceCreamItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).build())));
	public static final RegistryObject<Item> BERRY_ICE_CREAM = registerItem("berry_ice_cream", () -> new IceCreamItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.8F).build())));
	public static final RegistryObject<Item> NEAPOLITAN_ICE_CREAM = registerItem("neapolitan_ice_cream", () -> new IceCreamItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).build())));
	public static final RegistryObject<Item> PUMPSICLE = registerItem("pumpsicle", () -> new IceCreamItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.45F).build()).craftRemainder(Items.STICK).stacksTo(16)));
	public static final RegistryObject<Item> SNOW_HORN = registerItem("snow_horn", () -> new IceCreamItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(0.6F).build())));
	public static final RegistryObject<Item> GLAZED_GLOW_BERRIES = registerItem("glazed_glow_berries", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0), 1F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 400, 0), 1F).build()).craftRemainder(Items.STICK).stacksTo(16)));
	public static final RegistryObject<Item> POTATO_CHIPS = registerItem("potato_chips", () -> new CureItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).fast().alwaysEat().build()), MobEffects.HUNGER, 0.5F));
	public static final RegistryObject<Item> HOT_POTATO_CHIPS = registerItem("hot_potato_chips", () -> new CureItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).fast().alwaysEat().build()), MobEffects.HUNGER, 0.5F));
	public static final RegistryObject<Item> BEET_CHIPS = registerItem("beet_chips", () -> new CureItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.45F).fast().alwaysEat().build()), MobEffects.HUNGER, 0.5F));
	public static final RegistryObject<Item> APPLE_CHIPS = registerItem("apple_chips", () -> new CureItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).fast().alwaysEat().build()), MobEffects.HUNGER, 0.5F));
	public static final RegistryObject<Item> HONEY_CANDY = registerItem("honey_candy", () -> new CureItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.175F).fast().alwaysEat().build()), MobEffects.HUNGER, 0.3F));
	public static final RegistryObject<Item> BERRY_CANDY = registerItem("berry_candy", () -> new CureItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.1F).fast().alwaysEat().build()), MobEffects.HUNGER, 0.3F));
	public static final RegistryObject<Item> WARPED_GUMMY = registerItem("warped_gummy", () -> new CureItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).fast().alwaysEat().build()), MobEffects.WITHER, 1.0F));
	public static final RegistryObject<Item> CHOCOLATE = registerItem("chocolate", () -> new CureItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).fast().alwaysEat().build()), MobEffects.HUNGER, 0.3F));
	public static final RegistryObject<Item> SWORD_LOLLIPOP = registerItem("sword_lollipop", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.15F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0F).build()).craftRemainder(Items.STICK).stacksTo(16)));
	public static final RegistryObject<Item> TRAIL_MIX = registerItem("trail_mix", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).build())));
	public static final RegistryObject<Item> HOT_CHICKEN_DRUMSTICK = registerItem("hot_chicken_drumstick", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).build())));
	public static final RegistryObject<Item> FISH_AND_CHIPS = registerItem("fish_and_chips", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(0.7F).build())));
	public static final RegistryObject<Item> KEBAB = registerItem("kebab", () -> new ContainerItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(9).saturationMod(0.8F).build()).craftRemainder(Items.STICK).stacksTo(16)));
	public static final RegistryObject<Item> MEATLOAF = registerItem("meatloaf", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.95F).build())));
	public static final RegistryObject<Item> MEATBALL = registerItem("meatball", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).fast().build())));
	public static final RegistryObject<Item> SPICY_MEATBALL = registerItem("spicy_meatball", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).fast().build())));
	public static final RegistryObject<Item> FRENCH_TOAST = registerItem("french_toast", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).build())));
	public static final RegistryObject<Item> POTATO_PANCAKE = registerItem("potato_pancake", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).build())));
	public static final RegistryObject<Item> STUFFED_SEA_PICKLE = registerItem("stuffed_sea_pickle", () -> new CheeseItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build())));
	public static final RegistryObject<Item> MINERS_SALAD = registerItem("miners_salad", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(0.15F).build())));
	public static final RegistryObject<Item> NETHERITE_APPLE = registerItem("netherite_apple", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1.2F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 2), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1), 1.0F).alwaysEat().build()).fireResistant().rarity(Rarity.RARE)));
	public static final RegistryObject<Item> CHOCOLATE_EGG = registerItem("chocolate_egg", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).build())));
	public static final RegistryObject<Item> APPLE_JUICE = registerItem("apple_juice", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(3.6F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> BERRY_JUICE = registerItem("berry_juice", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(2.0F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> CACTUS_JUICE = registerItem("cactus_juice", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(2.4F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> MELON_JUICE = registerItem("melon_juice", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(2.4F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> SEA_PICKLE_JUICE = registerItem("sea_pickle_juice", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(1.8F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> CHORUS_JUICE = registerItem("chorus_juice", () -> new ChorusJuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(3.6F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> LEAF_TEA = registerItem("leaf_tea", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(4.8F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> FLOWER_TEA = registerItem("flower_tea", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(8.0F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> MILK_BOTTLE = registerItem("milk_bottle", () -> new MilkBottleItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(1.2F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> CHOCOLATE_MILK = registerItem("chocolate_milk", () -> new MilkBottleItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(2.4F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> BERRY_MILK = registerItem("berry_milk", () -> new MilkBottleItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(2.4F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> APPLE_SODA = registerItem("apple_soda", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(7.2F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 400, 2), 1F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).rarity(Rarity.UNCOMMON).stacksTo(16)));
	public static final RegistryObject<Item> BERRY_SODA = registerItem("berry_soda", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(4.8F).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 400, 1), 1F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).rarity(Rarity.UNCOMMON).stacksTo(16)));
	public static final RegistryObject<Item> CACTUS_SODA = registerItem("cactus_soda", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(6.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 1), 1F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).rarity(Rarity.UNCOMMON).stacksTo(16)));
	public static final RegistryObject<Item> MELON_SODA = registerItem("melon_soda", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(5.4F).effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 1), 1F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).rarity(Rarity.UNCOMMON).stacksTo(16)));
	public static final RegistryObject<Item> SEA_PICKLE_SODA = registerItem("sea_pickle_soda", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(4.0F).effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 400, 0), 1F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).rarity(Rarity.UNCOMMON).stacksTo(16)));
	public static final RegistryObject<Item> CHORUS_SODA = registerItem("chorus_soda", () -> new JuiceItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(7.2F).effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 400, 1), 1F).alwaysEat().build()).craftRemainder(Items.GLASS_BOTTLE).rarity(Rarity.UNCOMMON).stacksTo(16)));
	
	public static final RegistryObject<Item> THE_SLUDGE = ITEMS.register("the_sludge", () -> new SludgeItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(0F).alwaysEat().build())));
	
	public static final RegistryObject<Item> PIZZA = registerItem("pizza", () -> new CompatItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).build()), "farmersdelight"));
	public static final RegistryObject<Item> BERRY_CAKE_SLICE = registerItem("berry_cake_slice", () -> new CompatItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build()), "farmersdelight"));
	public static final RegistryObject<Item> CARROT_CAKE_SLICE = registerItem("carrot_cake_slice", () -> new CompatItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build()), "farmersdelight"));
	public static final RegistryObject<Item> CHEESECAKE_SLICE = registerItem("cheesecake_slice", () -> new CompatCheeseItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build()), "farmersdelight"));
	public static final RegistryObject<Item> CHOCOLATE_CAKE_SLICE = registerItem("chocolate_cake_slice", () -> new CompatItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build()), "farmersdelight"));
	public static final RegistryObject<Item> MOHNKUCHEN_SLICE = registerItem("mohnkuchen_slice", () -> new CompatItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build()), "farmersdelight"));
	public static final RegistryObject<Item> ICE_CREAM_CAKE_SLICE = registerItem("ice_cream_cake_slice", () -> new CompatItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build()), "farmersdelight"));
	public static final RegistryObject<Item> ROSE_CAKE_SLICE = registerItem("rose_cake_slice", () -> new CompatItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build()), "farmersdelight"));
	public static final RegistryObject<Item> CHORUS_CAKE_SLICE = registerItem("chorus_cake_slice", () -> new CompatChorusItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).build()), "farmersdelight"));
	public static final RegistryObject<Item> BOOK_CAKE_SLICE = registerItem("book_cake_slice", () -> new CompatItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build()), "farmersdelight"));
	public static final RegistryObject<Item> GLOW_BERRY_CAKE_SLICE = registerItem("glow_berry_cake_slice", () -> new CompatItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build()), "farmersdelight"));
	
	public static final RegistryObject<Item> BERRY_CAKE = registerItem("berry_cake", () -> (new BlockItem(BlockRegistry.BERRY_CAKE.get(), (new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> CARROT_CAKE = registerItem("carrot_cake", () -> (new BlockItem(BlockRegistry.CARROT_CAKE.get(), (new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> CHEESECAKE = registerItem("cheesecake", () -> (new BlockItem(BlockRegistry.CHEESECAKE.get(), (new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> CHOCOLATE_CAKE = registerItem("chocolate_cake", () -> (new BlockItem(BlockRegistry.CHOCOLATE_CAKE.get(), (new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> MOHNKUCHEN = registerItem("mohnkuchen", () -> (new BlockItem(BlockRegistry.MOHNKUCHEN.get(), (new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> ICE_CREAM_CAKE = registerItem("ice_cream_cake", () -> (new BlockItem(BlockRegistry.ICE_CREAM_CAKE.get(), (new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> ROSE_CAKE = registerItem("rose_cake", () -> (new BlockItem(BlockRegistry.ROSE_CAKE.get(), (new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> CHORUS_CAKE = registerItem("chorus_cake", () -> (new BlockItem(BlockRegistry.CHORUS_CAKE.get(), (new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> BOOK_CAKE = registerItem("book_cake", () -> (new BlockItem(BlockRegistry.BOOK_CAKE.get(), (new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> GLOW_BERRY_CAKE = registerItem("glow_berry_cake", () -> (new BlockItem(BlockRegistry.GLOW_BERRY_CAKE.get(), (new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> PANCAKE_STACK = registerItem("pancake_stack", () -> (new BlockItem(BlockRegistry.PANCAKE_STACK.get(), (new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> BROWNIE_TRAY = registerItem("brownie_tray", () -> (new BlockItem(BlockRegistry.BROWNIE_TRAY.get(), (new Item.Properties()).stacksTo(1))));

	private static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
		RegistryObject<Item> newItem = ITEMS.register(name, item);
		itemMap.put(name, newItem);

		return newItem;
	}

	public static Map<String, RegistryObject<Item>> getItemMap() {
		return itemMap;
	}
}
