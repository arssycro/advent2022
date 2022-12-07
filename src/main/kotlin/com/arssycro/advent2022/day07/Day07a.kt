package com.arssycro.advent2022.day07

import com.arssycro.advent2022.readList

fun main() {
    Day07a().process()
}

class Day07a {
    fun process() {
        val values = readList("/day07.txt")
        val directory = process(values)
        val allDirectories = getAllDirectories(directory) + directory
        
        val maxSize = 100_000
        val underSize = allDirectories.filter { it.getSize() <= maxSize }
        println(underSize.sumOf { it.getSize() })
    }
}