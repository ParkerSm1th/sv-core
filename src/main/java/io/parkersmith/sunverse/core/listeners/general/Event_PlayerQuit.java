package io.parkersmith.sunverse.core.listeners.general;

import io.parkersmith.sunverse.core.Main;
import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.event.UserQuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/**
 * Created by Scott Hiett on 6/27/2017.
 */
public class Event_PlayerQuit implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent e) {

        User pp = CoreAPI.getUser(e.getPlayer());
        pp.removeScoreboard();

        if (!pp.isSendingToServer()) {
            pp.savePlayerData();
            Bukkit.getServer().getPluginManager().callEvent(new UserQuitEvent(pp, UserQuitEvent.QuitType.LEAVING_NETWORK));
        }

        Main.getUserManager().removeUser(pp);
    }
}
