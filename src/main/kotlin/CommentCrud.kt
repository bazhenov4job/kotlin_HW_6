package ru.netology

data class CommentCrud(
    val id: Int = 0,
    val noteId: String = "",
    val message: String = ""
) : Crud {

    var isDeleted: Boolean = false
}