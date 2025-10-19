package oresAboveDiamonds.init;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.blocks.AmethystBlock;
import oresAboveDiamonds.blocks.AmethystOre;
import oresAboveDiamonds.blocks.BlackOpalBlock;
import oresAboveDiamonds.blocks.BlackOpalOre;

public class ModBlocks {

    public static final Block AMETHYST_ORE = new AmethystOre(BlockSoundGroup.STONE, 3.0f);
    public static final Block BLACK_OPAL_ORE = new BlackOpalOre(BlockSoundGroup.STONE, 3.0f);

    public static final Block AMETHYST_BLOCK = new AmethystBlock();
    public static final Block BLACK_OPAL_BLOCK = new BlackOpalBlock();

    public static final Block DEEPSLATE_AMETHYST_ORE = new AmethystOre(BlockSoundGroup.DEEPSLATE, 4.5f);
    public static final Block NETHER_AMETHYST_ORE = new AmethystOre(BlockSoundGroup.NETHER_ORE, 3.0f);
    public static final Block END_AMETHYST_ORE = new AmethystOre(BlockSoundGroup.STONE, 3.0f);

    public static final Block DEEPSLATE_BLACK_OPAL_ORE = new BlackOpalOre(BlockSoundGroup.DEEPSLATE, 4.5f);
    public static final Block NETHER_BLACK_OPAL_ORE = new BlackOpalOre(BlockSoundGroup.NETHER_ORE, 3.0f);
    public static final Block END_BLACK_OPAL_ORE = new BlackOpalOre(BlockSoundGroup.STONE, 3.0f);

    public static void registerBlocks() {
        register("amethyst_ore", AMETHYST_ORE);
        register("black_opal_ore", BLACK_OPAL_ORE);
        register("amethyst_block", AMETHYST_BLOCK);
        register("black_opal_block", BLACK_OPAL_BLOCK);
        register("deepslate_amethyst_ore", DEEPSLATE_AMETHYST_ORE);
        register("nether_amethyst_ore", NETHER_AMETHYST_ORE);
        register("end_amethyst_ore", END_AMETHYST_ORE);
        register("deepslate_black_opal_ore", DEEPSLATE_BLACK_OPAL_ORE);
        register("nether_black_opal_ore", NETHER_BLACK_OPAL_ORE);
        register("end_black_opal_ore", END_BLACK_OPAL_ORE);
    }

    private static void register(String name, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(OresAboveDiamonds.MODID, name), block);
    }
}
