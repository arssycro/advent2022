package com.arssycro.advent2022.day07

data class Directory(
    var name: String,
    var parentDirectory: Directory? = null,
    var subdirectories: MutableList<Directory> = mutableListOf(),
    var files: MutableList<File> = mutableListOf()
) {
    fun getSize(): Long {
        val directorySize = subdirectories.sumOf { it.getSize() }
        val fileSize = files.sumOf { it.size }
        return directorySize + fileSize
    }

    override fun toString(): String {
        return "$name - ${getSize()} - $subdirectories - $files"
    }
}

data class File(
    val name: String,
    val size: Long
)

fun process(input: List<String>): Directory {
    val directory = Directory("/")
    var currentDirectory = directory
    input.forEach {
        if (it.startsWith("$")) {
            when (it) {
                "$ cd /" -> currentDirectory = directory
                "$ ls" -> null
                "$ cd .." -> currentDirectory = currentDirectory.parentDirectory!!
                else -> {
                    val directory = it.removePrefix("$ cd ")
                    val subdirectory = currentDirectory.subdirectories.find { d -> d.name == directory }
                    currentDirectory = if (subdirectory == null) {
                        val newDirectory = Directory(directory, currentDirectory)
                        currentDirectory.subdirectories.add(newDirectory)
                        newDirectory
                    } else {
                        subdirectory
                    }
                }
            }
        } else {
            if (it.startsWith("dir")) {
                val directory = it.removePrefix("dir ")
                val subdirectory = currentDirectory.subdirectories.find { d -> d.name == directory }
                if (subdirectory == null) {
                    val newDirectory = Directory(directory, currentDirectory)
                    currentDirectory.subdirectories.add(newDirectory)
                }
            } else {
                val split = it.split(" ")
                val file = File(split[1], split[0].toLong())
                currentDirectory.files.add(file)
            }
        }
    }
    return directory
}

fun getAllDirectories(directory: Directory): List<Directory> {
    val directories = mutableListOf<Directory>()
    directories.addAll(directory.subdirectories)
    directory.subdirectories.forEach { directories.addAll(getAllDirectories(it)) }
    return directories
}