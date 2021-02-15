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

        val quest = player.quest
        quest.current_quest = "the_rope_quest"


        if (!quest.acquired()) {

            quest.acquire()

            player.channel.send_default_message("You're now on ${quest.stage} quest stage.")
        } else {
            player.channel.send_default_message("Are you done?")
        }

        player.containers.inv_add_item(1);

    }
}