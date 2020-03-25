package io.parkersmith.sunverse.core.commands;

import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.core.user.User;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Chase on 7/24/2017.
 */
public abstract class UserPlayerCommand extends UserCommand {

    public UserPlayerCommand(String commandName, int permission) {
        super(commandName, permission);
    }

    public abstract void runCommand(User pp, String[] args);

    @Override
    public void runCommand(CommandSender sender, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command cannot be executed from console!");
            return;
        }

        runCommand(CoreAPI.getUser((Player) sender), args);
    }

}
