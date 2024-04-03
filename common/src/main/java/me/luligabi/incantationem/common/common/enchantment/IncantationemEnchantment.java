package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public abstract class IncantationemEnchantment extends Enchantment {

    public IncantationemEnchantment(String id, Rarity rarity, EnchantmentCategory category, EquipmentSlot[] equipmentSlots, int maxLevel, boolean availableForBookOffer, boolean availableRandomly, boolean availableAsTreasure) {
        super(rarity, category, equipmentSlots);
        this.id = id;
        this.maxLevel = maxLevel;
        this.availableForBookOffer = availableForBookOffer;
        this.availableRandomly = availableRandomly;
        this.availableAsTreasure = availableAsTreasure;

        this.incompatibleTag = TagKey.create(
            Registries.ENCHANTMENT,
            Incantationem.modId(id + "_incompatible")
        );
    }

    public IncantationemEnchantment(String id, Rarity weight, EnchantmentCategory category, EquipmentSlot[] equipmentSlots, boolean availableForBookOffer, boolean availableRandomly, boolean availableAsTreasure) {
        this(id,weight, category, equipmentSlots, 1, availableForBookOffer, availableRandomly, availableAsTreasure);
    }


    public final String id;
    private final int maxLevel;
    private final boolean availableForBookOffer;
    private final boolean availableRandomly;
    private final boolean availableAsTreasure;

    public final TagKey<Enchantment> incompatibleTag;

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

    // keeping yarn-like field names for clarity, common mojmap L
    @Override
    public boolean isTradeable() {
        return availableForBookOffer;
    }

    @Override
    public boolean isDiscoverable() {
        return availableRandomly;
    }

    @Override
    public boolean isTreasureOnly() {
        return availableAsTreasure;
    }

    @Override
    protected boolean checkCompatibility(Enchantment other) {
        return super.checkCompatibility(other) && !Util.isEnchantmentInTag(other, incompatibleTag);
    }
}