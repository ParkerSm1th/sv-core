package io.parkersmith.sunverse.core.collectibles;

import io.parkersmith.sunverse.core.user.User;

public interface CollectibleVisibility {

    void hideCollectible(User paradisePlayer);

    void showCollectible(User paradisePlayer);
}
