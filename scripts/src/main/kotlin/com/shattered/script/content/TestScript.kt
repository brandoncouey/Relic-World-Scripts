package com.shattered.script.content

import com.shattered.script.api.impl.character.CharacterAPI
import com.shattered.script.types.CharacterScript

class TestScript : CharacterScript() {


    override fun onWorldAwake(api: CharacterAPI?) {
        println(api?.channel?.sendDefaultMessage("This is from the MS Surface Pro."))
    }
}