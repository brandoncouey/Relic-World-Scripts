package com.shattered.script.objects

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.api.impl.ObjectAPI
import com.shattered.script.types.ObjectScript

class SwordBarrellScript : ObjectScript() {

    override fun forobject(): String {
        return "sword barrell"
    }

    override fun on_normal_interact(character: CharacterAPI?, obj: ObjectAPI?) {
        character?.channel?.send_default_message("What the fuck are you doing?")
    }

}