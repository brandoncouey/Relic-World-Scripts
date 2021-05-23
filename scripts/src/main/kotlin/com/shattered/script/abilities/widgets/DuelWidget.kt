package com.shattered.script.abilities.widgets

import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.WidgetScript

class DuelWidget : WidgetScript() {

    override fun forwidget(): String {
        return "duel"
    }

    override fun on_clicked_widget(player: PlayerAPI, parameters: MutableList<Int>?, buttonId: Int) {
        //Accept
        if (buttonId == 0) {
            val tuuid = player.vars.get_tint("dueled_puuid")
            player.zone.players.forEach { pl -> {
                if (pl.index == tuuid) {
                    //TODO start duel
                    player.vars.set_tbool("dueling", true)
                    pl.vars.set_tbool("dueling", true)
                }
            } }
            //Decline
        } else if (buttonId == 1) {
            player.vars.set_tint("dueled_puuid", 0)
            player.channel.send_default_message("Duel declined.")
        }
    }
}