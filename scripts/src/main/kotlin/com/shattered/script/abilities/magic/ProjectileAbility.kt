package com.shattered.script.abilities.magic

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.AbilityScript
import kotlin.random.Random

class ProjectileAbility : AbilityScript() {


    override fun name(): String {
        return "frostbolt"
    }

    override fun can_use(player: PlayerAPI): Boolean {
        val target = player.combat.target ?: return false
        return player.zone.is_within_distance(target, 1800)
    }

    override fun on_cast(player: PlayerAPI) : Boolean {
        player.play_animation("cast_fireball")
        return true
    }

    //on_cast

    override fun on_use(player: PlayerAPI) {
        val target = player.combat.target
        player.play_animation("endcast_fireball")
        player.combat.send_projectile("frostbolt", 15)

        val snaredTime = target.combat.snare(6)
        if (snaredTime > 0)
            target.add_buff("snared", player, snaredTime)
    }

}