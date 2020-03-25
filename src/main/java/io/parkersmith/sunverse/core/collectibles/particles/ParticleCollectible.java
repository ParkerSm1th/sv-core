package io.parkersmith.sunverse.core.collectibles.particles;

import io.parkersmith.sunverse.core.Main;
import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.collectibles.Collectible;
import io.parkersmith.sunverse.core.collectibles.CollectibleRarity;
import io.parkersmith.sunverse.core.collectibles.CollectibleType;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

import java.util.UUID;

/**
 * Created by Chase on 1/14/2018.
 */
public abstract class ParticleCollectible extends Collectible {

    private UUID owner;
    private long loopOccurrence;
    private BukkitTask loop = null;

    public ParticleCollectible(User paradisePlayer, String display, String description, ItemStack itemStack, CollectibleRarity rarity, boolean needsDeluxe, long loopOccurrence) {
        super(display, description, itemStack, CollectibleType.PARTICLE, rarity, needsDeluxe);
        this.owner = paradisePlayer.getUUID();
        this.loopOccurrence = loopOccurrence;
    }

    public UUID getOwner() {
        return owner;
    }

    public boolean isActive() {
        return loop != null;
    }

    abstract void onLoop();

    public void startLoop() {
        this.loop = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), this::onLoop, 0L, loopOccurrence);
    }

    public void cancelLoop() {
        loop.cancel();
    }
}
