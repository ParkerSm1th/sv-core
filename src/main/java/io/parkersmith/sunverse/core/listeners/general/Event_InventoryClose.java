package io.parkersmith.sunverse.core.listeners.general;

import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.utils.gui.AbstractGui;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

/**
 * Created by Chase on 6/28/2017.
 */
public class Event_InventoryClose implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryCloseEvent(InventoryCloseEvent event) {

        User pp = CoreAPI.getUser((Player) event.getPlayer());
        AbstractGui currentGui = pp.getCurrentGui();

        if (currentGui != null && currentGui.getInventory().getName().equals(event.getInventory().getName())) {
            currentGui.onClose();
            pp.setCurrentGui(null);
        }
    }
}
