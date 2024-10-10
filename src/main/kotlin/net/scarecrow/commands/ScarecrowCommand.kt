package net.scarecrow.commands

import net.scarecrow.interfaces.BaseCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class ScarecrowCommand(
    private val subCommandRegistrar: SubCommandRegistrar
) : BaseCommand {
    override val name = "scarecrow"

    override fun execute(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        return subCommandRegistrar.executeSubCommand(sender, command, label, args)
    }
}