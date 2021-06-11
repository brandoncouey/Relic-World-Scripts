package com.shattered.script.trades.fishing

import com.shattered.game.actor.`object`.item.ItemQuality
import com.shattered.game.actor.character.player.component.interaction.InteractionModifier
import com.shattered.script.types.ObjectActionScript

class FishSpotAction : ObjectActionScript() {

    override fun for_object(): String {
        return "fishing spot"
    }

    override fun for_modifier(): InteractionModifier {
        return InteractionModifier.NORMAL
    }

    override fun action_name(): String {
        return "fishing"
    }

    override fun can_start(): Boolean {
        return true
    }

    override fun on_start() {
        player.play_animation("fishing")
        player.channel.send_default_message("You cast your fishing rod out into the water.")
        wait(12)
    }

    override fun on_tick(): Int {
        val fish = "Trout"
        player.containers.acquire_item("Raw $fish", ItemQuality.POOR)
        player.channel.send_default_message("You manage to catch a $fish.")
        player.stop_animation()
        //TODO we have to make it so it increases the experience of the skill
        return -1
    }

    override fun on_finished() {
        player.stop_animation()
    }
}