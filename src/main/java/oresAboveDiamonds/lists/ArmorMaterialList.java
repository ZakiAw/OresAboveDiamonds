package oresAboveDiamonds.lists;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.init.ModItems;

public enum ArmorMaterialList implements ArmorMaterial {

    AMETHYST(
            "amethyst",
            OADConfig.amethyst_armor_durability.get(),
            new int[]{
                    OADConfig.amethyst_boots_armor.get(),
                    OADConfig.amethyst_leggings_armor.get(),
                    OADConfig.amethyst_chestplate_armor.get(),
                    OADConfig.amethyst_helmet_armor.get()
            },
            OADConfig.amethyst_enchantability.get(),
            ModItems.AMETHYST,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            OADConfig.amethyst_armor_toughness.get(),
            ((float) OADConfig.amethyst_armor_knockback_resistance.get()) / 10
    ),

    BLACK_OPAL(
            "black_opal",
            OADConfig.black_opal_armor_durability.get(),
            new int[]{
                    OADConfig.black_opal_boots_armor.get(),
                    OADConfig.black_opal_leggings_armor.get(),
                    OADConfig.black_opal_chestplate_armor.get(),
                    OADConfig.black_opal_helmet_armor.get()
            },
            OADConfig.black_opal_enchantability.get(),
            ModItems.BLACK_OPAL,
            SoundEvents.ENDER_DRAGON_FLAP,
            OADConfig.black_opal_armor_toughness.get(),
            ((float) OADConfig.black_opal_armor_knockback_resistance.get()) / 10
    ),

    NETHERITE_OPAL(
            "netherite_opal",
            OADConfig.netherite_opal_armor_durability.get(),
            new int[]{
                    OADConfig.netherite_opal_boots_armor.get(),
                    OADConfig.netherite_opal_leggings_armor.get(),
                    OADConfig.netherite_opal_chestplate_armor.get(),
                    OADConfig.netherite_opal_helmet_armor.get()
            },
            OADConfig.netherite_opal_enchantability.get(),
            ModItems.BLACK_OPAL,
            SoundEvents.ENDER_DRAGON_FLAP,
            OADConfig.netherite_opal_armor_toughness.get(),
            ((float) OADConfig.netherite_opal_armor_knockback_resistance.get()) / 10
    );

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};

    private final String name;
    private final SoundEvent equipSound;
    private final int durability, enchantability;
    private final Item repairItem;
    private final int[] damageReductionAmounts;
    private final float toughness;
    private final float knockbackResistance;
    private final boolean infiniteDurability;

    ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem,
                      SoundEvent equipSound, float toughness, float knockbackResistance) {
        this.name = name;
        this.equipSound = equipSound;
        if (durability <= 0) {
            this.durability = Integer.MAX_VALUE;
            this.infiniteDurability = true;
        } else {
            this.durability = durability;
            this.infiniteDurability = false;
        }
        this.repairItem = repairItem;
        this.enchantability = enchantability;
        this.damageReductionAmounts = damageReductionAmounts;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return MAX_DAMAGE_ARRAY[type.getSlot().getIndex()] * this.durability;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.damageReductionAmounts[type.getSlot().getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(this.repairItem);
    }

    @Override
    public String getName() {
        return "oresabovediamonds:" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public boolean isInfinite() {
        return this.infiniteDurability;
    }
}
