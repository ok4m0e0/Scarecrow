package net.scarecrow.interfaces

import org.bukkit.command.Command
import org.bukkit.command.CommandSender

// Interface for event registration
interface EventRegistrar {
    fun registerEvents()
}

// Interface for base command
interface BaseCommand {
    /**
     * The name of the command.
     */
    val name: String

    /**
     * Executes the command.
     *
     * @param sender The command sender.
     * @param command The command being executed.
     * @param label The alias of the command used
     * @param args The arguments passed to the command.
     */
    fun execute(sender: CommandSender, command: Command, label: String, args: Array<out String>) : Boolean
}

// Interface for sub command
interface SubCommand {
    /**
     * The name of the subCommand
     */
    val name: String

    /**
     * A brief description of the subCommand
     */
    val description: String

    /**
     * Executes the subCommand
     *
     * @param sender The command sender
     * @param command The command being executed
     * @param label The alias of the command used
     * @param args The arguments passed to the command
     */
    fun execute(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean
}
