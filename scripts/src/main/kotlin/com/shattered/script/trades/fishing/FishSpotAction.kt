package com.shattered.script.trades.fishing

import com.shattered.game.actor.`object`.item.ItemQuality
import com.shattered.game.actor.character.component.interaction.InteractionModifier
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
        character.lock()
        character.play_animation("fishing")
        character.channel.send_default_message("You cast your fishing reel out into the water.")
        wait(12)
    }

    override fun on_tick(): Int {
        val fish = "Trout"
        character.containers.acquire_item("Uncooked $fish", ItemQuality.POOR)
        character.channel.send_default_message("You manage to catch a $fish.")
        character.stop_animation()
        character.unlock()
        //TODO we have to make it so it increases the experience of the skill
        return -1
    }

    override fun on_finished() {
        character.stop_animation()
        character.unlock()
    }
}