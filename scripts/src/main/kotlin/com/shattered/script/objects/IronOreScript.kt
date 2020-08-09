package com.shattered.script.objects

import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.api.impl.ObjectAPI
import com.shattered.script.types.ObjectScript

class IronOreScript : ObjectScript() {

    override fun for_objects(): Array<String> {
        return arrayOf("iron ore", "copper ore")
    }

    override fun on_normal_interact(character: CharacterAPI, obj: ObjectAPI) {
        character.lock()
        character.play_animation("pickaxe_swing_ground")
        character.channel.send_default_message("You swing your pickaxe at the ${obj.name}")
        character.containers.inv_add_item(obj.name)
        character.unlock()
    }

}