package io.parkersmith.sunverse.core.features.boosters;

import io.parkersmith.sunverse.core.Main;
import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.core.event.BoosterUpdateEvent;
import io.parkersmith.sunverse.shared.booster.GameBooster;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Hiett on 8/4/2017.
 */
public class Loop_BoosterCheck extends BukkitRunnable {

    public Loop_BoosterCheck() {
        this.runTaskTimer(Main.getInstance(), 0L, 20 * 60);
    }

    @Override
    public void run() {
        if (CoreAPI.getBoosterManager().eventBoosterActivated())
            if (CoreAPI.getBoosterManager().getCurrentEventBooster().getEndTime() < System.currentTimeMillis())
                CoreAPI.getBoosterManager().setCurrentEventBooster(null);

        if (CoreAPI.getBoosterManager().getCurrentGameBoosters().size() > 0) {

            List<GameBooster> toRemove = new ArrayList<>();
            for (GameBooster bo : CoreAPI.getBoosterManager().getCurrentGameBoosters())
                if (bo.getEndTime() < System.currentTimeMillis())
                    toRemove.add(bo);

            for(GameBooster booster : toRemove)
                CoreAPI.getBoosterManager().removeGameBooster(booster);

            Bukkit.getPluginManager().callEvent(new BoosterUpdateEvent());
        }
    }

}
