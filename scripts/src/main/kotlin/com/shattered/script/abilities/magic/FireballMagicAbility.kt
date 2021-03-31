package com.shattered.script.abilities.magic

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.AbilityScript

class FireballMagicAbility : AbilityScript() {


    override fun name(): String {
        return "fireball"
    }

    override fun can_use(player: PlayerAPI): Boolean {
        val target = player.combat.target ?: return false
        return player.zone.is_within_distance(target, 1800)
    }

    override fun on_cast(player: PlayerAPI) {
        player.play_animation("cast_fireball")
    }

    override fun on_use(player: PlayerAPI) {
        val target = player.combat.target
        player.play_animation("endcast_fireball")
        player.combat.send_projectile("fireball", 60)
        target.add_buff("fire", player, 15)
    }

    override fun can_walk(): Boolean {
        return false
    }


}