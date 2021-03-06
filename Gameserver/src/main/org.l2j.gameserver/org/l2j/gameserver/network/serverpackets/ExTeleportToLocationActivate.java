package org.l2j.gameserver.network.serverpackets;

import org.l2j.gameserver.model.Location;
import org.l2j.gameserver.model.actor.Creature;
import org.l2j.gameserver.network.GameClient;
import org.l2j.gameserver.network.ServerExPacketId;

/**
 * @author UnAfraid
 */
public class ExTeleportToLocationActivate extends ServerPacket {
    private final int _objectId;
    private final Location _loc;

    public ExTeleportToLocationActivate(Creature character) {
        _objectId = character.getObjectId();
        _loc = character.getLocation();
    }

    @Override
    public void writeImpl(GameClient client) {
        writeId(ServerExPacketId.EX_TELEPORT_TO_LOCATION_ACTIVATE);

        writeInt(_objectId);
        writeInt(_loc.getX());
        writeInt(_loc.getY());
        writeInt(_loc.getZ());
        writeInt(0); // Unknown (this isn't instanceId)
        writeInt(_loc.getHeading());
        writeInt(0); // Unknown
    }

}