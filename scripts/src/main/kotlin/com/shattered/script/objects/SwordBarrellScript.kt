package com.shattered.script.objects

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.api.impl.ObjectAPI
import com.shattered.script.types.ObjectScript

class SwordBarrellScript : ObjectScript() {

    override fun forobject(): String {
        return "sword barrell"
    }

    override fun on_normal_interact(player: PlayerAPI?, obj: ObjectAPI?) {
        player?.channel?.send_default_message("What the fuck are you doing?")
    }

}