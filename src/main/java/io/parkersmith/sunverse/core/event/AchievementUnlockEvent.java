package io.parkersmith.sunverse.core.event;

import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.user.data.achievements.Achievement;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Chase on 8/9/2017.
 */
public class AchievementUnlockEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private User user;
    private Achievement achievement;

    public AchievementUnlockEvent(User user, Achievement achievement) {
        this.user = user;
        this.achievement = achievement;
    }

    public User getUser() {
        return user;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
