package com.shattered.script.commands

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.CommandScript

class LocalPlayers : CommandScript() {

    override fun name(): String {
        return "localplayers"
    }

    override fun on_execute(player: PlayerAPI?, args: Array<out String>?): Boolean {
        player?.zone?.players?.forEach { n ->
            player.channel.send_default_message("${n.name} is at ${n.zone.location.toString()}")
        }
        return true
    }
}