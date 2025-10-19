package oresAboveDiamonds.blocks;

import net.minecraft.block.BlockBehaviour;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlackOpalOre extends ExperienceDroppingBlock {
    public BlackOpalOre() {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
              .strength(4.0f, 4.0f)
              .sound(BlockSoundGroup.STONE)
              .requiresCorrectToolForDrops(), 5); // XP drop 0-5
    }
}
