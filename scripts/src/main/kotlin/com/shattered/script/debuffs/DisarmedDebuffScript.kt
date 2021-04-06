package com.shattered.script.debuffs

import com.shattered.script.types.BuffScript

class DisarmedDebuffScript : BuffScript() {

    override fun name(): String {
        return "disarmed"
    }

    override fun can_apply(): Boolean {
        return true
    }

    override fun on_applied() {
        
    }

    override fun on_tick(): Int {
        return 1
    }

    override fun on_finished() {

    }
}
