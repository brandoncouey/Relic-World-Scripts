package com.shattered.script.commands

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.types.CommandScript

class AddItemCommand : CommandScript() {


    override fun on_execute(api: CharacterAPI?, args: Array<out String>?): Boolean {
        val item = args!![1]
        val amount = args[2]
        api?.containers?.inv_add_item(args[1], args[2].toInt())
        return true
    }

    override fun name(): String {
        return "additem"
    }
}