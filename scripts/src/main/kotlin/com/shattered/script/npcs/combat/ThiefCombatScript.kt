package com.shattered.script.npcs.combat

import com.shattered.game.actor.character.components.combat.Hit
import com.shattered.script.api.RelicCharacterAPI
import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.NPCCombatScript

class ThiefCombatScript : NPCCombatScript() {

    override fun fornpc(): String {
        return "thief"
    }

    override fun on_attacked(target: RelicCharacterAPI?, hit: Hit?) {
        super.on_attacked(target, hit)
        if (target is PlayerAPI)
            target.overhead_warning_message(npc, "You will pay!!!")
    }

    override fun on_hit(target: RelicCharacterAPI?, hit: Hit?) {
        super.on_hit(target, hit)
    }

    override fun process() {
        super.process()
        val target = npc.combat.target ?: return
        if (npc.zone.is_within_distance(target, distance)) {
            npc.face_actor(target)
            npc.combat.hit(target, 10)
            npc.play_animation("twohand_longsword_swing_01")
        }
    }

    override fun on_death(source: RelicCharacterAPI?) {
        super.on_death(source)
        if (source is PlayerAPI) {
            source.overhead_warning_message(npc, "How dare you...")
        }
    }




}