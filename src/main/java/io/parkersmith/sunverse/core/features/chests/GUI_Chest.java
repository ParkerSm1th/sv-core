package io.parkersmith.sunverse.core.features.chests;

import io.parkersmith.sunverse.core.user.User;
import io.parkersmith.sunverse.core.utils.gui.AbstractGui;

public class GUI_Chest extends AbstractGui {

    public GUI_Chest(User paradisePlayer) {
        super(3, "Select Chest");

        for(ChestType chestType : ChestType.values())
            setItem(chestType.getItemStack(paradisePlayer), chestType.getSlot(), (s, c, p) -> {

            });
    }

}
