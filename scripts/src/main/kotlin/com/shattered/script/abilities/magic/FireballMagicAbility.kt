package com.shattered.script.abilities.magic

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.api.impl.NpcAPI
import com.shattered.script.types.AbilityScript

class FireballMagicAbility : AbilityScript() {


    override fun name(): String {
        return "fireball"
    }

    override fun can_use(character: CharacterAPI): Boolean {
        return true
    }

    override fun on_use(character: CharacterAPI) {
        character.combat.cast_projectile("right hand throw", "fireball", "mainhand", this)
    }

    override fun on_hit(npc: NpcAPI, ability: String?) {

    }

}