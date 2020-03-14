package com.shattered.content

import com.shattered.script.Script
import com.shattered.script.api.CharacterAPI


class RandomLooterScript : Script() {

    override fun onAwake(api: CharacterAPI?) {
        println("Oh fuck yes this is working.")
    }
}