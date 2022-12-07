package com.arssycro.advent2022.day02

enum class Shape(val points: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    companion object {
        fun getShape(input: String): Shape =
            when (input) {
                "A", "X" -> Shape.ROCK
                "B", "Y" -> Shape.PAPER
                "C", "Z" -> Shape.SCISSORS
                else -> TODO()
            }
    }
}

data class Round(
    val opponent: Shape,
    val self: Shape
) {
    fun getScore(): Int {
        val gameScore =
            when (opponent) {
                Shape.ROCK ->
                    when (self) {
                        Shape.ROCK -> 3
                        Shape.PAPER -> 6
                        Shape.SCISSORS -> 0
                    }
                Shape.PAPER ->
                    when (self) {
                        Shape.ROCK -> 0
                        Shape.PAPER -> 3
                        Shape.SCISSORS -> 6
                    }
                Shape.SCISSORS ->
                    when (self) {
                        Shape.ROCK -> 6
                        Shape.PAPER -> 0
                        Shape.SCISSORS -> 3
                    }
            }
        return self.points + gameScore
    }
}