package com.shattered.script.commands

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.types.CommandScript

class LocationCommand : CommandScript() {

    override fun on_execute(api: CharacterAPI?, args: Array<out String>?): Boolean {
        api?.channel?.send_default_message("Your location is ${api.location().toString()}")
        return true
    }

    override fun name(): String {
        return "mylocation"
    }


}