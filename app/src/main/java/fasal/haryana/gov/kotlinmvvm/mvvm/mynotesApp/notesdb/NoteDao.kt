package fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NoteDao {

    /*here we will define function to transaction in database*/

    @Insert
    fun addNote(note:Notes)

    @Query("SELECT * FROM notes")
     fun getAllnotes() : List<Notes>
}