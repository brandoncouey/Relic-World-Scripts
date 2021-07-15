package com.shattered.script.abilities.archery

import com.shattered.script.api.RelicCharacterAPI
import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.AbilityScript

class DeepMarrowArcherAbility : AbilityScript() {


    override fun name(): String {
        return "arcane_shot"
    }

    override fun can_use(player: PlayerAPI): Boolean {
        if (!player.containers.equip_hands_contains("bow")) {
            player.channel.send_default_message("You need a bow to use this ability.")
            return false
        }
        val target = player.combat.target ?: return false

        if (player.vars.get_int("energy") < 25) return false
        return player.zone.is_within_distance(target, 1800)
    }


    override fun on_use(player: PlayerAPI) {
        val target = player.combat.target
        player.play_animation("cast_instant_arrow")
        player.combat.send_projectile("arrow", 25, this)
        player.vars.decrement_int("energy", 35)
    }


}