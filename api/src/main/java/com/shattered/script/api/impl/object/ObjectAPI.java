package com.shattered.script.api.impl.object;

import com.shattered.game.actor.object.WorldObject;
import com.shattered.script.api.object.RelicObjectAPI;

public class ObjectAPI extends RelicObjectAPI {


    /**
     *
     * @param object
     */
    public ObjectAPI(WorldObject object) {
        super(object);
    }

    /**
     * Gets the Name of the NPC
     *
     * @return
     */
    @Override
    public String getName() {
        return null;
    }
}
