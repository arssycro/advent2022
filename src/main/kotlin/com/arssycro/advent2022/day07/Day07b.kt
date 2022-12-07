package com.arssycro.advent2022.day07

import com.arssycro.advent2022.readList

fun main() {
    Day07b().process()
}

class Day07b {
    fun process() {
        val values = readList("/day07.txt")
        val directory = process(values)
        val allDirectories = getAllDirectories(directory) + directory

        val maxSize = 70_000_000
        val neededSize = maxSize - 30_000_000
        val currentSize = directory.getSize()
        val spaceNeeded = currentSize - neededSize

        val bigEnough = allDirectories.filter { it.getSize() >= spaceNeeded }
        println(bigEnough.minOf { it.getSize() })
    }
}