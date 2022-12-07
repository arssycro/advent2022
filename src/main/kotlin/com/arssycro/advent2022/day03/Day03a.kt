package com.arssycro.advent2022.day03

import com.arssycro.advent2022.readList

fun main() {
    Day03a().process()
}

class Day03a {
    fun process() {
        val values = readList("/day03.txt")
        val commonElements = values.map {
            val middle = it.length / 2
            val compartment1 = it.substring(0, middle).toCharArray().toList()
            val compartment2 = it.substring(middle).toCharArray().toList()
            compartment1.intersect(compartment2).first()
        }
        val total = commonElements.sumOf {
            if (it.isUpperCase()) {
                it - 'A' + 27
            } else {
                it - 'a' + 1
            }
        }
        println(total)
    }
}