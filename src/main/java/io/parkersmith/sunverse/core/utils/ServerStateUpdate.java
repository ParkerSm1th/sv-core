package io.parkersmith.sunverse.core.utils;


import io.parkersmith.sunverse.shared.framework.GeneralServerStatus;

/**
 * Created by Scott Hiett on 8/29/2017.
 */
public class ServerStateUpdate {

    private GeneralServerStatus serverStatus;
    private int maxPlayers;

    public ServerStateUpdate(GeneralServerStatus generalServerStatus, int maxPlayers) {
        this.serverStatus = generalServerStatus;
        this.maxPlayers = maxPlayers;
    }

    public GeneralServerStatus getServerStatus() {
        return serverStatus;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

}
