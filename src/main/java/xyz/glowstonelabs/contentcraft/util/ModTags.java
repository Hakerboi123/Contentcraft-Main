package xyz.glowstonelabs.contentcraft.util;


import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_XAENON_TOOL = createTag("needs_xaenon_tool");
        public static final TagKey<Block> INCORRECT_FOR_XAENON_TOOL = createTag("incorrect_for_xaenon_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ContentCraft.MOD_ID, name));
        }
    }
}