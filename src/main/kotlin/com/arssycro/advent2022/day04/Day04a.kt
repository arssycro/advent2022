package com.arssycro.advent2022.day04

import com.arssycro.advent2022.readList

fun main() {
    Day04a().process()
}

class Day04a {
    fun process() {
        val values = readList("/day04.txt")
        val ranges = getRanges(values)
        val fullyOverlapped = ranges.filter { it.first.contains(it.second) || it.second.contains(it.first) }
        println(fullyOverlapped.size)
    }
    
    fun IntRange.contains(range: IntRange): Boolean = this.contains(range.first) && this.contains(range.last)
}