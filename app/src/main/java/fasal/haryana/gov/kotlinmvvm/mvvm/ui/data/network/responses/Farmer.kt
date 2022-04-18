package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses

import com.google.gson.annotations.SerializedName

data class Farmer (
    @SerializedName("farmerid"           ) var farmerid          : String? = null,
    @SerializedName("FarmerName"         ) var FarmerName        : String? = null,
    @SerializedName("Father_HusbandName" ) var FatherHusbandName : String? = null,
    @SerializedName("MobileNumber"       ) var MobileNumber      : String? = null,
    @SerializedName("Gender"             ) var Gender            : String? = null,
    @SerializedName("Caste_Category"     ) var CasteCategory     : String? = null,
    @SerializedName("MemberID"           ) var MemberID          : String? = null,
    @SerializedName("MemberIDENC"        ) var MemberIDENC       : String? = null,
    @SerializedName("PPPIDENC"           ) var PPPIDENC          : String? = null,
    @SerializedName("PPPID"              ) var PPPID             : String? = null,
    @SerializedName("CreatedOn"          ) var CreatedOn         : String? = null)
