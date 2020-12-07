package com.shattered.script.objects.furnace

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.api.impl.ObjectAPI
import com.shattered.script.types.ObjectScript

class FurnaceScript : ObjectScript() {

    override fun forobject(): String {
        return "furnace"
    }

    override fun on_normal_interact(character: CharacterAPI?, obj: ObjectAPI?) {
        character?.set_widget_param("creation", "trade", "black_smithing")
        character?.show_widget("creation")
    }

}