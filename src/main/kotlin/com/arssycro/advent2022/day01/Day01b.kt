package com.arssycro.advent2022.day01

import com.arssycro.advent2022.readList

fun main() {
    Day01b().process()
}

class Day01b {
    fun process() {
        val values = readList("/day01.txt").map { it.trim() }
        val elves = mutableListOf<Int>()
        var current = 0
        values.forEach {
            if (it.isEmpty()) {
                elves.add(current)
                current = 0
            } else {
                current += it.toInt()
            }
        }
        elves.add(current)

        val total = elves.sortedDescending().take(3).sum()
        println(total)
    }
}