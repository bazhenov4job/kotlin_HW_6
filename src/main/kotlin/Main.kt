
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var noteService = NoteService
    println(noteService.add("Заметка 1", "Текст 1"))
    println(noteService.add("Заметка 2", "Текст 2"))
    println(noteService.getById(1))
    println(noteService.getById(2))
    println(noteService.createComment("1", "отличная заметка!"))
    println(noteService.createComment("1", "так себе заметка!"))
    println( noteService.editComment(2, "не читал, но осуждаю"))
    for (i in 0..1){
        println(noteService.getComments(1, 0, 2)[i])
    }
//    for (i in 0..1){
//        println(noteService.get(arrayOf(1, 2), 0, 2)[i])
//    }
////    println(noteService.getById(3) ?:0)
//    println(noteService.delete("3"))
////    noteService.clear()
//    for (i in 0..1){
//        println(noteService.get(arrayOf(1, 2), 0, 2)[i])
//    }
//    println(noteService.edit("1", "Заметка 1-1", "Отредактированный текст"))
//    for (i in 0..1){
//        println(noteService.get(arrayOf(1, 2), 0, 2)[i])
//    }

}