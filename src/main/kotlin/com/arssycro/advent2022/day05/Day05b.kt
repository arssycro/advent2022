package com.arssycro.advent2022.day05

import com.arssycro.advent2022.readList

fun main() {
    Day05b().process()
}

class Day05b {
    fun process() {
        val values = readList("/day05.txt")
        val (map, directions) = splitInput(values)
        val stacks = getStacks(map)
        val postStacks = processDirections(stacks, directions) { count, from, to ->
            val items = from.subList(0, count)
            to.addAll(0, items)

            repeat(count) { from.removeAt(0) }
        }
        println(postStacks.joinToString("") { it.firstOrNull().toString() })
    }
}