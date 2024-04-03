package me.luligabi.incantationem.common.common.enchantment.curse;

import dev.architectury.registry.registries.RegistrySupplier;
import me.luligabi.incantationem.common.common.Incantationem;

@SuppressWarnings("unused")
public class CurseRegistry {


    public static final RegistrySupplier<RecklessnessCurse> RECKLESSNESS = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("recklessness"),
        RecklessnessCurse::new
    );
    public static final RegistrySupplier<ShriekingCurse> SHRIEKING = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("shrieking"),
        ShriekingCurse::new
    );
    public static final RegistrySupplier<ThunderCurse> THUNDER = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("thunder"),
        ThunderCurse::new
    );
    public static final RegistrySupplier<ToughLuckCurse> TOUGH_LUCK = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("tough_luck"),
        ToughLuckCurse::new
    );


    public static void init() {
        // NO-OP
    }

    private CurseRegistry() {
        // NO-OP
    }
}
