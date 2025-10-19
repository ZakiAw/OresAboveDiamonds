package oresAboveDiamonds.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import oresAboveDiamonds.lists.ToolMaterialList;

public class CustomPickaxeItem extends PickaxeItem {

    public CustomPickaxeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Tier tier = this.getTier();
        if (tier.equals(ToolMaterialList.AMETHYST) ||
            tier.equals(ToolMaterialList.BLACK_OPAL) ||
            tier.equals(ToolMaterialList.NETHERITE_OPAL)) {
            
            ToolMaterialList modTier = (ToolMaterialList) tier;
            if (modTier.isInfinite()) {
                stack.setDamageValue(0);
                return true;
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        Tier tier = this.getTier();
        if (tier.equals(ToolMaterialList.AMETHYST) ||
            tier.equals(ToolMaterialList.BLACK_OPAL) ||
            tier.equals(ToolMaterialList.NETHERITE_OPAL)) {
            
            ToolMaterialList modTier = (ToolMaterialList) tier;
            if (modTier.isInfinite() && !world.isClientSide && state.getDestroySpeed(world, pos) != 0.0F) {
                stack.setDamageValue(0);
                return true;
            }
        }
        return super.mineBlock(stack, world, state, pos, entityLiving);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
        Tier tier = this.getTier();
        if (tier.equals(ToolMaterialList.AMETHYST) ||
            tier.equals(ToolMaterialList.BLACK_OPAL) ||
            tier.equals(ToolMaterialList.NETHERITE_OPAL)) {
            
            ToolMaterialList modTier = (ToolMaterialList) tier;
            if (modTier.isInfinite()) {
                stack.getOrCreateTag().putBoolean("Unbreakable", true);
                return;
            }
        }
        super.onCraftedBy(stack, world, player);
    }
}
