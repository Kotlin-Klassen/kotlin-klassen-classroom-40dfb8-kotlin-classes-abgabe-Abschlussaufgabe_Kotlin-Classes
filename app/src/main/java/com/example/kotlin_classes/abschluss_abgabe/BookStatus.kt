package com.example.kotlin_classes.abschluss_abgabe

sealed class BookStatus {
    object Available : BookStatus() {
        override fun toString(): String = "Available"
    }

    data class CheckedOut(val dueDate: String) : BookStatus() {
        override fun toString(): String = "Checked out, due back: $dueDate"
    }

    data class Reserved(val reservedBy: String) : BookStatus() {
        override fun toString(): String = "Reserved by $reservedBy"
    }
}
