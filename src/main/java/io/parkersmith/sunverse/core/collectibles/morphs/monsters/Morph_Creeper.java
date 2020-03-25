package io.parkersmith.sunverse.core.collectibles.morphs.monsters;

import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.collectibles.CollectibleRarity;
import io.parkersmith.sunverse.core.collectibles.morphs.MorphCollectible;
import io.parkersmith.sunverse.core.utils.items.cItemStack;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class Morph_Creeper extends MorphCollectible {

    public Morph_Creeper(User player) {
        super(player, EntityType.CREEPER, "", "", new cItemStack(Material.SKULL_ITEM), CollectibleRarity.RARE);
    }

    @Override
    public void spawnOptions(LivingEntity entity) {

    }

}
