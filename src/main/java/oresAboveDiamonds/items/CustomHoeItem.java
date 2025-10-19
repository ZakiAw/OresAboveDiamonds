package oresAboveDiamonds.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import oresAboveDiamonds.lists.ToolMaterialList;

public class CustomHoeItem extends HoeItem {

    public CustomHoeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity enemy, LivingEntity damager) {
        Tier tier = this.getTier();
        if (tier instanceof ToolMaterialList modTier && modTier.isInfinite()) {
            stack.setDamageValue(0);
            return true;
        }
        return super.hurtEnemy(stack, enemy, damager);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        Tier tier = this.getTier();
        if (tier instanceof ToolMaterialList modTier && modTier.isInfinite()) {
            if (!world.isClientSide && state.getDestroySpeed(world, pos) != 0.0D) {
                stack.setDamageValue(0);
                return true;
            }
        }
        return super.mineBlock(stack, world, state, pos, entityLiving);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
        Tier tier = this.getTier();
        if (tier instanceof ToolMaterialList modTier && modTier.isInfinite()) {
            stack.getOrCreateTag().putBoolean("Unbreakable", true);
            return;
        }
        super.onCraftedBy(stack, world, player);
    }

}
