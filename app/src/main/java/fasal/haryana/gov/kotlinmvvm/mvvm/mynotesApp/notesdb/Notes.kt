package fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesdb

import androidx.room.PrimaryKey

data class Notes (
    val title:String,
    val description:String)
{
    @PrimaryKey(autoGenerate = true)
    val id:Int=0
}