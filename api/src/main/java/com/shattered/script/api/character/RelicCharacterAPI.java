package com.shattered.script.api.character;

import com.shattered.game.actor.character.Character;
import com.shattered.script.api.impl.character.CharacterChannelAPI;
import lombok.NonNull;

@NonNull
public abstract class RelicCharacterAPI {


    /**
     * Represents the Character referenced for API
     */
    public final Character character;


     public final CharacterChannelAPI channel;

    public  RelicCharacterAPI(Character character) {
        this.character = character;
        this.channel = new CharacterChannelAPI(character);
    }

    /**
     * Gets the Name of the Character
     * @return
     */
    public abstract String getName();


}
