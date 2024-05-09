package me.luligabi.incantationem.common.common.packet;

import dev.architectury.networking.NetworkChannel;
import me.luligabi.incantationem.common.common.Incantationem;

// FIXME
public class NetworkRegistry {

    public static final NetworkChannel NETWORK_CHANNEL = NetworkChannel.create(Incantationem.modId("network_channel"));

    public static void init() {
        NETWORK_CHANNEL.register(EffectAppliedPacket.class, EffectAppliedPacket::encode, EffectAppliedPacket::new, EffectAppliedPacket::apply);
    }

    private NetworkRegistry() {
        // NO-OP
    }
}
