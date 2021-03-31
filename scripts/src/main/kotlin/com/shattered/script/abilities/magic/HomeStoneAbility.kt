package com.shattered.script.abilities.magic

import com.shattered.game.grid.GridCoordinate
import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.api.impl.NpcAPI
import com.shattered.script.types.AbilityScript

class HomeStoneAbility : AbilityScript() {


    override fun name(): String {
        return "home_stone"
    }

    override fun can_use(player: PlayerAPI): Boolean {
        return true
    }

    override fun on_cast(p0: PlayerAPI?) {
        TODO("Not yet implemented")
    }

    override fun on_use(player: PlayerAPI) {
        world.spawn_npc("rejuv", selectedCoordinate)
       // player.zone.teleport(selectedCoordinate)
    }


}