package me.luligabi.incantationem.common.common.network;

import dev.architectury.networking.NetworkManager;
import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;

public class NetworkRegistry {

    public static void init() {
        if(Platform.getEnvironment() != Env.CLIENT) {
            NetworkManager.registerS2CPayloadType(EffectAppliedPacket.TYPE, EffectAppliedPacket.CODEC);
        } else {
            NetworkManager.registerReceiver(NetworkManager.s2c(), EffectAppliedPacket.TYPE, EffectAppliedPacket.CODEC, EffectAppliedPacket::onReceive);
        }
    }

    private NetworkRegistry() {
        // NO-OP
    }
}