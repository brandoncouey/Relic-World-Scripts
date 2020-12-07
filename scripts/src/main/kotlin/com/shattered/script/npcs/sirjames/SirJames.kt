package com.shattered.script.npcs.sirjames

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.api.impl.NpcAPI
import com.shattered.script.types.NPCDialogScript

class SirJames : NPCDialogScript() {

    override fun fornpc(): String? {
        return "sir james"
    }


    override fun on_start(character: CharacterAPI, npc: NpcAPI) {
        this.character = character;
        this.npc = npc;
        if (character.vars.get_tbool("talked-to-hans")!!) {
            single("My man! You've spoken to hans")
            options("yes i have!", "I was just leaving...")
            stage = 1
        } else {
            single("How can i help you?")
            options("I was just leaving")
        }
    }

    override fun on_option(id: Int) {

        when(stage.toInt()) {

            0 -> {
                exit()
            }

            1 -> {

                when (id) {
                    1 -> {
                        single("Very well, I may have some supplies for you!")
                        options("Lets see!", "No thank you, i was just leaving")
                        stage = 2
                    }
                    2 -> exit()
                }

            }

            2 -> {
                when (id) {
                    1 -> {
                        character!!.containers.vendor_open(npc, "gathering.supplies")
                        exit()
                    }
                    2 -> exit()
                }
            }

        }

    }
}