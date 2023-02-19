/*

 Author: Yannis STEFANELLI

 Creation Date: 08-02-2023 08:57:32

 Description :

*/
package ena.testmod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ena.testmod.items.ExampleItem;
import ena.testmod.items.LightsaberItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Mod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	// public static final Item TOTO = new Item(new FabricItemSettings());
	public static final LightsaberItem LIGHTSABER_ITEM = new LightsaberItem(new FabricItemSettings().maxCount(1));
	public static final ExampleItem BLASTER_ITEM = new ExampleItem(new FabricItemSettings().maxCount(1));
	public static final ExampleItem EXAMPLE_ITEM = new ExampleItem(new FabricItemSettings());

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		Registry.register(Registries.ITEM, new Identifier("mod", "lightsaber"), LIGHTSABER_ITEM);
		Registry.register(Registries.ITEM, new Identifier("mod", "blaster"), BLASTER_ITEM);
		Registry.register(Registries.ITEM, new Identifier("mod", "example_item"), EXAMPLE_ITEM);
		CompostingChanceRegistry.INSTANCE.add(EXAMPLE_ITEM, 1.0F);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
			content.addAfter(Items.WARPED_FUNGUS, EXAMPLE_ITEM);
		});
	}
}
