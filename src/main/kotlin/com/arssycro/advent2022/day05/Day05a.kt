package com.arssycro.advent2022.day05

import com.arssycro.advent2022.readList

fun main() {
    Day05a().process()
}

class Day05a {
    fun process() {
        val values = readList("/day05.txt")
        val (map, directions) = splitInput(values)
        val stacks = getStacks(map)
        val postStacks = processDirections(stacks, directions) { count, from, to ->
            for (x in 1..count) {
                val item = from.firstOrNull() ?: break
                from.remove(item)
                to.add(0, item)
            }
        }
        println(postStacks.joinToString("") { it.first().toString() })
    }
}