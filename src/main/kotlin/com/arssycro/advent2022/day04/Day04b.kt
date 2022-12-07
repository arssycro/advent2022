package com.arssycro.advent2022.day04

import com.arssycro.advent2022.readList

fun main() {
    Day04b().process()
}

class Day04b {
    fun process() {
        val values = readList("/day04.txt")
        val ranges = getRanges(values)
        val fullyOverlapped = ranges.filter { it.first.overlaps(it.second) || it.second.overlaps(it.first) }
        println(fullyOverlapped.size)
    }

    fun IntRange.overlaps(range: IntRange): Boolean = this.contains(range.first) || this.contains(range.last)
}