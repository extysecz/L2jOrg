package org.l2j.gameserver.network.serverpackets;

import org.l2j.gameserver.model.actor.instance.Player;
import org.l2j.gameserver.network.GameClient;
import org.l2j.gameserver.network.ServerExPacketId;

/**
 * @author Sdw
 */
public class ExResponseBeautyRegistReset extends ServerPacket {
    public static final int FAILURE = 0;
    public static final int SUCCESS = 1;
    public static final int CHANGE = 0;
    public static final int RESTORE = 1;
    private final Player _activeChar;
    private final int _type;
    private final int _result;

    public ExResponseBeautyRegistReset(Player activeChar, int type, int result) {
        _activeChar = activeChar;
        _type = type;
        _result = result;
    }

    @Override
    public void writeImpl(GameClient client) {
        writeId(ServerExPacketId.EX_RESPONSE_BEAUTY_REGIST_RESET);

        writeLong(_activeChar.getAdena());
        writeLong(_activeChar.getBeautyTickets());
        writeInt(_type);
        writeInt(_result);
        writeInt(_activeChar.getVisualHair());
        writeInt(_activeChar.getVisualFace());
        writeInt(_activeChar.getVisualHairColor());
    }

}
