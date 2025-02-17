import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Before
    fun setUp() {
        NoteService.clear()
    }

    @Test
    fun add() {
        val result = NoteService.add("Заметка 1", "Текст 1")
        NoteService.add("Заметка 2", "Текст 2")
        NoteService.add("Заметка 3", "Текст 3")
        assertEquals(1, result)
    }

    @Test
    fun createComment() {
        val result = NoteService.createComment("1", "отличная заметка!")
        assertEquals(1, result)
    }

    @Test
    fun deleteIdFound() {
        NoteService.add("Заметка 1", "Текст 1")
        NoteService.add("Заметка 2", "Текст 2")
        NoteService.add("Заметка 3", "Текст 3")
        val result = NoteService.delete("2")
        assertEquals(1, result)
    }

    @Test
    fun deleteIdNotFound() {
        NoteService.add("Заметка 1", "Текст 1")
        NoteService.add("Заметка 2", "Текст 2")
        NoteService.add("Заметка 3", "Текст 3")
        val result = NoteService.delete("4")
        assertEquals(0, result)
    }

    @Test
    fun deleteCommentFound() {
        NoteService.add("Заметка 1", "Текст 1")
        NoteService.createComment("1", "отличная заметка!")
        val result = NoteService.deleteComment(1)
        assertEquals(1, result)
    }

    @Test
    fun deleteCommentNotFound() {
        NoteService.add("Заметка 1", "Текст 1")
        NoteService.createComment("1", "отличная заметка!")
        val result = NoteService.deleteComment(2)
        assertEquals(0, result)
    }

    @Test
    fun edit() {
        NoteService.add("Заметка 1", "Текст 1")
        val result = NoteService.edit("1", "Заметка 1-1", "Отредактированный текст")
        assertEquals(1, result)
    }

    @Test
    fun editComment() {
        NoteService.add("Заметка 1", "Текст 1")
        NoteService.createComment("1", "отличная заметка!")
        val result = NoteService.editComment(1, "не читал, но осуждаю")
        assertEquals(1, result)
    }

    @Test
    fun get() {
        NoteService.add("Заметка 1", "Текст 1")
        NoteService.add("Заметка 2", "Текст 2")
        NoteService.add("Заметка 3", "Текст 3")
        val notes = NoteService.get(arrayOf(1, 2, 3), 1, 2)
        val expected = arrayOf(
            NoteCrud(2, "Заметка 2", "Текст 2"),
            NoteCrud(3, "Заметка 3", "Текст 3")
        )
        //вот тут вот страшно, конечно, но ничего не поделать
        assertEquals(expected, notes)
    }

    @Test (expected = IndexOutOfBoundsException::class)
    fun getException() {
        NoteService.add("Заметка 1", "Текст 1")
        NoteService.add("Заметка 2", "Текст 2")
        NoteService.add("Заметка 3", "Текст 3")
        val notes = NoteService.get(arrayOf(1, 2, 3, 4), 2, 2)
        val expected = arrayOf(
            NoteCrud(2, "Заметка 2", "Текст 2"),
            NoteCrud(3, "Заметка 3", "Текст 3")
        )
    }

    @Test
    fun getById() {
        NoteService.add("Заметка 1", "Текст 1")
        val result = NoteService.getById(1)
        val expected = NoteCrud(
            1, "Заметка 1", "Текст 1"
        )
        assertEquals(expected, result)
    }

    @Test
    fun getComments() {
        NoteService.add("Заметка 1", "Текст 1")
        NoteService.createComment("1", "отличная заметка!")
        NoteService.createComment("1", "приличная заметка!")
        NoteService.createComment("1", "отличная отметка!")
        val notes = NoteService.getComments(1, 1, 2)
        val expected = arrayOf(
            CommentCrud(2, "1", "приличная заметка!"),
            CommentCrud(3, "1", "отличная отметка!")
        )
        //вот тут вот страшно, конечно, но ничего не поделать
        assertEquals(expected, notes)
    }

    @Test
    fun restoreComment() {
        NoteService.add("Заметка 1", "Текст 1")
        NoteService.createComment("1", "отличная заметка!")
        NoteService.deleteComment(1)
        val result = NoteService.restoreComment(1)
        assertEquals(1, result)
    }
}