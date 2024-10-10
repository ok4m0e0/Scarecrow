package net.scarecrow.commands

import net.scarecrow.interfaces.SubCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList

class SubCommandRegistrar {
    private val commands = ConcurrentHashMap<String, SubCommand>()
    private val subCommands = CopyOnWriteArrayList<SubCommand>()

    /**
     * Adds a subcommand to the list of subcommands to be registered.
     *
     * @param subCommand The subcommand to add
     */
    fun addSubCommand(subCommand: SubCommand) {
        subCommands.add(subCommand)
    }

    /**
     * Registers a new subcommand.
     *
     * @param subCommands The sub command to register
     */
    fun registerSubCommand() {
        for (subCommand in subCommands) {
            commands[subCommand.name.lowercase(Locale.getDefault())] = subCommand
        }
    }

    /**
     * Executes the appropriate subcommand based on user input.
     *
     * @return true if a subcommand was found and executed, false otherwise
     */
    fun executeSubCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (args.isEmpty()) {
            sender.sendMessage("Usage: /$label <subCommand> [args]")
            return false
        }

        val subCommandName = args[0].lowercase(Locale.getDefault())
        val subCommand = commands[subCommandName]

        return if(subCommand != null) {
            subCommand.execute(sender, command, label, args.drop(1).toTypedArray())
        } else {
            sender.sendMessage("Unknown SubCommand: $subCommandName")
            sender.sendMessage("Available SubCommands: ${commands.keys.joinToString(", ")}")
            false
        }
    }

    /**
     * Returns a list of all registered subcommands.
     */
    fun getRegisteredSubCommands(): List<SubCommand> = commands.values.toList()
}
