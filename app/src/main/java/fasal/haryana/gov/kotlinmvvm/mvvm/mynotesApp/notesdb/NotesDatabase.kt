package fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesdb

import androidx.room.Database

@Database(
    entities = [Notes::class],
    version = 1
)
abstract class NotesDatabase {


}