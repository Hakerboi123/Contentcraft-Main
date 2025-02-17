package xyz.glowstonelabs.contentcraft;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.LoggerFactory;

import static xyz.glowstonelabs.contentcraft.init.ModBlocks.registerModBlocks;
import static xyz.glowstonelabs.contentcraft.init.ModItemGroups.registerItemGroups;
import static xyz.glowstonelabs.contentcraft.init.ModItems.registerModItems;

public class ContentCraft implements ModInitializer {
	public static final String MOD_ID = "contentcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("[CC] Contentcraft client initializing...");

		registerModItems();
		registerModBlocks();
		registerItemGroups();

		LOGGER.info("[CC] Contentcraft initialized!");
	}
}