package xyz.glowstonelabs.contentcraft.block.LavaSponge;


import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;


public class InfusedLavaSponge extends Block {
    public static final MapCodec<MagmaBlock> CODEC = createCodec(MagmaBlock::new);
    private static final int SCHEDULED_TICK_DELAY = 20;

    @Override
    public MapCodec<MagmaBlock> getCodec() {
        return CODEC;
    }

    public InfusedLavaSponge(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!entity.bypassesSteppingEffects() && entity instanceof LivingEntity) {
            if (!entity.isFireImmune()) {
                entity.damage(world.getDamageSources().inFire(), 1.0F);
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }


    @Override
    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.scheduleBlockTick(pos, this, 20);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        this.update(world, pos);
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    protected void update(World world, BlockPos pos) {
        if (this.absorbWater(world, pos)) {
            world.setBlockState(pos, ModBlocks.LAVA_SPONGE.getDefaultState(), Block.NOTIFY_LISTENERS);
            world.playSound(null, pos, SoundEvents.BLOCK_WET_SPONGE_DRIES, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        // Check if the neighbor block is water in any direction
        if ((direction == Direction.UP && neighborState.isOf(Blocks.WATER))) {
            world.scheduleBlockTick(pos, this, SCHEDULED_TICK_DELAY);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack itemInHand = player.getMainHandStack();
        if (itemInHand.getItem() == Items.BUCKET) {
            world.setBlockState(pos, ModBlocks.LAVA_SPONGE.getDefaultState());
            if (!player.getInventory().insertStack(new ItemStack(Items.LAVA_BUCKET))) {
                player.giveItemStack(new ItemStack(Items.LAVA_BUCKET));
            }
            itemInHand.decrement(1);
            world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, SoundCategory.BLOCKS, 1.0f, 1.0f);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

        private boolean absorbWater(World world, BlockPos pos) {
            return BlockPos.iterateRecursively(pos, 6, 65, (currentPos, queuer) -> {
                for (Direction direction : DIRECTIONS) {
                    queuer.accept(currentPos.offset(direction));
                }
            }, currentPos -> {
                if (currentPos.equals(pos)) {
                    return true;
                } else {
                    BlockState blockState = world.getBlockState(currentPos);
                    FluidState fluidState = world.getFluidState(currentPos);
                    if (!fluidState.isIn(FluidTags.WATER)) {
                        return false;
                    } else {
                        if (blockState.getBlock() instanceof FluidDrainable fluidDrainable && !fluidDrainable.tryDrainFluid(null, world, currentPos, blockState).isEmpty()) {
                            return true;
                        }

                        if (blockState.getBlock() instanceof FluidBlock) {
                            world.setBlockState(currentPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
                        } else {
                            if (!blockState.isOf(Blocks.KELP) && !blockState.isOf(Blocks.KELP_PLANT) && !blockState.isOf(Blocks.SEAGRASS) && !blockState.isOf(Blocks.TALL_SEAGRASS)) {
                                return false;
                            }

                            BlockEntity blockEntity = blockState.hasBlockEntity() ? world.getBlockEntity(currentPos) : null;
                            dropStacks(blockState, world, currentPos, blockEntity);
                            world.setBlockState(currentPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
                        }

                        return true;
                    }
                }
            }) > 1;
        }
    }
