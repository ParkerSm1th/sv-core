package io.parkersmith.sunverse.core.commands.general;

import io.parkersmith.sunverse.core.features.messages.Messages;
import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.commands.UserPlayerCommand;

/**
 * Created by Chase on 8/10/2017.
 */
public class Cmd_Discord extends UserPlayerCommand {

    public Cmd_Discord() {
        super("discord", 0);
    }

    @Override
    public void runCommand(User pp, String[] args) {
        Messages.DISCORD_LINK.send(pp);
    }
}
