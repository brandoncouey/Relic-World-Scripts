package com.shattered.script.trades.lumberjack

import com.shattered.game.actor.`object`.component.transform.Rotation
import com.shattered.game.actor.`object`.item.ItemQuality
import com.shattered.game.actor.character.component.interaction.InteractionModifier
import com.shattered.script.types.ObjectActionScript

class TreeCuttingAction : ObjectActionScript() {

    override fun for_modifier(): InteractionModifier {
        return InteractionModifier.NORMAL
    }

    override fun for_objects(): Array<String> {
        return arrayOf("normal tree")
    }

    override fun can_start(): Boolean {
        if (!character.containers.equip_hands_contains("axe") &&
            !character.containers.equip_hands_contains("pickaxe")) {
            character.notify_required("You need an axe to cut down this tree.")
            return false
        }
        return true;
    }


    override fun on_start() {
        character.lock()
        character.play_animation("chop tree")
        character.display_cancel_timer("Chopping", 7)
        character.channel.send_default_message("You begin to swing your axe at the ${obj.name}")
        wait(7)

    }

    override fun on_tick(): Int {
        val item = "Normal Logs"
        character.containers.acquire_item(item, ItemQuality.POOR)
        tree_finished()
        character.channel.send_default_message("You get some $item.")
        character.stop_animation()
        character.unlock()
        //TODO we have to make it so it increases the experience of the skill
        //character.trade_increase_mat("item")
        return -1
    }

    fun tree_finished() {
        val location = obj.location
        val rotation = obj.rotation
        val id = obj.id//We have to spawn an id because theres multiple types of trees.
        obj.finish()
        world.spawn_object_then_replace("tree stump", location, rotation, 15, id)
    }

    override fun on_finished() {
        character.stop_animation()
        character.unlock()
    }
}