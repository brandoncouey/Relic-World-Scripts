package com.shattered.script.api.npc;

import com.shattered.game.actor.npc.NPC;
import lombok.NonNull;

@NonNull
public abstract class RelicNpcAPI {


    /**
     * Represents the Character referenced for API
     */
    public final NPC npc;

    /**
     * npc
     * @param npc
     */
    public RelicNpcAPI(NPC npc) {
        this.npc = npc;
    }

    /**
     * Gets the Name of the NPC
     * @return
     */
    public abstract String getName();


}
