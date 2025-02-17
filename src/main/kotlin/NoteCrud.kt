
data class NoteCrud(
    val id: Int = 0,
    val title: String = "",
    val text: String = ""
) : Crud {

    override fun toString(): String {
        return "This is note with Id = $id, title = $title and text = $text"
    }
}