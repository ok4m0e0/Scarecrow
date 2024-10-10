package net.scarecrow.commands.version

import net.scarecrow.interfaces.SubCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class VersionSubCommand(private val plugin: JavaPlugin) : SubCommand {
    override val name = "version"
    override val description = "Command to get plugin version"

    override fun execute(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        sender.sendMessage("Version: ${plugin.description.version}")
        return true
    }
}
