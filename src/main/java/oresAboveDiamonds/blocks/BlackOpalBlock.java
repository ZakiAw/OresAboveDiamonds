package oresAboveDiamonds.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBehaviour;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlackOpalBlock extends Block {
    public BlackOpalBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
              .strength(5.0f, 6.0f)
              .sound(BlockSoundGroup.AMETHYST)
              .requiresCorrectToolForDrops());
    }
}
