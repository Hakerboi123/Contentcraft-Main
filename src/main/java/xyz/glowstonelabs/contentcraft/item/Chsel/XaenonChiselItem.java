package xyz.glowstonelabs.contentcraft.item.Chsel;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class XaenonChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP = new HashMap<>();

    static {
        CHISEL_MAP.put(Blocks.END_STONE, Blocks.END_STONE_BRICKS);
        CHISEL_MAP.put(Blocks.END_STONE_BRICKS, Blocks.END_STONE_BRICK_SLAB);
        CHISEL_MAP.put(Blocks.END_STONE_BRICK_SLAB, Blocks.END_STONE_BRICK_STAIRS);
        CHISEL_MAP.put(Blocks.END_STONE_BRICK_STAIRS, Blocks.END_STONE_BRICK_WALL);
        CHISEL_MAP.put(Blocks.END_STONE_BRICK_WALL, Blocks.END_STONE);

        CHISEL_MAP.put(Blocks.PURPUR_BLOCK, Blocks.PURPUR_PILLAR);
        CHISEL_MAP.put(Blocks.PURPUR_PILLAR, Blocks.PURPUR_SLAB);
        CHISEL_MAP.put(Blocks.PURPUR_SLAB, Blocks.PURPUR_STAIRS);
        CHISEL_MAP.put(Blocks.PURPUR_STAIRS, Blocks.PURPUR_BLOCK);

        // Add new items to the map here, following the same format:
        // CHISEL_MAP.put(BlockToChisel, ResultingBlock);
    }

    public XaenonChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}