package io.parkersmith.sunverse.core.features.messages;

import io.parkersmith.sunverse.core.user.User;
import net.md_5.bungee.api.chat.TextComponent;

/**
 * Created by Chase on 7/29/2017.
 */
public interface Message {

    TextComponent buildMessage(User pp);

}
