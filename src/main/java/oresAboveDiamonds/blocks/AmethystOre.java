package oresAboveDiamonds.blocks;

import net.minecraft.block.BlockBehaviour;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class AmethystOre extends ExperienceDroppingBlock {
    public AmethystOre() {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
              .strength(3.0f, 3.0f)
              .sound(BlockSoundGroup.STONE)
              .requiresCorrectToolForDrops(), 3); // XP drop 0-3
    }
}
