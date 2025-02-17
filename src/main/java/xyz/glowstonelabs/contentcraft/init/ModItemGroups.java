package xyz.glowstonelabs.contentcraft.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup CONTENTCRAFT_FUNCTIONAL = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentCraft.MOD_ID, "contentcraft_functional"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.XAENON_INGOT))
                    .displayName(Text.translatable("itemgroup.contentcraft.contentcraft_functional"))
                    .entries((displayContext, entries) -> {

                        //Xaenon
                        entries.add(ModItems.XAENON_INGOT);
                        entries.add(ModItems.RAW_XAENON);
                        entries.add(ModBlocks.XAENON_BLOCK);
                        entries.add(ModBlocks.RAW_XAENON_BLOCK);
                        entries.add(ModBlocks.XAENON_ORE);

                          //Xaenon items & stuff
                            entries.add(ModItems.XAENON_CHISEL);
                            entries.add(ModItems.XAENON_SWORD);
                            entries.add(ModItems.XAENON_PICKAXE);
                            entries.add(ModItems.XAENON_SHOVEL);
                            entries.add(ModItems.XAENON_AXE);
                            entries.add(ModItems.XAENON_HOE);

                            entries.add(ModItems.XAENON_HELMET);
                            entries.add(ModItems.XAENON_CHESTPLATE);
                            entries.add(ModItems.XAENON_LEGGINGS);
                            entries.add(ModItems.XAENON_BOOTS);

                        //Bismuth
                        entries.add(ModItems.BISMUTH);
                        entries.add(ModItems.RAW_BISMUTH);
                        entries.add(ModBlocks.BISMUTH_BLOCK);
                        entries.add(ModBlocks.BISMUTH_ORE);

                        //Ruby
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);

                        //Sapphire
                        entries.add(ModItems.SAPPHIRE);
                        entries.add(ModItems.RAW_SAPPHIRE);
                        entries.add(ModBlocks.SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.RAW_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.SAPPHIRE_ORE);

                        //Black Opal
                        entries.add(ModItems.BLACK_OPAL);
                        entries.add(ModItems.RAW_BLACK_OPAL);
                        entries.add(ModBlocks.BLACK_OPAL_BLOCK);
                        entries.add(ModBlocks.BLACK_OPAL_ORE);

                        //MISC ITEMS
                        entries.add(ModItems.GOLD_COIN);
                        entries.add(ModItems.COPPER_COIN);
                        entries.add(ModItems.IRON_COIN);
                        entries.add(ModItems.COPPER_NUGGET);

                        //Maple WoodType
                        entries.add(ModBlocks.MAPLE_LOG);
                        entries.add(ModBlocks.MAPLE_WOOD);
                        entries.add(ModBlocks.STRIPPED_MAPLE_LOG);
                        entries.add(ModBlocks.STRIPPED_MAPLE_WOOD);
                        entries.add(ModBlocks.MAPLE_PLANKS);
                        entries.add(ModBlocks.MAPLE_STAIRS);
                        entries.add(ModBlocks.MAPLE_SLAB);
                        entries.add(ModBlocks.MAPLE_PRESSURE_PLATE);
                        entries.add(ModBlocks.MAPLE_BUTTON);
                        entries.add(ModBlocks.MAPLE_FENCE);
                        entries.add(ModBlocks.MAPLE_FENCE_GATE);
                        entries.add(ModBlocks.MAPLE_DOOR);
                        entries.add(ModBlocks.MAPLE_TRAPDOOR);
                        entries.add(ModBlocks.MAPLE_LEAVES);
                        entries.add(ModBlocks.MAPLE_SAPLING);

                        //Bricks
                        entries.add(ModBlocks.GRANITE_BRICKS);
                        entries.add(ModBlocks.ANDESITE_BRICKS);
                        entries.add(ModBlocks.DIORITE_BRICKS);

                        //Sponge
                        entries.add(ModBlocks.LAVA_SPONGE);
                        entries.add(ModBlocks.INFUSED_LAVA_SPONGE);

                    }).build());



    public static void registerItemGroups() {
        ContentCraft.LOGGER.info("Registering Item Groups for " + ContentCraft.MOD_ID);
    }
}