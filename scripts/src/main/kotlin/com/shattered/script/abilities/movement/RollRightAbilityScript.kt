package com.shattered.script.abilities.movement

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.AbilityScript

class RollRightAbilityScript : AbilityScript() {

    override fun name(): String {
        return "roll right"
    }

    override fun can_use(player: PlayerAPI?): Boolean {
        //TODO check for the amount of energy consumption
        return true
    }

    override fun on_cast(p0: PlayerAPI?) {
        TODO("Not yet implemented")
    }

    override fun on_use(player: PlayerAPI) {
        player.play_animation("roll right")
    }


}
