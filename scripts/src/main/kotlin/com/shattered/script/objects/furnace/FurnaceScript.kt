package com.shattered.script.objects.furnace

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.api.impl.ObjectAPI
import com.shattered.script.types.ObjectScript

class FurnaceScript : ObjectScript() {

    override fun forobject(): String {
        return "furnace"
    }

    override fun on_normal_interact(player: PlayerAPI?, obj: ObjectAPI?) {
        player?.set_widget_param("creation", "trade", "black_smithing")
        player?.show_widget("creation")
    }

}