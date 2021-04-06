package com.shattered.script.debuffs

import com.shattered.script.types.BuffScript

class BleedDebuffScript : BuffScript() {

    override fun name(): String {
        return "bleed"
    }

    override fun can_apply(): Boolean {
        return true
    }

    override fun on_applied() {
        
    }

    override fun on_tick(): Int {
        source!!.combat.hit(character, 2)
        return 2
    }

    override fun on_finished() {

    }
}
