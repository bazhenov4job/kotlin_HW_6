
object NoteService {
    var notes = mutableListOf<NoteCrud>()
    var comments = mutableListOf<CommentCrud>()
    var noteId: Int = 0
    var commentId: Int = 0

    fun add(title: String, text: String): Int {
        noteId += 1
        notes.add(NoteCrud(noteId, title, text))
        //TODO("проверка существует ли заметка с таким title?")
        return noteId
    }

    fun createComment(noteId: String, message: String): Int {
        commentId += 1
        comments.add(CommentCrud(commentId, noteId, message))
        //TODO("проверка существует ли заметка с таким id?")
        return commentId
    }

    fun delete(noteId: String): Int {
        for (note in notes) {
            if (noteId.toInt() == note.id) {
                notes.remove(note)
                return 1
            }
        }
        return 0
    }

    fun deleteComment(commentId: Int): Int {
        for ((index, comment) in comments.withIndex()) {
            if (commentId == comment.id) {
                comments[index].isDeleted = true
                return 1
            }
        }
        return 0
    }

    fun edit(noteId: String, title: String, text: String): Int {
        for ((index, note) in notes.withIndex()) {
            if (noteId.toInt() == note.id) {
                notes[index] = note.copy(id = noteId.toInt(), title = title, text = text)
                return 1
            }
        }
        return 0
    }

    fun editComment(commentId: Int, message: String): Int {
        for ((index, comment) in comments.withIndex()) {
            if (commentId == comment.id) {
                comments[index] = comment.copy(message = message)
                return 1
            }
        }
        return 0
    }

    fun get(noteIds: Array<Int>, offset: Int = 0, count: Int = 0): Array<NoteCrud> {
        var notesToGet = arrayOf<NoteCrud>()
        for (i in offset..offset + count - 1){
            for (noteId in noteIds){
                if(notes[i].id == noteId) {
                    notesToGet += notes[i]
                }
            }
        }
        return notesToGet
    }

    fun getById(noteId: Int): NoteCrud? {
        for (note in notes) {
            if (noteId == note.id) {
                return note
            }
        }
        return null
    }

    fun getComments(noteId: Int, offset: Int, count: Int): Array<CommentCrud> {
        var commentsToGetAll = arrayOf<CommentCrud>()
        for ((index, comment) in comments.withIndex()) {
            if (noteId == comment.noteId.toInt()) {
                commentsToGetAll += comment
            }
        }
        var commentsToGet = arrayOf<CommentCrud>()
        for (i in offset..offset + count - 1) {
            commentsToGet += commentsToGetAll[i]
        }
        return commentsToGet
    }

    fun restoreComment(commentId: Int): Int {
        for ((index, comment) in comments.withIndex()) {
            if (commentId == comment.id) {
                comments[index].isDeleted = false
                return 1
            }
        }
        return 0
    }

    fun clear() {
        notes = mutableListOf<NoteCrud>()
        comments = mutableListOf<CommentCrud>()
        noteId = 0
        commentId = 0
    }
}