package io.parkersmith.sunverse.core.features.messages;

import io.parkersmith.sunverse.core.user.User;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

/**
 * Created by Chase on 8/10/2017.
 */
public class Message_Discord implements Message {

    @Override
    public TextComponent buildMessage(User pp) {

        ComponentBuilder cb = new ComponentBuilder("\nSunverse").bold(true).color(ChatColor.GOLD).append(" » ").bold(false).color(ChatColor.DARK_GRAY)
                .append("Click here to join our public discord! :D\n").color(ChatColor.YELLOW);

        TextComponent tc = new TextComponent(cb.create());

        tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to open a link to join our discord!").color(ChatColor.LIGHT_PURPLE).create()));
        tc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/"));

        return tc;
    }
}
