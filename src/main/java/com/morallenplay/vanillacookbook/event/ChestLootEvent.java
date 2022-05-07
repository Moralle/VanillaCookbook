package com.morallenplay.vanillacookbook.event;

import com.morallenplay.vanillacookbook.VanillaCookbook;
import com.morallenplay.vanillacookbook.setup.Config;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = VanillaCookbook.MOD_ID, bus = Bus.FORGE)
public class ChestLootEvent {
	
	private static ResourceLocation bonus = new ResourceLocation("minecraft", "chests/spawn_bonus_chest");
	private static ResourceLocation end = new ResourceLocation("minecraft", "chests/end_city_treasure");
	private static ResourceLocation desert = new ResourceLocation("minecraft", "chests/village/village_desert_house");
	private static ResourceLocation plains = new ResourceLocation("minecraft", "chests/village/village_plains_house");
	private static ResourceLocation savanna = new ResourceLocation("minecraft", "chests/village/village_savanna_house");
	private static ResourceLocation snowy = new ResourceLocation("minecraft", "chests/village/village_snowy_house");
	private static ResourceLocation taiga = new ResourceLocation("minecraft", "chests/village/village_taiga_house");
	private static ResourceLocation mansion = new ResourceLocation("minecraft", "chests/woodland_mansion");
	private static ResourceLocation fortress = new ResourceLocation("minecraft", "chests/nether_fortress");
	private static ResourceLocation bastiono = new ResourceLocation("minecraft", "chests/bastion_other");
	private static ResourceLocation bastiont = new ResourceLocation("minecraft", "chests/bastion_treasure");
	private static ResourceLocation dungeon = new ResourceLocation("minecraft", "chests/simple_dungeon");
	private static ResourceLocation mineshaft = new ResourceLocation("minecraft", "chests/abandoned_mineshaft");
	
	@SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event) {
		if (Config.LOOT_GENERATION.get()) return;
		if (event.getName().equals(bonus)) {
            event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(VanillaCookbook.MOD_ID, "chests/bonus_chest")).setWeight(1).setQuality(0)).name("vc_bonus").build());
        }
        if (event.getName().equals(end)) {
            event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(VanillaCookbook.MOD_ID, "chests/end_city")).setWeight(1).setQuality(0)).name("vc_end").build());
        }
        if (event.getName().equals(desert)) {
            event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(VanillaCookbook.MOD_ID, "chests/village_desert")).setWeight(1).setQuality(0)).name("vc_desert").build());
        }
        if (event.getName().equals(plains)) {
            event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(VanillaCookbook.MOD_ID, "chests/village_plains")).setWeight(1).setQuality(0)).name("vc_plains").build());
        }
        if (event.getName().equals(savanna)) {
            event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(VanillaCookbook.MOD_ID, "chests/village_savanna")).setWeight(1).setQuality(0)).name("vc_savanna").build());
        }
        if (event.getName().equals(snowy)) {
            event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(VanillaCookbook.MOD_ID, "chests/village_snowy")).setWeight(1).setQuality(0)).name("vc_snowy").build());
        }
        if (event.getName().equals(taiga)) {
            event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(VanillaCookbook.MOD_ID, "chests/village_taiga")).setWeight(1).setQuality(0)).name("vc_taiga").build());
        }
        if (event.getName().equals(mansion)) {
            event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(VanillaCookbook.MOD_ID, "chests/woodland_mansion")).setWeight(1).setQuality(0)).name("vc_mansion").build());
        }
        if (event.getName().equals(fortress)||event.getName().equals(bastiono)) {
            event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(VanillaCookbook.MOD_ID, "chests/nether")).setWeight(1).setQuality(0)).name("vc_nether").build());
        }
        if (event.getName().equals(bastiont)) {
            event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(VanillaCookbook.MOD_ID, "chests/bastion_treasure")).setWeight(1).setQuality(0)).name("vc_bastion").build());
        }
        if (event.getName().equals(dungeon)) {
            event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(VanillaCookbook.MOD_ID, "chests/simple_dungeon")).setWeight(1).setQuality(0)).name("vc_dungeon").build());
        }
        if (event.getName().equals(mineshaft)) {
            event.getTable().addPool(LootPool.lootPool().add(LootTableReference.lootTableReference(new ResourceLocation(VanillaCookbook.MOD_ID, "chests/abandoned_mineshaft")).setWeight(1).setQuality(0)).name("vc_mineshaft").build());
        }
	}
}
