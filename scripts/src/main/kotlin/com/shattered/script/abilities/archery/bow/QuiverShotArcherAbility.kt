package com.shattered.script.abilities.archery.bow

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.AbilityScript

class QuiverShotArcherAbility : AbilityScript() {



    override fun name(): String {
        return "quaddle"
    }

    override fun can_use(player: PlayerAPI): Boolean {
        if (!player.containers.equip_hands_contains("bow")) {
            player.channel.send_default_message("You need a bow to use this ability.")
            return false
        }
        if (player.vars.get_int("energy") < 80) return false
        return true
    }

    override fun on_use(player: PlayerAPI) {
        player.play_animation("cast_instant_arrow")
        val targets = player.combat.get_possible_targets(5)
        player.vars.decrement_int("energy", 80)
        targets.forEach { tar ->
            player.combat.send_projectile("arrow", tar, 15, this)
        }
    }


}