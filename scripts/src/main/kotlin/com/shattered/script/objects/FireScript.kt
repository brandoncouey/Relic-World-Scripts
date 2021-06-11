package com.shattered.script.objects

import com.shattered.script.api.impl.ObjectAPI
import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.ObjectScript

class FireScript : ObjectScript() {

    override fun forobject(): String {
        return "fire"
    }


    override fun on_normal_interact(character: PlayerAPI?, obj: ObjectAPI?) {
        super.on_normal_interact(character, obj)
        character?.set_widget_param("creation", "trade", "cooking")
        character?.show_widget("creation")
    }
}