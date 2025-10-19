package oresAboveDiamonds.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBehaviour;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class AmethystBlock extends Block {
    public AmethystBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
              .strength(4.0f, 6.0f)
              .sound(BlockSoundGroup.AMETHYST)
              .requiresCorrectToolForDrops());
    }
}
