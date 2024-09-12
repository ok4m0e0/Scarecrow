package net.scarecrow.events

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityChangeBlockEvent

class PreventTrample : Listener {

    @EventHandler
    fun onEntityChangeBlock(event: EntityChangeBlockEvent){
        if (event.block.type == Material.FARMLAND && event.to == Material.DIRT) {
            event.isCancelled = true
        }
    }
}
