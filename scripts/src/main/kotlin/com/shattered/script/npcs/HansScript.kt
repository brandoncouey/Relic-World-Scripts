package com.shattered.script.npcs

import com.shattered.script.api.impl.character.CharacterAPI
import com.shattered.script.api.impl.npc.NpcAPI
import com.shattered.script.types.NPCScript

class HansScript : NPCScript() {

    override fun getNPCName(): String {
        return "hans"
    }

    override fun onNormalInteract(character: CharacterAPI?, npc: NpcAPI?) {
        character?.channel?.sendDefaultMessage("Hello ${character?.name}, how are you today?")
    }
}