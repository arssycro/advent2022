package com.arssycro.advent2022.day08

import com.arssycro.advent2022.readList
import kotlin.math.max

fun main() {
    Day08b().process()
}

class Day08b {
    fun process() {
        val values = readList("/day08.txt")
        var score = 0L
        for (x in 0 until values[0].length) {
            for (y in 0 until values.size) {
                score = max(score, getScenicScore(values, x, y))
            }
        }
        println(score)
    }

    fun getScenicScore(values: List<String>, x: Int, y: Int): Long {
        val value = values[y][x].digitToInt()

        var score = 1L
        score *= getScore(value, values[y].substring(0, x).reversed().toCharArray())
        score *= getScore(value, values[y].substring(x + 1).toCharArray())
        score *= getScore(value, values.subList(0, y).map { it[x] }.reversed().toCharArray())
        score *= getScore(value, values.subList(y + 1, values.size).map { it[x] }.toCharArray())
        return score
    }

    fun getScore(value: Int, trees: CharArray): Int {
        if (trees.isEmpty()) {
            return 0
        }

        var current = 0
        for (tree in trees.map { it.digitToInt() }) {
            current++
            if (tree >= value) {
                break
            }
        }
        return current
    }
}