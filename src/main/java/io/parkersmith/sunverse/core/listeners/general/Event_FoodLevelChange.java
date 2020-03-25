package io.parkersmith.sunverse.core.listeners.general;

import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.shared.framework.ServerSetting;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Created by Chase on 7/25/2017.
 */
public class Event_FoodLevelChange implements Listener {

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {

        if (CoreAPI.getUser(((Player) e.getEntity())).getServerSetting(ServerSetting.HUNGER))
            return;

        e.setCancelled(true);
        ((Player) e.getEntity()).setSaturation(14.4F);
        ((Player) e.getEntity()).setFoodLevel(20);
    }
}
