
data class CommentCrud(
    val id: Int = 0,
    val noteId: String = "",
    val message: String = ""
) : Crud {

    var isDeleted: Boolean = false

    override fun toString(): String {
        return "This is comment with Id = $id, noteId = $noteId and message = $message"
    }
}