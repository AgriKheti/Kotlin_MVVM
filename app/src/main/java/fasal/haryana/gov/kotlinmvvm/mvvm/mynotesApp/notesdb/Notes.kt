package fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Notes (
    val title:String,
    val description:String) :Serializable // to pass data class from one fragment to other it sould be declared as
//serializable
{
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}