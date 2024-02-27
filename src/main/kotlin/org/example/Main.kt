package org.example

import com.jakewharton.mosaic.runMosaicBlocking
import com.jakewharton.mosaic.ui.Text
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import org.example.game.Game
import org.jline.terminal.TerminalBuilder

fun main() = runMosaicBlocking {
    val game = Game()

    setContent {
        Text(game.batch)
    }

    val terminal = TerminalBuilder.terminal()
    terminal.enterRawMode()
    val reader = terminal.reader()
    withContext(IO) {
        while (true) {
            val symbol = reader.read()
            game.processCommand(symbol)
        }
    }
}
