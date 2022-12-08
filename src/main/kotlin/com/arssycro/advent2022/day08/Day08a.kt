package com.arssycro.advent2022.day08

import com.arssycro.advent2022.readList

fun main() {
    Day08a().process()
}

class Day08a {
    fun process() {
        val values = readList("/day08.txt")
        var count = 0
        for (x in 0 until values[0].length) {
            for (y in 0 until values.size) {
                if (isVisible(values, x, y)) {
                    count++
                }
            }
        }
        println(count)
    }

    fun isVisible(values: List<String>, x: Int, y: Int): Boolean {
        if (x == 0 || x == values[y].length - 1 || y == 0 || y == values.size - 1) {
            return true
        }

        val value = values[y][x].digitToInt()

        val left = values[y].substring(0, x).toCharArray().maxOf { it.digitToInt() }
        if (left < value) return true

        val right = values[y].substring(x + 1).toCharArray().maxOf { it.digitToInt() }
        if (right < value) return true

        val up = values.subList(0, y).map { it[x] }.maxOf { it.digitToInt() }
        if (up < value) return true

        val down = values.subList(y + 1, values.size).map { it[x] }.maxOf { it.digitToInt() }
        if (down < value) return true

        return false
    }
}