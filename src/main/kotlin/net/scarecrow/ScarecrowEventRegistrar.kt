package net.scarecrow

import net.scarecrow.interfaces.EventRegistrar
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class ScarecrowEventRegistrar(private val plugin: JavaPlugin) : EventRegistrar {
    private val listeners = mutableListOf<Listener>()

    override fun registerEvents() {
        val pluginManager = plugin.server.pluginManager
        listeners.forEach { listener ->
            pluginManager.registerEvents(listener, plugin)
        }
    }

    fun addListener(listener: Listener) {
        listeners.add(listener)
    }
}
