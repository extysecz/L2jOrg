package org.l2j.gameserver.network.serverpackets.ensoul;

import io.github.joealisson.mmocore.StaticPacket;
import org.l2j.gameserver.network.GameClient;
import org.l2j.gameserver.network.ServerExPacketId;
import org.l2j.gameserver.network.serverpackets.ServerPacket;

/**
 * @author Mobius
 */
@StaticPacket
public class ExShowEnsoulExtractionWindow extends ServerPacket {
    public static final ExShowEnsoulExtractionWindow STATIC_PACKET = new ExShowEnsoulExtractionWindow();

    private ExShowEnsoulExtractionWindow() {
    }

    @Override
    public void writeImpl(GameClient client) {
        writeId(ServerExPacketId.EX_SHOW_ENSOUL_EXTRACTION_WINDOW);
    }

}