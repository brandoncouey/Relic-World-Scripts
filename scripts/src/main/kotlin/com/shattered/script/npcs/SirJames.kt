package com.shattered.script.npcs

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.api.impl.NpcAPI
import com.shattered.script.types.NPCScript

class SirJames : NPCScript() {


    override fun fornpc(): String {
        return "sir james"
    }

    override fun register_to_vendor(): String {
        return "gathering.supplies"
    }

    override fun on_normal_interact(character: CharacterAPI, npc: NpcAPI) {
        val coins = character.vars!!.get_var_int("coins")

        if (coins < 3)
            character.channel!!.send_default_message("You are foolish! Come back when you have some real wealth.")
        else
            character.channel!!.send_default_message("How can i help you?")
    }

    override fun on_shift_interact(character: CharacterAPI, npc: NpcAPI) {
        val quest = character.quest
        quest!!.current_quest = "the_rope_quest"

        if (!quest.acquired())
            character.channel!!.send_default_message("You're not allowed here!")
        else
            character.channel!!.send_default_message("A friend of hans is a friend of mine.")
    }

    override fun on_cntrl_interact(character: CharacterAPI, npc: NpcAPI) {
        character.channel!!.send_default_message("What do you want ${character.get_name()} ?")
    }

}