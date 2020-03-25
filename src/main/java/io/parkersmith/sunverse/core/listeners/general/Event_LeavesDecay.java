package io.parkersmith.sunverse.core.listeners.general;

import io.parkersmith.sunverse.shared.framework.ServerSetting;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

/**
 * Created by Chase on 9/10/2017.
 */
public class Event_LeavesDecay implements Listener {

    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent e) {
        if (!ServerSetting.LEAF_DECAY.getDefaultValue())
            e.setCancelled(true);
    }
}
