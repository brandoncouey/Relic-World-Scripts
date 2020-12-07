package com.shattered.script.abilities.movement

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.types.AbilityScript

class RollRightAbilityScript : AbilityScript() {

    override fun name(): String {
        return "roll right"
    }

    override fun can_use(character: CharacterAPI?): Boolean {
        //TODO check for the amount of energy consumption
        return true
    }

    override fun on_use(character: CharacterAPI) {
        character.play_animation("roll right")
    }


}
