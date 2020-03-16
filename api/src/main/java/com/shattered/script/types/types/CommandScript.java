package com.shattered.script.types.types;

import com.shattered.script.api.impl.character.CharacterAPI;

public abstract class CommandScript {

    /**
     * Gets the Command Name for Execution
     * @return
     */
    public abstract String getCommandName();

    /**
     * Method Called upon executing of the Command
     * @return
     */
    public abstract boolean onExecute(CharacterAPI api);

}
