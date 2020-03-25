package io.parkersmith.sunverse.core.commands.general;

import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.core.user.OfflineUser;
import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.commands.UserPlayerCommand;

import io.parkersmith.sunverse.shared.infraction.Infraction;
import io.parkersmith.sunverse.shared.rank.RankType;
import net.md_5.bungee.api.ChatColor;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Chase on 1/7/2018.
 */
public class Cmd_History extends UserPlayerCommand {

    public Cmd_History() {
        super("history", RankType.STAFF.getRankLevel());
    }

    @Override
    public void runCommand(User pp, String[] args) {

        if (args.length != 1) {
            pp.sendPrefixedMessage(ChatColor.RED + "Correct Usage: /history <username>");
            return;
        }

        OfflineUser opp = CoreAPI.getUser(args[0]);
        if (opp == null) {
            pp.sendPrefixedMessage(ChatColor.RED + "Invalid Player!");
            return;
        }

        List<Infraction> infractions = opp.getInfractions();

        if (infractions.size() == 0) {
            pp.sendPrefixedMessage(ChatColor.WHITE + opp.getUsername() + ChatColor.GREEN + " has no past infractions.");
            return;
        }

        infractions.sort(Comparator.comparingInt(Infraction::getInfractionValue).reversed());

        pp.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + opp.getUsername() + "'s Infractions");
        for (Infraction infraction : infractions)
            pp.sendMessage(ChatColor.YELLOW + infraction.toHistoryString());
    }
}
