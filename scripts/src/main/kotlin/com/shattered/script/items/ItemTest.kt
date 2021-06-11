package com.shattered.script.items

import com.shattered.game.actor.`object`.item.Item
import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.ItemUseScript

class ItemTest : ItemUseScript() {

    override fun foritem(): String {
        return "birch logs"
    }

    override fun on_use(player: PlayerAPI, item: Item?, slotId: Int) {
        player.set_widget_param("creation", "trade", "woodworking")
        player.show_widget("creation")
    }

}