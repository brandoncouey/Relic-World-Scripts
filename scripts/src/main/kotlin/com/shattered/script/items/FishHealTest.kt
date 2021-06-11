package com.shattered.script.items

import com.shattered.game.actor.`object`.item.Item
import com.shattered.script.api.impl.PlayerAPI
import com.shattered.script.types.ItemUseScript

class FishHealTest : ItemUseScript() {

    override fun foritem(): String {
        return "trout"
    }


    override fun on_use(character: PlayerAPI?, item: Item?, slotId: Int) {
        super.on_use(character, item, slotId)
        character?.containers?.inv_delete_item(item)
        character?.combat?.heal(character, 30)
    }
}