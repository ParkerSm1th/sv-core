package io.parkersmith.sunverse.core.commands.general;

import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.user.data.stats.Stat;
import io.parkersmith.sunverse.core.commands.UserPlayerCommand;
import net.md_5.bungee.api.ChatColor;

public class Cmd_Coins extends UserPlayerCommand {

    public Cmd_Coins() {
        super("coins", 0);
    }

    @Override
    public void runCommand(User pp, String[] args) {
        pp.sendMessage(ChatColor.GOLD + "You have " + ChatColor.WHITE + pp.getStat(Stat.COINS) + ChatColor.GOLD + " coins.");
    }
}
