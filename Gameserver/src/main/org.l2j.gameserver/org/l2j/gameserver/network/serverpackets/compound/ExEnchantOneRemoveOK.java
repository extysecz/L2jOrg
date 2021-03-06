package org.l2j.gameserver.network.serverpackets.compound;

import io.github.joealisson.mmocore.StaticPacket;
import org.l2j.gameserver.network.GameClient;
import org.l2j.gameserver.network.ServerExPacketId;
import org.l2j.gameserver.network.serverpackets.ServerPacket;

/**
 * @author UnAfraid
 */
@StaticPacket
public class ExEnchantOneRemoveOK extends ServerPacket {
    public static final ExEnchantOneRemoveOK STATIC_PACKET = new ExEnchantOneRemoveOK();

    private ExEnchantOneRemoveOK() {
    }

    @Override
    public void writeImpl(GameClient client) {
        writeId(ServerExPacketId.EX_ENCHANT_ONE_REMOVE_OK);
    }

}
