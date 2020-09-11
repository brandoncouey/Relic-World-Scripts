package com.shattered.script.npcs.hans

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.api.impl.NpcAPI
import com.shattered.script.types.NPCDialogScript

open class HansDialogScript : NPCDialogScript() {


    override fun fornpc(): String? {
        return "hans"
    }

    override fun on_start(character: CharacterAPI, npc: NpcAPI) {
        this.character = character;
        this.npc = npc;
        single(npc._id, "Hello ${character.get_name()}, how may i help you?")
        options("Who are you?", "Do you have any materials for sale?", "Nothing, I was just leaving.")
    }


    override fun on_option(id: Int) {
        when (stage.toInt()) {


            0 -> {
                when (id) {
                    1 -> {
                        single("Why i am Shattered Relics oldest npc!")
                        options("Do you have any materials for sale?", "Nothing, I was just leaving.")
                        stage = 1;
                    }
                    2 -> {
                        single("Why yes i do! Would you like to take a gander?")
                        options("Yes please", "No thanks, I was just leaving.")
                        stage = 2;
                    }
                    3 -> exit()
                }
            }

            1 -> {
                when (id) {
                    1 -> {
                        single("Why yes i do! Would you like to take a gander?")
                        options("Yes please", "No thanks, I was just leaving.")
                        stage = 2;
                    }
                    2 -> exit()
                }
            }

            2 -> {
                when (id) {
                    1 -> open_vendor()
                    2 -> exit()
                }
            }




        }


    }


    fun open_vendor() {
        exit()
        character!!.containers.vendor_open(npc, "default")
        character?.vars?.tvar_bool_set("talked-to-hans", true)
    }



}