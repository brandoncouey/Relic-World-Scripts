package com.shattered.script.trades.mining

import com.shattered.game.actor.character.component.interaction.InteractionModifier
import com.shattered.script.types.ObjectActionScript
import kotlin.random.Random


class MiningAction : ObjectActionScript() {


    override fun for_objects(): Array<String> {
        return arrayOf("iron ore")
    }

    override fun for_modifier(): InteractionModifier {
        return InteractionModifier.NORMAL
    }

    override fun action_name(): String {
       return "mining"
    }

    override fun can_start(): Boolean {
        if (!character.containers.equip_hands_contains("pickaxe")) {
            character.notify_required("You need a pickaxe to mine that!")
            return false;
        }
       return true
    }

    override fun on_start() {
        character.lock()
        character.display_cancel_timer("Mining", 30)
        character.play_animation("Swing Pickaxe Ground")
        character.channel.send_default_message("You begin to mine the ${obj.name}")
    }

    override fun on_tick(): Int {


        val chance = Random.nextInt(3)

        if (chance == 2) {
            character.containers.acquire_item(obj.name)
            character.channel.send_default_message("You successfully mine some ${obj.name}")
            return -1//stops the process
        }

        return 4
    }

    override fun on_finished() {
        character.unlock()
        character.stop_animation()
    }



}