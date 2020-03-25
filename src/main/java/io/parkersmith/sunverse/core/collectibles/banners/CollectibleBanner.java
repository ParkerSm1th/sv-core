package io.parkersmith.sunverse.core.collectibles.banners;

import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.collectibles.Collectible;
import io.parkersmith.sunverse.core.collectibles.CollectibleRarity;
import io.parkersmith.sunverse.core.collectibles.CollectibleType;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

/**
 * Created by Chase on 1/15/2018.
 */
public abstract class CollectibleBanner extends Collectible {

    private UUID owner;

    public CollectibleBanner(User user, String display, String description, ItemStack itemStack, CollectibleRarity rarity) {
        super(display, description, itemStack, CollectibleType.BANNER, rarity);
        this.owner = user.getUUID();
    }

    abstract ItemStack craftBanner();

    public void equipBanner() {
        Bukkit.getPlayer(owner).getInventory().setHelmet(craftBanner());
    }
}
