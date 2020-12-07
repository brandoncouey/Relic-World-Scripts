package com.shattered.script.items

import com.shattered.game.actor.`object`.item.Item
import com.shattered.script.api.impl.CharacterAPI
import com.shattered.script.types.ItemUseScript

class ItemTest : ItemUseScript() {

    override fun foritem(): String {
        return "deer pelt"
    }

    override fun on_use(character: CharacterAPI, item: Item?, slotId: Int) {
        character.set_widget_param("creation", "trade", "leather_working")
        character.show_widget("creation")
    }

}