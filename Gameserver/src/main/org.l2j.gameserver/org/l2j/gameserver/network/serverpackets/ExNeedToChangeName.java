package org.l2j.gameserver.network.serverpackets;

import org.l2j.gameserver.network.GameClient;
import org.l2j.gameserver.network.ServerExPacketId;

/**
 * Dialog with input field<br>
 * type 0 = char name (Selection screen)<br>
 * type 1 = clan name
 *
 * @author JIV
 */
public class ExNeedToChangeName extends ServerPacket {
    private final int _type;
    private final int _subType;
    private final String _name;

    public ExNeedToChangeName(int type, int subType, String name) {
        super();
        _type = type;
        _subType = subType;
        _name = name;
    }

    @Override
    public void writeImpl(GameClient client) {
        writeId(ServerExPacketId.EX_NEED_TO_CHANGE_NAME);

        writeInt(_type);
        writeInt(_subType);
        writeString(_name);
    }

}
