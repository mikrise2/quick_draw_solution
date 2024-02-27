package org.example.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.example.Resources
import java.util.*
import kotlin.concurrent.timerTask
import kotlin.system.exitProcess

class Game {

    private val timer = Timer()
    private val tasks = mutableListOf<TimerTask>()

    private var gameState: GameState = GameState.MENU
        set(value) {
            batch = value.text
            field = value
        }

    var batch by mutableStateOf(gameState.text)

    fun processCommand(code: Int) {
        when (gameState) {
            GameState.MENU -> processMenu(code)
            GameState.WAIT -> cancelTasksAndSetGameState(code, GameState.LOSE_TOO_FAST)
            GameState.FIRE -> cancelTasksAndSetGameState(code, GameState.WIN)
            GameState.LOSE_TOO_FAST -> afterGameProcess(code)
            GameState.LOSE_TOO_SLOW -> afterGameProcess(code)
            GameState.WIN -> afterGameProcess(code)
        }
    }

    private fun afterGameProcess(code: Int) {
        when (code) {
            Resources.ESC_CODE -> exitProcess(0)
            Resources.ENTER_CODE -> gameState = GameState.MENU
        }
    }

    private fun cancelTasksAndSetGameState(code: Int, newState: GameState) {
        if (code == Resources.SPACE_CODE) {
            cancelTasks()
            gameState = newState
        }
    }

    private fun processMenu(code: Int) {
        val difficulty = when (code) {
            Resources.CODE_1 -> Difficulty.EASY
            Resources.CODE_2 -> Difficulty.MEDIUM
            Resources.CODE_3 -> Difficulty.HARD
            Resources.CODE_4 -> Difficulty.HARDER
            Resources.ESC_CODE -> exitProcess(0)
            else -> return
        }
        playGame(difficulty)
    }

    private fun playGame(difficulty: Difficulty) {
        gameState = GameState.WAIT
        val waitTime = (Resources.WAIT_MIN..Resources.WAIT_MAX).random()
        val fireTask = timerTask {
            gameState = GameState.FIRE
            fire(difficulty)
        }
        tasks.add(fireTask)
        timer.schedule(fireTask, waitTime)
    }

    private fun fire(difficulty: Difficulty) {
        val tooSlowTask = timerTask {
            gameState = GameState.LOSE_TOO_SLOW
        }
        tasks.add(tooSlowTask)
        timer.schedule(tooSlowTask, difficulty.milliseconds)
    }

    private fun cancelTasks() {
        tasks.forEach { it.cancel() }
    }
}
