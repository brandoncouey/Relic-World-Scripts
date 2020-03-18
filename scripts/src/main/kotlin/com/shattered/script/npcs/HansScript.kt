package com.shattered.script.npcs

import com.shattered.script.api.impl.*
import com.shattered.script.types.NPCScript


class HansScript : NPCScript() {

    override fun getNPCName(): String {
        return "hans"
    }

    override fun onNormalInteract(character: CharacterAPI?, npc: NpcAPI?) {
        character?.channel?.sendDefaultMessage("Hello ${character?.name}, how are you today?")
    }

    override fun onShiftInteract(character: CharacterAPI?, npc: NpcAPI?) {
        character?.channel?.sendDefaultMessage("${npc?.name} is not tryna fk with you..")
    }

    override fun onCntrlInteract(character: CharacterAPI?, npc: NpcAPI?) {
        character?.channel?.sendDefaultMessage("You've interacted with  ${npc?.name}, ${character?.name}")
    }
}