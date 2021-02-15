package com.shattered.script.commands

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.CommandScript

class LocationCommand : CommandScript() {

    override fun on_execute(api: PlayerAPI, args: Array<out String>): Boolean {
        api.channel.send_default_message("Your location is ${api.zone.location.toString()}")
        return true
    }

    override fun name(): String {
        return "loc"
    }


}