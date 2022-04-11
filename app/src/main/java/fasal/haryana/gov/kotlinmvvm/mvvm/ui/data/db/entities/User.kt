package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Entity(Table name here if want to change it)

/* for room db to avoid multiple entry for same user */
 const val CURRENT_USER_ID=0
@Entity
data class User (

    @SerializedName("access_token" ) var accessToken  : String? = null,
    @SerializedName("token_type"   ) var tokenType    : String? = null,
    @SerializedName("expires_in"   ) var expiresIn    : Int?    = null,
    @SerializedName("Name"         ) var Name         : String? = null,
    @SerializedName("ID"           ) var ID           : String? = null,
    @SerializedName("MobileNumber" ) var MobileNumber : String? = null,
    @SerializedName("Designation"  ) var Designation  : String? = null,
    @SerializedName("discode"      ) var discode      : String? = null,
    @SerializedName("districtName" ) var districtName : String? = null,
    @SerializedName("status"       ) var status       : String? = null,
    @SerializedName(".issued"      ) var issued      : String? = null,
    @SerializedName(".expires"     ) var expires     : String? = null

){
    /*for room db to avoid duplicacy */
    @PrimaryKey(autoGenerate = false)
    var  uid :Int = CURRENT_USER_ID

}

