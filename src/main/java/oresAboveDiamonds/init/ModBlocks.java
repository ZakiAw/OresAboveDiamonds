package oresAboveDiamonds.init;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import oresAboveDiamonds.OresAboveDiamonds;

public class ModBlocks {

    // Player-placed blocks
    public static final Block AMETHYST_BLOCK = new Block(Block.Settings.of(Material.METAL).strength(5f).sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block BLACK_OPAL_BLOCK = new Block(Block.Settings.of(Material.STONE).strength(6f).sounds(BlockSoundGroup.STONE));

    // World-generated ores
    public static final Block AMETHYST_ORE = new Block(Block.Settings.of(Material.STONE).strength(3f).sounds(BlockSoundGroup.STONE));
    public static final Block BLACK_OPAL_ORE = new Block(Block.Settings.of(Material.STONE).strength(6f).sounds(BlockSoundGroup.STONE));

    public static void registerBlocks() {
        registerBlock("amethyst_block", AMETHYST_BLOCK, ItemGroup.BUILDING_BLOCKS);
        registerBlock("black_opal_block", BLACK_OPAL_BLOCK, ItemGroup.BUILDING_BLOCKS);
        registerBlock("amethyst_ore", AMETHYST_ORE, ItemGroup.BUILDING_BLOCKS);
        registerBlock("black_opal_ore", BLACK_OPAL_ORE, ItemGroup.BUILDING_BLOCKS);
    }

    private static void registerBlock(String name, Block block, ItemGroup group) {
        Registry.register(Registries.BLOCK, OresAboveDiamonds.id(name), block);
        Registry.register(Registries.ITEM, OresAboveDiamonds.id(name), new BlockItem(block, new Item.Settings().group(group)));
    }
}
