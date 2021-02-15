package com.shattered.script.abilities.widgets

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.WidgetScript

class CraftingWidget : WidgetScript() {

    override fun forwidget(): String {
        return "creation"
    }

    override fun on_clicked_widget(player: PlayerAPI, parameters: MutableList<Int>?, buttonId: Int) {
        val tradeId = parameters!![0]
        val productId = parameters[1]
        val quantity = parameters[2]
        player.start_action("creation", tradeId, productId, quantity)
    }
}