package com.shattered.script.commands

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.CommandScript

class LocalNPCsCommand : CommandScript() {

    override fun name(): String {
        return "localnpcs"
    }

    override fun on_execute(player: PlayerAPI?, p1: Array<out String>?): Boolean {
        player?.zone?.npcs?.forEach { n ->
            player.channel.send_default_message("${n.name} is at ${n.zone.location.toString()}")
        }
        return true
    }
}