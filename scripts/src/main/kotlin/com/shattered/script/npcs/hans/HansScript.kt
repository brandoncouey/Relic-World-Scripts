package com.shattered.script.npcs.hans

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.api.impl.NpcAPI
import com.shattered.script.types.NPCScript

class HansScript : NPCScript() {

    override fun fornpc(): String {
        return "hans"
    }

    override fun register_to_vendor(): String {
        return "default"
    }

    override fun on_normal_interact(player: PlayerAPI, npc: NpcAPI) {
        player!!.containers.vendor_open(npc, "default")

    }
}