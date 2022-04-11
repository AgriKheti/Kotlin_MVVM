package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse

//@Entity(Table name here if want to change it)

/* for room db to avoid multiple entry for same user */
 const val CURRENT_USER_ID=0
@Entity
data class User (
    @SerializedName("status"  ) var status  : String? = null,
    @SerializedName("message" ) var message : String? = null,
    @SerializedName("user"    ) var user    : AuthResponse? = null
//    @SerializedName("user"    ) var user    : String? = null

)
{
    /*for room db to avoid duplicacy */
    @PrimaryKey(autoGenerate = false)
    var  uid :Int = CURRENT_USER_ID

}

