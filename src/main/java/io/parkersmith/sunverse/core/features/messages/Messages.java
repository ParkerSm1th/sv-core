package io.parkersmith.sunverse.core.features.messages;

import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.core.user.User;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;

/**
 * Created by Chase on 7/29/2017.
 */
public enum Messages {

    ACHIEVEMENTS_HELP(new Message_AchievementsHelp()),
    ACTIVATE_BOOSTER(new Message_ActivateBooster()),
    BUY_BOOSTER(new Message_BuyBooster()),
    DISCORD_LINK(new Message_Discord()),
    COMMAND_HELP(new Message_HelpCommand()),
    BUY_STAT_RESET_TOKENS(new Message_StatResetToken());

    private Message messageClass = null;
    private BaseComponent[] message = null;

    Messages(Message messageClass) {
        this.messageClass = messageClass;
    }

    public void send(User pp) {
        pp.getPlayer().spigot().sendMessage(messageClass.buildMessage(pp));
    }

    public void send(Player player) {
        player.spigot().sendMessage(messageClass.buildMessage(CoreAPI.getUser(player)));
    }
}
