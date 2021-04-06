package com.shattered.script.abilities.archery

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.AbilityScript

class ArcaneShot : AbilityScript() {


    override fun name(): String {
        return "arcane_shot"
    }

    override fun can_use(player: PlayerAPI): Boolean {
        if (!player.containers.equip_hands_contains("bow")) {
            player.channel.send_default_message("You need a bow to use this ability.")
            return false
        }
        val target = player.combat.target ?: return false
        return player.zone.is_within_distance(target, 1800)
    }

    override fun on_cast(player: PlayerAPI) {

    }

    override fun on_use(player: PlayerAPI) {
        val target = player.combat.target
        player.play_animation("cast_instant_arrow")
        player.combat.send_projectile("arrow", 25)
    }


}