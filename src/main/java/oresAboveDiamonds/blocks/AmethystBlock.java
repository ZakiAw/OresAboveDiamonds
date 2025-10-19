package oresAboveDiamonds.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class AmethystBlock extends Block {
    public AmethystBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                .strength(4.0F, 6.0F)
                .sound(SoundType.AMETHYST)
                .requiresCorrectToolForDrops());
    }
}
