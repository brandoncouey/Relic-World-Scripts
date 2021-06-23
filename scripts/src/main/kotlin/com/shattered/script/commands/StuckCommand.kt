package com.shattered.script.commands

import com.shattered.game.grid.GridCoordinate
import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.CommandScript

class StuckCommand : CommandScript() {

    override fun on_execute(api: PlayerAPI, args: Array<out String>): Boolean {
        api.zone.teleport(GridCoordinate(121870, 134520, 96))
        return true
    }

    override fun name(): String {
        return "stuck"
    }


}