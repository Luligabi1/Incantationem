package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.Nullable;

public abstract class IncantationemEnchantment extends Enchantment {

    public IncantationemEnchantment(String id, EnchantmentDefinition definition, boolean availableRandomly, boolean availableForBookOffer, boolean availableAsTreasure, @Nullable TagKey<EntityType<?>> targets) {
        super(definition);
        this.id = id;
        this.availableRandomly = availableRandomly;
        this.availableForBookOffer = availableForBookOffer;
        this.availableAsTreasure = availableAsTreasure;
        this.targets = targets;
        this.incompatibleTag = TagKey.create(
            Registries.ENCHANTMENT,
            Incantationem.modId(id + "_incompatible")
        );
    }

    public IncantationemEnchantment(String id, EnchantmentDefinition definition, boolean availableRandomly, boolean availableForBookOffer, boolean availableAsTreasure) {
        this(id, definition, availableRandomly, availableForBookOffer, availableAsTreasure, null);
    }


    public final String id;
    private final boolean availableForBookOffer;
    private final boolean availableRandomly;
    private final boolean availableAsTreasure;
    @Nullable private final TagKey<EntityType<?>> targets;
    public final TagKey<Enchantment> incompatibleTag;


    // keeping yarn-like field names for clarity, common mojmap L
    @Override
    public boolean isDiscoverable() {
        return availableRandomly;
    }

    @Override
    public boolean isTradeable() {
        return availableForBookOffer;
    }

    @Override
    public boolean isTreasureOnly() {
        return availableAsTreasure;
    }

    @Override
    protected boolean checkCompatibility(Enchantment other) {
        return super.checkCompatibility(other) && !Util.isEnchantmentInTag(other, incompatibleTag);
    }


    public float getDamageBonus(int i, @Nullable EntityType<?> entityType) {
        if(targets == null || entityType == null) return 0F;
        return entityType.is(targets) ? (float) i * 2.5F : 0F;
    }

    public void doPostAttack(LivingEntity user, Entity entity, int i) {
        if(targets != null && entity instanceof LivingEntity target) {
            if(i > 0 && target.getType().is(targets)) {
                int duration = 20 + user.getRandom().nextInt(10 * i);
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, 3));
            }
        }
    }
}