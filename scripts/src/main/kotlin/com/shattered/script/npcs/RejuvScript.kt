package com.shattered.script.npcs

import com.shattered.script.api.impl.NpcAPI
import com.shattered.script.types.NPCScript

class RejuvScript : NPCScript() {

    override fun fornpc(): String {
        return "rejuv"
    }

    override fun on_awake(api: NpcAPI) {
        super.on_awake(api)
        api.npc.lifeSpan = 5
    }

    //TODO we need a tick event
    override fun on_update(npc: NpcAPI) {
        super.on_update(npc)
        val players = npc.zone?.players

        players?.forEach { p ->
            if (npc.zone.is_within_distance(p, 360)) {
                //person to heal -> source
                p.combat.heal(npc, 15)
                println("We are healing player ${p.name}")
            }
        }

    }

}