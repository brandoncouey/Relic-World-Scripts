package com.shattered.script.trades.crafting

import com.shattered.datatable.tables.ItemUDataTable
import com.shattered.game.actor.`object`.item.Item
import com.shattered.script.types.ActionScript

class CraftingAction() : ActionScript() {

    var tradeId = -1

    var productId = -1

    var quantity = -1

    lateinit var product : ItemUDataTable

    lateinit var materials : List<Item>

    constructor(vararg params: Any?) : this() {
        tradeId = params[0] as Int
        productId = params[1] as Int
        quantity = params[2] as Int
        product = tables.item(productId)
        materials = product.materials!!
    }

    override fun action_name(): String {
        return "creation"
    }


    override fun can_start(): Boolean {
        if (quantity <= 0) return false;
        materials.forEach { n ->
            if (!character.containers.inv_has_item(n.name, n.amount)) {
                character.channel.send_default_message("You need ${n.amount} ${n.name} to craft this item.")
                return false
            }
        }
        return true
    }

    override fun on_start() {
        val product = tables.item(productId)
        character.channel.send_default_message("You begin to craft some ${product.name}")
        val timer = (4 * quantity)
        character.display_cancel_timer("Crafting ${product.name}", timer)
        wait(4)
    }

    override fun on_tick(): Int {

        if (quantity <= 0)
            return -1

        materials.forEach { material ->
            val materialTable = tables.item(material.id)
            if (!materialTable.isTool)
                character.containers.inv_delete_item(material)
        }

        character.vars.increment_int(product.name)
        character.containers.inv_add_item(productId, product.creationAmount)
        character.channel.send_default_message("You craft a ${product.name}")
        quantity--;
        return 4
    }

    override fun on_finished() {
        character.stop_animation()
    }

}