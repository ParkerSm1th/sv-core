package io.parkersmith.sunverse.core.listeners.general;

import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.shared.framework.ServerSetting;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

/**
 * Created by Chase on 7/31/2017.
 */
public class Event_PlayerDropItem implements Listener {

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        if (!CoreAPI.getUser(e.getPlayer()).getServerSetting(ServerSetting.ITEM_DROPPING))
            e.setCancelled(true);
    }
}
