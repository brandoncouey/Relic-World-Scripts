package com.shattered.script.abilities.melee

import com.shattered.engine.tasks.DelayedTaskTicker
import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.AbilityScript

class SliceNDiceAbility : AbilityScript() {

    override fun name(): String {
        return "slice_n_dice"
    }

    override fun can_use(player: PlayerAPI): Boolean {
        return true
    }

    override fun on_cast(player: PlayerAPI) {
    }

    override fun on_use(player: PlayerAPI) {
        player.play_animation("twohand_twinblade_spin_02")

        val target = player.combat.target

        player.zone.npcs.forEach  { n ->
            if (player.zone.distance_to(n) <= 300) {
                player.combat.hit(n, 30, 3, DelayedTaskTicker.DelayTimeUnit.TENTH)
            }
        }
    }
}