package com.shattered.script.npcs

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.api.impl.NpcAPI
import com.shattered.script.types.NPCScript

class SirJames : NPCScript() {


    override fun fornpc(): String {
        return "sir james"
    }

    override fun register_to_vendor(): String {
        return "gathering.supplies"
    }

    override fun on_normal_interact(player: PlayerAPI, npc: NpcAPI) {
        player!!.containers.vendor_open(npc, "default")
    }

    override fun on_shift_interact(player: PlayerAPI, npc: NpcAPI) {
        val quest = player.quest
        quest.current_quest = "the_rope_quest"

        if (!quest.acquired())
            player.channel.send_default_message("You're not allowed here!")
        else
            player.channel.send_default_message("A friend of hans is a friend of mine.")
    }

    override fun on_cntrl_interact(player: PlayerAPI, npc: NpcAPI) {
        player.channel.send_default_message("What do you want ${player.name} ?")
    }

}