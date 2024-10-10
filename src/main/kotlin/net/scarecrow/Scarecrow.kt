package net.scarecrow

import net.scarecrow.commands.ScarecrowCommand
import net.scarecrow.commands.SubCommandRegistrar
import net.scarecrow.commands.version.VersionSubCommand
import net.scarecrow.events.PreventTrample
import net.scarecrow.interfaces.BaseCommand
import org.bukkit.plugin.java.JavaPlugin

class Scarecrow : JavaPlugin() {
    private lateinit var eventRegistrar: ScarecrowEventRegistrar
    private lateinit var commandRegistrar: ScarecrowCommandRegistrar
    private lateinit var subCommandRegistrar: SubCommandRegistrar
    private lateinit var scarecrowCommand: BaseCommand

    override fun onEnable() {
        // Initialization of Registrar
        eventRegistrar = ScarecrowEventRegistrar(this)
        commandRegistrar = ScarecrowCommandRegistrar(this)
        subCommandRegistrar = SubCommandRegistrar()


        // Initialization of Command
        scarecrowCommand = ScarecrowCommand(subCommandRegistrar)


        // Add List
        commandRegistrar.addCommand(scarecrowCommand)
        subCommandRegistrar.addSubCommand(VersionSubCommand(this))
        eventRegistrar.addListener(PreventTrample())


        // Register
        commandRegistrar.registerCommand()
        subCommandRegistrar.registerSubCommand()
        eventRegistrar.registerEvents()
    }

    override fun onDisable() {}
}
