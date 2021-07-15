package com.shattered.script.abilities.archery

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.AbilityScript

class FocusShotArcherAbility : AbilityScript() {


    override fun name(): String {
        return "steady_aim"
    }

    override fun can_use(player: PlayerAPI): Boolean {
        if (!player.containers.equip_hands_contains("bow")) {
            player.channel.send_default_message("You need a bow to use this ability.")
            return false
        }
       return true
    }

    override fun on_cast(player: PlayerAPI) : Boolean {
        player.play_animation("cast_aim_arrow")
        return true
    }

    override fun on_use(player: PlayerAPI) {
        val target = player.combat.target

        if (player.zone.is_within_distance(target, 1800)) {
            player.play_animation("cast_fire_arrow")
            player.combat.send_projectile("arrow", 60, this)
            player.vars.increment_int("energy", 15)
        } else
            player.top_warning_message("You are too far away.")
    }

}