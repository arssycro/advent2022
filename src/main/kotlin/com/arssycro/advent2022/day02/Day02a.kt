package com.arssycro.advent2022.day02

import com.arssycro.advent2022.readList

fun main() {
    Day02a().process()
}

class Day02a {
    fun process() {
        val values = readList("/day02.txt")
        val rounds = getRounds(values)
        println(rounds.sumOf { it.getScore() })
    }


    fun getRounds(input: List<String>): List<Round> =
        input.map {
            val split = it.split(" ")
            Round(Shape.getShape(split[0]), Shape.getShape(split[1]))
        }
}