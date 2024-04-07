package me.luligabi.incantationem.common.common.packet;

import dev.architectury.networking.NetworkManager;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;

public class EffectAppliedPacket {

    public final EffectAppliedMessage message;

    public EffectAppliedPacket(FriendlyByteBuf buf) {
        this(buf.readEnum(EffectAppliedMessage.class));
    }

    public EffectAppliedPacket(EffectAppliedMessage message) {
        this.message = message;
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeEnum(message);
    }

    public void apply(Supplier<NetworkManager.PacketContext> ctx) {
        if(!message.canShow) return;
        ctx.get().getPlayer().displayClientMessage(message.component, true);
    }
}
