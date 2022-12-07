package com.arssycro.advent2022.day05

fun splitInput(input: List<String>): Pair<List<String>, List<String>> {
    val index = input.indexOf("")
    return Pair(input.subList(0, index), input.subList(index + 1, input.size))
}

fun getStacks(map: List<String>): List<MutableList<Char>> {
    val totalStacks = map.last().toCharArray().last().digitToInt()
    val stacks = mutableListOf<MutableList<Char>>()
    repeat(totalStacks) { stacks.add(mutableListOf()) }
    map.take(map.size - 1).forEach {
        it.forEachIndexed { index, c ->
            if (c.isLetter()) {
                val stack = (index - 1) / 4
                stacks[stack].add(c)
            }
        }
    }
    return stacks
}

val DIRECTION_REGEX = Regex("move (\\d+) from (\\d+) to (\\d+)")

fun processDirections(
    stacks: List<MutableList<Char>>,
    directions: List<String>,
    move: (Int, MutableList<Char>, MutableList<Char>) -> Unit
): List<MutableList<Char>> {
    val updatedStacks = stacks.toMutableList()
    directions.forEach {
        val (count, start, end) = DIRECTION_REGEX.matchEntire(it)!!.destructured
        val from = updatedStacks[start.toInt() - 1]
        val to = updatedStacks[end.toInt() - 1]
        move(count.toInt(), from, to)
    }
    return updatedStacks
}