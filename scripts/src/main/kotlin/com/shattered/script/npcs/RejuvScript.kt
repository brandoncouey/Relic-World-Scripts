package com.shattered.script.npcs

import com.shattered.script.api.impl.NpcAPI
import com.shattered.script.types.NPCScript

class RejuvScript : NPCScript() {

    override fun on_update(api: NpcAPI?) {
        super.on_update(api)

        val p = api?.zone?.players
        p?.forEach { n ->
            if (n.zone.is_within_distance(api, 360)) {
                n.combat.heal(api, 15)
            }
        }
    }

}