package io.parkersmith.sunverse.core.collectibles.gadgets;

import io.parkersmith.sunverse.core.api.misc.Title;
import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.collectibles.Collectible;
import io.parkersmith.sunverse.core.collectibles.CollectibleRarity;
import io.parkersmith.sunverse.core.collectibles.CollectibleType;
import io.parkersmith.sunverse.core.utils.items.cItemStack;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

/**
 * Created by Chase on 1/18/2018.
 */
public abstract class GadgetCollectible extends Collectible {

    private UUID owner;
    private long cooldown, lastUsed = 0;

    public GadgetCollectible(User paradisePlayer, String display, String description, ItemStack itemStack, CollectibleRarity rarity, long cooldown) {
        super(display, description, itemStack, CollectibleType.GADGET, rarity);
        this.owner = paradisePlayer.getUUID();
        this.cooldown = cooldown;
    }

    public UUID getOwner() {
        return owner;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(owner);
    }

    public boolean isOnCooldown() {
        return lastUsed + cooldown > System.currentTimeMillis();
    }

    public long getCooldown() {
        return cooldown;
    }

    public long getLastUsed() {
        return lastUsed;
    }

    public void setUsed() {
        this.lastUsed = System.currentTimeMillis();
    }

    public void displayCooldownToPlayer() {
        final float timeLeft = ((lastUsed + cooldown) - System.currentTimeMillis()) / 1000.0F;
        Title.sendActionbar(getPlayer(), getRarity().getColor() + getDisplay() + ChatColor.YELLOW + " is still on cooldown for " + String.format("%.2f", timeLeft) + "s");
    }

    public abstract void onLeftClick();

    public abstract void onRightClick();

    public abstract void onClear();

    public abstract cItemStack getHandStack();
}
