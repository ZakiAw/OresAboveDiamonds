package oresAboveDiamonds.blocks;

import net.minecraft.world.level.block.ExperienceDroppingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.util.random.SimpleWeightedRandomList;

public class AmethystOre extends ExperienceDroppingBlock {
    public AmethystOre() {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE)
                .strength(3.0F, 3.0F)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops(),
              SimpleWeightedRandomList.<Integer>builder().add(1, 15).add(2, 5).build());
    }
}
