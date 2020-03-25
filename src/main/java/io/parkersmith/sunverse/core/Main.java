package io.parkersmith.sunverse.core;

import io.parkersmith.sunverse.core.api.entities.EntityHider;
import io.parkersmith.sunverse.core.api.v2.CoreAPI;
import io.parkersmith.sunverse.core.user.UserManager;
import io.parkersmith.sunverse.core.collectibles.CollectibleManager;
import io.parkersmith.sunverse.core.collectibles.gadgets.Gadget_SheepBomb;
import io.parkersmith.sunverse.core.commands.CommandManager;
import io.parkersmith.sunverse.core.features.boosters.BoosterManager;
import io.parkersmith.sunverse.core.features.boosters.Loop_BoosterCheck;
import io.parkersmith.sunverse.core.features.serverdata.ServerDataManager;
import io.parkersmith.sunverse.core.listeners.EventManager;
import io.parkersmith.sunverse.shared.config.ServerConfiguration;
import io.parkersmith.sunverse.shared.database.Database;
import io.parkersmith.sunverse.shared.framework.GeneralServerStatus;
import io.parkersmith.sunverse.shared.framework.ServerType;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private static UserManager userManager;
    private static ServerDataManager serverDataManager;
    private static BoosterManager boosterManager;
    private static ServerConfiguration serverConfiguration;
    private static CollectibleManager collectibleManager;
    private static EntityHider entityHider;
    private static Database mongoDatabase;

    @Override
    public void onLoad() {
        serverConfiguration = new io.parkersmith.sunverse.shared.config.ServerConfiguration();
        // Set the CoreAPI prefix
        CoreAPI.PREFIX = serverConfiguration.getPrefix();

        mongoDatabase = new Database(serverConfiguration);
        collectibleManager = new CollectibleManager();
        serverDataManager = new ServerDataManager();
        userManager = new UserManager();
        boosterManager = new BoosterManager();
    }

    @Override
    public void onEnable() {
        instance = this;

        entityHider = new EntityHider(this, EntityHider.Policy.BLACKLIST);
//        taskChainFactory = BukkitTaskChainFactory.create(this);

        new EventManager();
        new CommandManager();
        new Loop_BoosterCheck();
    }

    @Override
    public void onDisable() {
        Gadget_SheepBomb.SHEEP_BOMBS.forEach(Gadget_SheepBomb::onClear);

        if (serverDataManager.getServerType() == ServerType.MINIGAME)
            serverDataManager.updateServerState(GeneralServerStatus.DELETE, 0);

        instance = null;
    }

    public static UserManager getUserManager() {
        return userManager;
    }

    public static ServerConfiguration getServerConfiguration() {
        return serverConfiguration;
    }

    public static CollectibleManager getCollectibleManager() {
        return collectibleManager;
    }

    public static Database getMongoDatabase() {
        return mongoDatabase;
    }

    public static EntityHider getEntityHider() {
        return entityHider;
    }

    public static ServerDataManager getServerDataManager() {
        return serverDataManager;
    }

    public static BoosterManager getBoosterManager() {
        return boosterManager;
    }

    public static Main getInstance(){
        return instance;
    }
}
