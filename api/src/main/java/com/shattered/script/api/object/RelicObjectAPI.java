package com.shattered.script.api.object;

import com.shattered.game.actor.object.WorldObject;
import lombok.NonNull;

@NonNull
public abstract class RelicObjectAPI {


    /**
     * Represents the Object referenced for API
     */
    public final WorldObject object;

    /**
     * npc
     * @param object
     */
    public RelicObjectAPI(WorldObject object) {
        this.object = object;
    }

    /**
     * Gets the Name of the World Object
     * @return
     */
    public abstract String getName();


}
