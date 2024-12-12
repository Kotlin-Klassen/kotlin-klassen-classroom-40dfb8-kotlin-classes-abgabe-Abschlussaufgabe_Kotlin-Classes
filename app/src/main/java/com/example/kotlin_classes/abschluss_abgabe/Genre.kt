package com.example.kotlin_classes.abschluss_abgabe

enum class Genre(val description: String) {
    FICTION("Fiction is the telling of stories which are not real."),
    NON_FICTION("Non-fiction is the telling of stories which are real."),
    SCIENCE("Science is the study of the natural world."),
    HISTORY("History is the study of the past."),
    CHILDREN("Children's books are books for children."),;
    fun printDescription() {
        println(description)
    }
}