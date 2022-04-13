package fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notes (
    val title:String,
    val description:String)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}