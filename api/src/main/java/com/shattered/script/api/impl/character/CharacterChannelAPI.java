package com.shattered.script.api.impl.character;

import com.shattered.game.actor.character.Character;
import com.shattered.script.api.character.RelicCharacterChannelAPI;

public class CharacterChannelAPI extends RelicCharacterChannelAPI {


    public CharacterChannelAPI(Character character) {
        super(character);
    }

    /**
     * @param message
     */
    @Override
    public void sendDefaultMessage(String message) {

    }
}
