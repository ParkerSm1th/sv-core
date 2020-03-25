package io.parkersmith.sunverse.core.commands.general;

import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.core.user.OfflineUser;
import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.user.data.reports.Gui_Infraction;
import io.parkersmith.sunverse.core.commands.UserPlayerCommand;
import io.parkersmith.sunverse.shared.infraction.Infraction;
import io.parkersmith.sunverse.shared.rank.RankType;
import net.md_5.bungee.api.ChatColor;

/**
 * Created by Scott Hiett on 8/11/2017.
 */
public class Cmd_Infraction extends UserPlayerCommand {

    public Cmd_Infraction() {
        super("punish", RankType.STAFF.getRankLevel());
    }

    @Override
    public void runCommand(User pp, String[] args) {

        if (args.length == 0) {
            pp.sendPrefixedMessage(ChatColor.RED + "Correct Usage: /punish <username>");
            return;
        }

        if (args[0].equalsIgnoreCase(pp.getUsername())) {
            pp.sendPrefixedMessage(ChatColor.RED + "You are unable to punish yourself. Try some meditation.");
            return;
        }

        OfflineUser opp = CoreAPI.getUser(args[0]);
        if (opp == null) {
            pp.sendPrefixedMessage(ChatColor.RED + "Invalid Player!");
            return;
        }

        if (pp.getRank().getRankType().getRankLevel() <= opp.getRank().getRankType().getRankLevel()) {
            pp.sendPrefixedMessage(ChatColor.RED + "You are unable to punish other staff members. I hope you're trolling.");
            return;
        }

        if (args.length == 1) {
            new Gui_Infraction(pp, opp);
            return;
        }

        if (!args[1].equalsIgnoreCase("custom"))
            return;

        if (!isInteger(args[2])) {
            pp.sendPrefixedMessage(ChatColor.RED + "Invalid Number!");
            return;
        }

        int infractionPoints = Integer.parseInt(args[2]);
        StringBuilder reason = new StringBuilder();

        // TODO: Build reason

        opp.addInfraction(new Infraction(pp.getUUID(), opp.getUUID(), infractionPoints, reason.toString()));
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(Exception e) {
            return false;
        }

        return true;
    }

}
