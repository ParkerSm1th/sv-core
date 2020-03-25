package io.parkersmith.sunverse.core.commands.general;

import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.commands.UserPlayerCommand;

/**
 * Created by Chase on 6/30/2017.
 */
public class Cmd_AddNote extends UserPlayerCommand {

    public Cmd_AddNote() {
        super("addnote", 2);
    }

    @Override
    public void runCommand(User pp, String[] args) {

    }
}
