package fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesdb

import androidx.room.*


@Dao
interface NoteDao {

    /*here we will define function to transaction in database*/

    @Insert
    suspend fun addNote(note:Notes)

//    @Query("SELECT * FROM notes")
//    suspend fun getAllnotes() : List<Notes>

    /*to get the latest note at the top*/
    @Query("SELECT * FROM notes ORDER BY id DESC")
    suspend fun getAllnotes() : List<Notes>


    /*to update the data*/
    @Update
    suspend fun updateNote(note: Notes)

    @Delete
    suspend fun deleteNote(note: Notes)
}