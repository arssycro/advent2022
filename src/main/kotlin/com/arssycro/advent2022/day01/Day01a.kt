package com.arssycro.advent2022.day01

import com.arssycro.advent2022.readList
import kotlin.math.max

fun main() {
    Day01a().process()
}

class Day01a {
    fun process() {
        val values = readList("/day01.txt").map { it.trim() }
        var max = 0
        var current = 0
        values.forEach {
            if (it.isEmpty()) {
                max = max(max, current)
                current = 0
            } else {
                current += it.toInt()
            }
        }
        max = max(max, current)

        println(max)
    }
}