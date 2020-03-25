package io.parkersmith.sunverse.core.listeners.general;

import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.shared.framework.ServerSetting;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Chase on 9/2/2017.
 */
public class Event_EntityDamage implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player && !CoreAPI.getUser((Player) e.getEntity()).getServerSetting(ServerSetting.DAMAGE))
            e.setCancelled(true);
    }
}
