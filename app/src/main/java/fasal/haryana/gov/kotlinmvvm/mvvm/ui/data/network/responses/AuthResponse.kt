package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses

import com.google.gson.annotations.SerializedName

data class AuthResponse(@SerializedName("access_token" ) var accessToken  : String? = null,
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

)