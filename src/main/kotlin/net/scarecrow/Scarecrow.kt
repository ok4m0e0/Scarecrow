package net.scarecrow

import net.scarecrow.events.PreventTrample
import org.bukkit.plugin.java.JavaPlugin

class Scarecrow : JavaPlugin() {
    private lateinit var eventRegistrar: ScarecrowEventRegistrar

    override fun onEnable() {
        eventRegistrar = ScarecrowEventRegistrar(this)

        eventRegistrar.addListener(PreventTrample())

        eventRegistrar.registerEvents()
    }

    override fun onDisable() {
    }
}
