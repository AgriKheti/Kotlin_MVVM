package fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesdb

import android.content.Context
import androidx.room.*
import androidx.room.RoomDatabase

@Database(
    entities = [Notes::class],
    version = 1
)
abstract class NotesDatabase :RoomDatabase(){

    abstract fun getNoteDao() : NoteDao

    companion object{
       @Volatile private var instance : NotesDatabase?=null
        private val LOCK = Any()

        operator  fun invoke (context: Context)= instance ?: synchronized(LOCK){
//            if instance is null we are calling to build database fun
            instance?: buildDatabase(context).also {
                instance=it
            }
        }

        private fun buildDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            NotesDatabase::class.java,
            "notesDatabase"
        ).build()
    }
}