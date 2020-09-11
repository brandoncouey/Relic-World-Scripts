package com.shattered.script.npcs.hans

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.api.impl.NpcAPI
import com.shattered.script.types.NPCScript

class HansScript : NPCScript() {

    override fun fornpc(): String {
        return "hans"
    }

    override fun register_to_vendor(): String {
        return "default"
    }


    override fun on_normal_interact(character: CharacterAPI, npc: NpcAPI) {

        val quest = character.quest
        quest.current_quest = "the_rope_quest"


        if (!quest.acquired()) {

            quest.acquire()

            character.channel.send_default_message("You're now on ${quest._stage} quest stage.")
        } else {
            character.channel.send_default_message("Are you done?")
        }

        character.containers.inv_add_item(1);

    }
}