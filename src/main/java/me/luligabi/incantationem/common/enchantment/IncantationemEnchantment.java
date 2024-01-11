package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Incantationem;
import me.luligabi.incantationem.common.Util;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public abstract class IncantationemEnchantment extends Enchantment {

    public IncantationemEnchantment(String id, Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes, int maxLevel, boolean availableForBookOffer, boolean availableRandomly, boolean availableAsTreasure) {
        super(weight, type, slotTypes);
        this.id = id;
        this.maxLevel = maxLevel;
        this.availableForBookOffer = availableForBookOffer;
        this.availableRandomly = availableRandomly;
        this.availableAsTreasure = availableAsTreasure;

        this.incompatibleTag = TagKey.of(
            RegistryKeys.ENCHANTMENT,
            Incantationem.modId(id + "_incompatible")
        );
    }

    public IncantationemEnchantment(String id, Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes, boolean availableForBookOffer, boolean availableRandomly, boolean availableAsTreasure) {
        this(id,weight, type, slotTypes, 1, availableForBookOffer, availableRandomly, availableAsTreasure);
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

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return availableForBookOffer;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return availableRandomly;
    }

    @Override
    public boolean isTreasure() {
        return availableAsTreasure;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !Util.isEnchantmentInTag(other, incompatibleTag);
    }
}