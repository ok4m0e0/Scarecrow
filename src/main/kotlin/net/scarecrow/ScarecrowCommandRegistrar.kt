package net.scarecrow

import net.scarecrow.interfaces.BaseCommand
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class ScarecrowCommandRegistrar(private val plugin: JavaPlugin) {
    private val commands = mutableSetOf<Pair<String, BaseCommand>>()

    fun addCommand(command: BaseCommand) {
        commands.add(Pair(command.name.lowercase(Locale.getDefault()), command))
    }

    fun registerCommand() {
        commands.forEach { (name, handler) ->
            plugin.getCommand(name)?.setExecutor { sender, command, label, args ->
                handler.execute(sender, command, label, args)
            }
        }
    }
}
