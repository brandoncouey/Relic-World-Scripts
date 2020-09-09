package com.shattered.script.commands

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.types.CommandScript

class LocalPlayers : CommandScript() {

    override fun name(): String {
        return "localplayers"
    }

    override fun on_execute(character: CharacterAPI?, args: Array<out String>?): Boolean {
        character?.zone?.characters?.forEach { n ->
            character.channel.send_default_message("${n.get_name()} is at ${n.zone.location.toString()}")
        }
        return true
    }
}