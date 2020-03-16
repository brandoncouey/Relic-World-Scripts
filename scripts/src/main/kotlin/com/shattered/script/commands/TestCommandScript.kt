package com.shattered.script.commands

import com.shattered.script.api.impl.character.CharacterAPI
import com.shattered.script.types.CommandScript

class TestCommandScript : CommandScript() {

    /**
     * Gets the Command Name for Execution
     * @return
     */
    override fun getCommandName(): String {
        return "additem"
    }

    /**
     * Method Called upon executing of the Command
     * @return
     */
    override fun onExecute(api: CharacterAPI?): Boolean {
        TODO("Not yet implemented")
    }


}