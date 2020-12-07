package com.shattered.script.abilities.magic.archery

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.types.AbilityScript

class LongArrowArcherAbility : AbilityScript() {


    override fun name(): String {
        return "long arrow"
    }

    override fun can_use(character: CharacterAPI): Boolean {
        return true;
    }

    override fun on_use(character: CharacterAPI) {
        character.combat.cast_projectile("shoot bow normal", "long arrow", "mainhand", this)
    }
}