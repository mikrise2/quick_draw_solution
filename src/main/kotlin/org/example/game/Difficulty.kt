package org.example.game

enum class Difficulty(val milliseconds: Long){
    EASY(1000),
    MEDIUM(500),
    HARD(250),
    HARDER(125)
}