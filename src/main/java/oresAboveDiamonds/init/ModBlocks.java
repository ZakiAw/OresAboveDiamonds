package oresAboveDiamonds.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.blocks.AmethystBlock;
import oresAboveDiamonds.blocks.AmethystOre;
import oresAboveDiamonds.blocks.BlackOpalBlock;
import oresAboveDiamonds.blocks.BlackOpalOre;

public class ModBlocks {

    public static final Block AMETHYST_BLOCK = registerBlock("amethyst_block",
            new AmethystBlock(Block.Settings.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                    .strength(1.5f, 6.0f)
                    .sounds(BlockSoundGroup.AMETHYST)));

    public static final Block AMETHYST_ORE = registerBlock("amethyst_ore",
            new AmethystOre(Block.Settings.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                    .strength(3.0f, 3.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block BLACK_OPAL_BLOCK = registerBlock("black_opal_block",
            new BlackOpalBlock(Block.Settings.of(Material.STONE, MaterialColor.COLOR_BLACK)
                    .strength(1.5f, 6.0f)
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block BLACK_OPAL_ORE = registerBlock("black_opal_ore",
            new BlackOpalOre(Block.Settings.of(Material.STONE, MaterialColor.COLOR_BLACK)
                    .strength(3.0f, 3.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(OresAboveDiamonds.MOD_ID, name), block);
        Registry.register(Registries.ITEM, new Identifier(OresAboveDiamonds.MOD_ID, name),
                new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        return block;
    }

    public static void registerAll() {}
}
