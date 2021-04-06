package com.shattered.script.debuffs

import com.shattered.script.types.BuffScript

class FireDebuffScript : BuffScript() {

    override fun name(): String {
        return "fire"
    }

    override fun can_apply(): Boolean {
        return true
    }

    override fun on_applied() {
        
    }

    override fun on_tick(): Int {
        source!!.combat.hit(character, 5)
        return 2
    }

    override fun on_finished() {

    }
}
