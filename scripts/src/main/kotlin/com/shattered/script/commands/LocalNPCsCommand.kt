package com.shattered.script.commands

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.types.CommandScript

class LocalNPCsCommand : CommandScript() {

    override fun name(): String {
        return "localnpcs"
    }

    override fun on_execute(character: CharacterAPI?, p1: Array<out String>?): Boolean {
        character?.zone?.npCs?.forEach { n ->
            character.channel.send_default_message("${n._name} is at ${n.zone.location.toString()}")
        }
        return true
    }
}