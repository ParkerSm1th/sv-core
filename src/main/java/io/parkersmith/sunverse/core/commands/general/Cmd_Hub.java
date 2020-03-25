package io.parkersmith.sunverse.core.commands.general;

import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.commands.UserPlayerCommand;
import io.parkersmith.sunverse.shared.framework.ServerType;
import org.bukkit.ChatColor;

/**
 * Created by Chase on 8/2/2017.
 */
public class Cmd_Hub extends UserPlayerCommand {

    public Cmd_Hub() {
        super("hub", 0);
    }

    @Override
    public void runCommand(User pp, String[] args) {
        if (CoreAPI.getServerDataManager().getServerType() != ServerType.HUB) {
            pp.sendPrefixedMessage(ChatColor.GREEN + "Sending to hub...");
            pp.sendToServer("hub");
        }
    }
}
