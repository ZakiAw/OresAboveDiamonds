package oresAboveDiamonds.lists;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import oresAboveDiamonds.init.ModItems;

import java.util.function.Supplier;

public enum ToolMaterialList implements ToolMaterial {
    AMETHYST(500, 7.0F, 3.0F, 2, 12, () -> Ingredient.ofItems(ModItems.AMETHYST)),
    BLACK_OPAL(750, 8.0F, 3.5F, 3, 15, () -> Ingredient.ofItems(ModItems.BLACK_OPAL)),
    NETHERITE_OPAL(2031, 9.0F, 4.0F, 4, 22, () -> Ingredient.ofItems(ModItems.BLACK_OPAL)); // replace with netherite opal item

    private final int durability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int miningLevel;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ToolMaterialList(int durability, float miningSpeed, float attackDamage, int miningLevel, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.miningLevel = miningLevel;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() { return durability; }

    @Override
    public float getMiningSpeedMultiplier() { return miningSpeed; }

    @Override
    public float getAttackDamage() { return attackDamage; }

    @Override
    public int getMiningLevel() { return miningLevel; }

    @Override
    public int getEnchantability() { return enchantability; }

    @Override
    public Ingredient getRepairIngredient() { return repairIngredient.get(); }
}
