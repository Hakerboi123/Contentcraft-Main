package xyz.glowstonelabs.contentcraft.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;
import xyz.glowstonelabs.contentcraft.item.Chsel.XaenonChiselItem;

public class ModItems {

    //xaenon
    public static final Item XAENON_INGOT = registerItem("xaenon_ingot", new Item(new Item.Settings()));
    public static final Item RAW_XAENON = registerItem("raw_xaenon", new Item(new Item.Settings()));

    public static final Item XAENON_CHISEL = registerItem("xaenon_chisel", new XaenonChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item XAENON_HELMET = registerItem("xaenon_helmet",
            new ArmorItem(ModArmorMaterials.XAENON, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item XAENON_CHESTPLATE = registerItem("xaenon_chestplate",
            new ArmorItem(ModArmorMaterials.XAENON, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item XAENON_LEGGINGS = registerItem("xaenon_leggings",
            new ArmorItem(ModArmorMaterials.XAENON, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item XAENON_BOOTS = registerItem("xaenon_boots",
            new ArmorItem(ModArmorMaterials.XAENON, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item XAENON_SWORD = registerItem("xaenon_sword",
            new SwordItem(ModToolMaterials.XAENON_INGOT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.XAENON_INGOT, 3, -2.4f))));
    public static final Item XAENON_PICKAXE = registerItem("xaenon_pickaxe",
            new PickaxeItem(ModToolMaterials.XAENON_INGOT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.XAENON_INGOT, 1, -2.8f))));
    public static final Item XAENON_SHOVEL = registerItem("xaenon_shovel",
            new ShovelItem(ModToolMaterials.XAENON_INGOT, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.XAENON_INGOT, 1.5f, -3.0f))));
    public static final Item XAENON_AXE = registerItem("xaenon_axe",
            new AxeItem(ModToolMaterials.XAENON_INGOT, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.XAENON_INGOT, 6, -3.2f))));
    public static final Item XAENON_HOE = registerItem("xaenon_hoe",
            new HoeItem(ModToolMaterials.XAENON_INGOT, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.XAENON_INGOT, 0, -3f))));


    //bismuth
    public static final Item BISMUTH = registerItem("bismuth", new Item(new Item.Settings()));
    public static final Item RAW_BISMUTH = registerItem("raw_bismuth", new Item(new Item.Settings()));

    //sapphire
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings()));
    public static final Item RAW_SAPPHIRE = registerItem("raw_sapphire", new Item(new Item.Settings()));

    //ruby
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings()));

    public static final Item BLACK_OPAL = registerItem("black_opal", new Item(new Item.Settings()));
    public static final Item RAW_BLACK_OPAL = registerItem("raw_black_opal", new Item(new Item.Settings()));

    //coins

    public static final Item COPPER_COIN = registerItem("copper_coin", new Item(new Item.Settings()) {
//        @Override
//        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
//            if (Screen.hasShiftDown()) {
//                tooltip.add(Text.translatable("tooltip.contentcraft.copper_coin.shift_down"));
//                tooltip.add(Text.translatable("tooltip.contentcraft.copper_coin.shift_down.line2"));
//                tooltip.add(Text.translatable("tooltip.contentcraft.copper_coin.shift_down.line3"));
//            } else {
//                tooltip.add(Text.translatable("tooltip.contentcraft.copper_coin"));
//            }
//            super.appendTooltip(stack, context, tooltip, type);
//        }
    });

    public static final Item IRON_COIN = registerItem("iron_coin", new Item(new Item.Settings()) {
//        @Override
//        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
//            if (Screen.hasShiftDown()) {
//                tooltip.add(Text.translatable("tooltip.contentcraft.iron_coin.shift_down"));
//                tooltip.add(Text.translatable("tooltip.contentcraft.iron_coin.shift_down.line2"));
//                tooltip.add(Text.translatable("tooltip.contentcraft.iron_coin.shift_down.line3"));
//            } else {
//                tooltip.add(Text.translatable("tooltip.contentcraft.iron_coin"));
//            }
//            super.appendTooltip(stack, context, tooltip, type);
//        }
    });

    public static final Item GOLD_COIN = registerItem("gold_coin", new Item(new Item.Settings()) {
//        @Override
//        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
//            if (Screen.hasShiftDown()) {
//                tooltip.add(Text.translatable("tooltip.contentcraft.gold_coin.shift_down"));
//                tooltip.add(Text.translatable("tooltip.contentcraft.gold_coin.shift_down.line2"));
//                tooltip.add(Text.translatable("tooltip.contentcraft.gold_coin.shift_down.line3"));
//            } else {
//                tooltip.add(Text.translatable("tooltip.contentcraft.gold_coin"));
//            }
//            super.appendTooltip(stack, context, tooltip, type);
//        }
    });

    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ContentCraft.MOD_ID, name), item);
    };

    public static void registerModItems() {
        ContentCraft.LOGGER.info("Registering Mod Items for " + ContentCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH).register(entries -> {

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

        });
    }
}
