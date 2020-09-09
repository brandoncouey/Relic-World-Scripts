package com.shattered.script.commands

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.types.CommandScript

class SoundEffectCommand : CommandScript() {


    override fun on_execute(character: CharacterAPI?, args: Array<out String>?): Boolean {
        val name = args!![1]
        character?.play_sfx(name)
        return true
    }

    override fun name(): String {
        return "sfx"
    }
}