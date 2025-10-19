package oresAboveDiamonds.items;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import oresAboveDiamonds.lists.ArmorMaterialList;

public class CustomArmorItem extends ArmorItem {

    public CustomArmorItem(ArmorMaterial material, Type slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        ArmorMaterial material = this.getMaterial();
        if (material.equals(ArmorMaterialList.AMETHYST) ||
            material.equals(ArmorMaterialList.BLACK_OPAL) ||
            material.equals(ArmorMaterialList.NETHERITE_OPAL)) {
            
            ArmorMaterialList modMaterial = (ArmorMaterialList) material;
            if (modMaterial.isInfinite()) {
                setDamage(player.getItemBySlot(EquipmentSlot.HEAD), 0);
                setDamage(player.getItemBySlot(EquipmentSlot.CHEST), 0);
                setDamage(player.getItemBySlot(EquipmentSlot.LEGS), 0);
                setDamage(player.getItemBySlot(EquipmentSlot.FEET), 0);
                return;
            }
        }
        super.onArmorTick(stack, world, player);
    }

    private void setDamage(ItemStack stack, int damage) {
        if (!stack.isEmpty()) {
            stack.setDamageValue(damage);
        }
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
        ArmorMaterial material = this.getMaterial();
        if (material.equals(ArmorMaterialList.AMETHYST) ||
            material.equals(ArmorMaterialList.BLACK_OPAL) ||
            material.equals(ArmorMaterialList.NETHERITE_OPAL)) {

            ArmorMaterialList modMaterial = (ArmorMaterialList) material;
            if (modMaterial.isInfinite()) {
                stack.getOrCreateTag().putBoolean("Unbreakable", true);
                return;
            }
        }
        super.onCraftedBy(stack, world, player);
    }
}
