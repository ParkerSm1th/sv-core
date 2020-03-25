package io.parkersmith.sunverse.core.event;

import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.user.data.settings.Setting;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Chase on 1/19/2018.
 */
public class UserToggleSettingEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private User user;
    private Setting setting;
    private boolean value;

    public UserToggleSettingEvent(User user, Setting setting, boolean value) {
        this.user = user;
        this.setting = setting;
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public Setting getSetting() {
        return setting;
    }

    public boolean getValue() {
        return value;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
