package com.shattered.script.api.character;

import com.shattered.game.actor.character.Character;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *
 */
@NonNull
@RequiredArgsConstructor
public abstract class RelicCharacterChannelAPI {

    /**
     * Represents the Character for the Channel API
     */
    @Getter  private final Character character;

    /**
     *
     * @param message
     */
    public abstract void sendDefaultMessage(String message);
}
