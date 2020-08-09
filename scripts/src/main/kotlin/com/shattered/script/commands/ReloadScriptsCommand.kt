package com.shattered.script.commands

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.types.CommandScript

class ReloadScriptsCommand : CommandScript() {


    /**
     * Gets the Command Name for Execution
     * @return
     */
    override fun name(): String {
        return "reloadscripts"
    }

    override fun on_execute(api: CharacterAPI?, arguments: Array<out String>?): Boolean {
        engine.reload_scripts()
        return true
    }



}