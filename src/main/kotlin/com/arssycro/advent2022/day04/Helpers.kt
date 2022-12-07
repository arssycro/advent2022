package com.arssycro.advent2022.day04

fun getRanges(input: List<String>): List<Pair<IntRange, IntRange>> =
    input.map {
        val split = it.split(",", "-")
        Pair(split[0].toInt()..split[1].toInt(), split[2].toInt()..split[3].toInt())
    }