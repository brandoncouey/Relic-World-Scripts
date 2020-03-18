package com.shattered.script.npcs

import com.shattered.game.actor.`object`.component.transform.Location
import com.shattered.game.actor.`object`.component.transform.Rotation
import com.shattered.script.api.impl.*
import com.shattered.script.types.NPCScript


class HansScript : NPCScript() {

    override fun getNPCName(): String {
        return "hans"
    }

    override fun onNormalInteract(character: CharacterAPI, npc: NpcAPI) {
        character.channel?.sendDefaultMessage("Hello ${character.name}, how are you today?")
        character.playAnimation(1)
        world.spawnNPC(2, Location(-4175, -2322, 198), Rotation(0, 0, 0))
        character.channel.sendDefaultMessage("I just spawned a npc. ffs.")

    }

    override fun onShiftInteract(character: CharacterAPI, npc: NpcAPI) {
        character.channel?.sendDefaultMessage("${npc.name} is not tryna fk with you..")
    }

    override fun onCntrlInteract(character: CharacterAPI, npc: NpcAPI) {
        character.channel.sendDefaultMessage("You've interacted with ${npc.name}, ${character.name}")
    }
}