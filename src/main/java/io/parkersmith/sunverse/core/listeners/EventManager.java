package io.parkersmith.sunverse.core.listeners;

import io.parkersmith.sunverse.core.Main;
import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.core.features.chests.Chest;
import io.parkersmith.sunverse.core.listeners.general.*;
import io.parkersmith.sunverse.core.listeners.general.packets.Event_NamedSoundEffect;
import io.parkersmith.sunverse.core.listeners.general.packets.Event_TabComplete;
import io.parkersmith.sunverse.core.listeners.minigame.Event_PlayerJoin;
import io.parkersmith.sunverse.core.listeners.general.Event_MessageListener;
import io.parkersmith.sunverse.shared.framework.ServerType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Scott Hiett on 6/27/2017.
 */
public class EventManager {

    private Listener[] minigameListeners = {
            new Event_PlayerJoin()
    };

    private Listener[] generalListeners = {
            new Event_AsyncPlayerChat(),
            new Event_EntityDamage(),
            new Event_FoodLevelChange(),
            new Event_InventoryClick(),
            new Event_InventoryClose(),
            new Event_LeavesDecay(),
            new Event_PlayerCommandPreprocess(),
            new Event_PlayerQuit(),
            new Event_PlayerDropItem(),
            new Event_PlayerInteract(),
            new io.parkersmith.sunverse.core.listeners.general.Event_PlayerJoin()
    };

    public EventManager() {

        Event_MessageListener messageListener = new Event_MessageListener();
        new Event_TabComplete();
        new Event_NamedSoundEffect();

        Main.getInstance().getServer().getMessenger().registerOutgoingPluginChannel(Main.getInstance(), "BungeeCord");
        Main.getInstance().getServer().getMessenger().registerOutgoingPluginChannel(Main.getInstance(), "Sunverse");

        Main.getInstance().getServer().getMessenger().registerIncomingPluginChannel(Main.getInstance(), "Sunverse", messageListener);
        Main.getInstance().getServer().getMessenger().registerIncomingPluginChannel(Main.getInstance(), "BungeeCord", messageListener);

        List<Listener> activeListeners = new ArrayList<>();
        activeListeners.addAll(Arrays.asList(generalListeners));

        // TODO: Remove after testing
        if (Main.getServerDataManager().getServerType() == ServerType.HUB) {
            Chest.addChest(new Chest(new Location(Bukkit.getWorld("world"), 34D, 95D, -21D), new Location(Bukkit.getWorld("world"), 37.5, 95.0, -20.5, 90, 20)));
        } else {
            if (CoreAPI.getServerDataManager().getServerType() == ServerType.MINIGAME)
                activeListeners.addAll(Arrays.asList(minigameListeners));

            for (Listener listener : activeListeners)
                Bukkit.getServer().getPluginManager().registerEvents(listener, Main.getInstance());
        }
    }
}
