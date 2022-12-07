package com.arssycro.advent2022.day03

import com.arssycro.advent2022.readList

fun main() {
    Day03b().process()
}

class Day03b {
    fun process() {
        val values = readList("/day03.txt")
        val commonElements = values.chunked(3).map {
            val compartment1 = it[0].toCharArray().toList()
            val compartment2 = it[1].toCharArray().toList()
            val compartment3 = it[2].toCharArray().toList()
            compartment1.intersect(compartment2).intersect(compartment3).first()
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