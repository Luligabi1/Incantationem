package me.luligabi.incantationem.common.common.network;

import dev.architectury.networking.NetworkManager;
import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public class EffectAppliedPacket implements CustomPacketPayload {


    public static final Type<EffectAppliedPacket> TYPE = new Type<>(Incantationem.modId("effect_applied"));
    public static final StreamCodec<RegistryFriendlyByteBuf, EffectAppliedPacket> CODEC = CustomPacketPayload.codec(EffectAppliedPacket::write, EffectAppliedPacket::new);

    public final EffectAppliedMessage message;


    public EffectAppliedPacket(EffectAppliedMessage message) {
        this.message = message;
    }

    public EffectAppliedPacket(RegistryFriendlyByteBuf buffer) {
        this.message = buffer.readEnum(EffectAppliedMessage.class);
    }

    public void write(RegistryFriendlyByteBuf buffer) {
        buffer.writeEnum(message);
    }

    public static void onReceive(EffectAppliedPacket packet, NetworkManager.PacketContext ctx) {
        ctx.queue(() -> {
            if(!packet.message.canShow) return;
            ctx.getPlayer().displayClientMessage(packet.message.component, true);
        });
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}