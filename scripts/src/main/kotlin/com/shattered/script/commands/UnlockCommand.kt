package com.shattered.script.commands

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.CommandScript

class UnlockCommand : CommandScript() {

    override fun on_execute(p0: PlayerAPI?, p1: Array<out String>?): Boolean {
        p0?.unlock()
        return true;
    }

    override fun name(): String {
        return "unlock"
    }
}