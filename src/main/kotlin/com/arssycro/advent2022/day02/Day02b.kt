package com.arssycro.advent2022.day02

import com.arssycro.advent2022.readList

fun main() {
    Day02b().process()
}

class Day02b {
    fun process() {
        val values = readList("/day02.txt")
        val rounds = getRounds(values)
        println(rounds.sumOf { it.getScore() })
    }

    fun getRounds(input: List<String>): List<Round> =
        input.map {
            val split = it.split(" ")
            val opponent = Shape.getShape(split[0])
            val self = when (split[1]) {
                "X" -> when (opponent) {
                    Shape.ROCK -> Shape.SCISSORS
                    Shape.PAPER -> Shape.ROCK
                    Shape.SCISSORS -> Shape.PAPER
                }
                "Y" -> opponent
                "Z" -> when (opponent) {
                    Shape.ROCK -> Shape.PAPER
                    Shape.PAPER -> Shape.SCISSORS
                    Shape.SCISSORS -> Shape.ROCK
                }
                else -> TODO()
            }
            Round(opponent, self)
        }
}