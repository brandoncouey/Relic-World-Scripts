package com.shattered.script.trades.herbalism

import com.shattered.game.actor.`object`.item.ItemQuality
import com.shattered.game.actor.character.component.interaction.InteractionModifier
import com.shattered.script.types.ObjectActionScript

class PickLeavesAction : ObjectActionScript() {

    override fun for_objects(): Array<String> {
        return arrayOf("temper bush")
    }

    override fun for_modifier(): InteractionModifier {
        return InteractionModifier.NORMAL
    }

    override fun action_name(): String {
        return "pick leaves"
    }

    override fun can_start(): Boolean {
       return !character.containers.inv_is_full()
    }

    override fun on_start() {
        character.lock()
        character.play_animation("gather")
        character.display_cancel_timer("Picking Leaves", 7)
        character.channel.send_default_message("You begin to pick leaves from the ${obj.name}.")
        wait(7)
    }

    override fun on_tick(): Int {
        val item = "Temper Leaves"
        character.containers.acquire_item(item, ItemQuality.POOR)
        bush_depeleted()
        character.channel.send_default_message("You get some $item.")
        character.stop_animation()
        character.unlock()
        return -1
    }

    fun bush_depeleted() {
        val location = obj.location
        val rotation = obj.rotation
        val id = obj.id
        obj.finish()
        world.spawn_object_delayed(id, location, rotation, 15)
    }

    override fun on_finished() {
        character.stop_animation()
        character.unlock()
    }
}