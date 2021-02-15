package com.shattered.script.commands

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.CommandScript

class SoundEffectCommand : CommandScript() {


    override fun on_execute(player: PlayerAPI?, args: Array<out String>?): Boolean {
        val name = args!![1]
        player?.play_sfx(name)
        return true
    }

    override fun name(): String {
        return "sfx"
    }
}