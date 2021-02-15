package com.shattered.script.abilities.movement

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.AbilityScript

class RollForwardAbilityScript : AbilityScript() {

    override fun name(): String {
        return "roll forward"
    }

    override fun can_use(player: PlayerAPI?): Boolean {
        //TODO check for the amount of energy consumption
        return true
    }

    override fun on_use(player: PlayerAPI?) {
        player?.play_animation("roll forward")
    }


}