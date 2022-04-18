package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses

import com.google.gson.annotations.SerializedName

data class SearchResponse (@SerializedName("status"     ) var status     : String?     = null,
                      @SerializedName("message"    ) var message    : String?     = null,
                      @SerializedName("landDetail" ) var landDetail : LandDetail? = LandDetail(),
                      @SerializedName("farmer"     ) var farmer     : Farmer?     = Farmer()){
}

