package com.shattered.script.trades.lumberjack

import com.shattered.game.actor.`object`.item.ItemQuality
import com.shattered.game.actor.character.player.component.interaction.InteractionModifier
import com.shattered.script.types.ObjectActionScript

class TreeCuttingAction : ObjectActionScript() {

    override fun for_modifier(): InteractionModifier {
        return InteractionModifier.NORMAL
    }

    override fun for_objects(): Array<String> {
        return arrayOf("normal tree")
    }

    override fun action_name(): String {
        return "tree cutting"
    }

    override fun can_start(): Boolean {
        if (!player.containers.equip_hands_contains("axe") &&
            !player.containers.equip_hands_contains("pickaxe")) {
            player.notify_required("You need an axe to cut down this tree.")
            return false
        }
        return true;
    }


    override fun on_start() {
        player.lock()
        player.play_animation("chop tree")
        player.display_cancel_timer("Chopping", 7)
        player.channel.send_default_message("You begin to swing your axe at the ${obj.name}.")
        wait(7)
    }

    override fun on_tick(): Int {
        val item = "Normal Logs"
        player.containers.acquire_item(item, ItemQuality.POOR)
        tree_finished()
        player.channel.send_default_message("You get some $item.")
        player.stop_animation()
        player.unlock()
        //TODO we have to make it so it increases the experience of the skill
        //player.trade_increase_mat("item")
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
        player.stop_animation()
        player.unlock()
    }
}