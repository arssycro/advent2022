package com.arssycro.advent2022

import kotlin.reflect.KClass

fun readList(file: String) = KClass::class.java.getResource(file)!!.readText().split("\r\n")

fun Collection<*>.printEach() = forEach { println(it) }

fun Array<CharArray>.print() = forEach {
    println(it.joinToString(""))
}

fun Array<BooleanArray>.print() = forEach {
    println(it.joinToString("") { b -> if (b) "#" else "." })
}