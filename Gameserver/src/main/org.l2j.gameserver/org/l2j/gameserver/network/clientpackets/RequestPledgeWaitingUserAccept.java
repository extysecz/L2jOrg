package org.l2j.gameserver.network.clientpackets;

import org.l2j.gameserver.instancemanager.CastleManager;
import org.l2j.gameserver.instancemanager.ClanEntryManager;
import org.l2j.gameserver.model.Clan;
import org.l2j.gameserver.model.actor.instance.Player;
import org.l2j.gameserver.network.SystemMessageId;
import org.l2j.gameserver.network.serverpackets.ExPledgeCount;
import org.l2j.gameserver.network.serverpackets.JoinPledge;
import org.l2j.gameserver.network.serverpackets.PledgeShowMemberListAdd;
import org.l2j.gameserver.network.serverpackets.SystemMessage;
import org.l2j.gameserver.network.serverpackets.pledge.PledgeShowInfoUpdate;
import org.l2j.gameserver.network.serverpackets.pledge.PledgeShowMemberListAll;
import org.l2j.gameserver.world.World;

/**
 * @author Sdw
 */
public class RequestPledgeWaitingUserAccept extends ClientPacket {
    private boolean _acceptRequest;
    private int _playerId;
    private int _clanId;

    @Override
    public void readImpl() {
        _acceptRequest = readInt() == 1;
        _playerId = readInt();
        _clanId = readInt();
    }

    @Override
    public void runImpl() {
        final Player activeChar = client.getPlayer();
        if ((activeChar == null) || (activeChar.getClan() == null)) {
            return;
        }

        if (_acceptRequest) {
            final Player player = World.getInstance().findPlayer(_playerId);
            final Clan clan = activeChar.getClan();
            if ((player != null) && (player.getClan() == null) && (clan != null)) {
                player.sendPacket(new JoinPledge(clan.getId()));

                // activeChar.setPowerGrade(9); // academy
                player.setPowerGrade(5); // New member starts at 5, not confirmed.

                clan.addClanMember(player);
                player.setClanPrivileges(player.getClan().getRankPrivs(player.getPowerGrade()));
                player.sendPacket(SystemMessageId.ENTERED_THE_CLAN);

                final SystemMessage sm = SystemMessage.getSystemMessage(SystemMessageId.S1_HAS_JOINED_THE_CLAN);
                sm.addString(player.getName());
                clan.broadcastToOnlineMembers(sm);

                if (clan.getCastleId() > 0) {
                    CastleManager.getInstance().getCastleByOwner(clan).giveResidentialSkills(player);
                }
                player.sendSkillList();

                clan.broadcastToOtherOnlineMembers(new PledgeShowMemberListAdd(player), player);
                clan.broadcastToOnlineMembers(new PledgeShowInfoUpdate(clan));
                clan.broadcastToOnlineMembers(new ExPledgeCount(clan));

                // This activates the clan tab on the new member.
                PledgeShowMemberListAll.sendAllTo(player);
                player.setClanJoinExpiryTime(0);
                player.broadcastUserInfo();

                ClanEntryManager.getInstance().removePlayerApplication(_clanId, _playerId);
            }
        } else {
            ClanEntryManager.getInstance().removePlayerApplication(_clanId, _playerId);
        }
    }
}
