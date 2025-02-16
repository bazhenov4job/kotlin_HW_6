package ru.netology

data class NoteCrud(
    val id: Int = 0,
    val title: String = "",
    val text: String = ""
) : Crud