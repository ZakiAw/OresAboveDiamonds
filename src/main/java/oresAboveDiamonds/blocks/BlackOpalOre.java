package oresAboveDiamonds.blocks;

import net.minecraft.world.level.block.ExperienceDroppingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.util.random.SimpleWeightedRandomList;

public class BlackOpalOre extends ExperienceDroppingBlock {
    public BlackOpalOre() {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                .strength(4.0F, 4.0F)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops(),
              SimpleWeightedRandomList.<Integer>builder().add(2, 10).add(3, 5).build());
    }
}
