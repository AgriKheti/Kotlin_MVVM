package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses

import com.google.gson.annotations.SerializedName

data class LandDetail (@SerializedName("sampleno"         ) var sampleno         : String? = null,
                  @SerializedName("Cycle"            ) var Cycle            : String? = null,
                  @SerializedName("DCode"            ) var DCode            : String? = null,
                  @SerializedName("TCode"            ) var TCode            : String? = null,
                  @SerializedName("BCode"            ) var BCode            : String? = null,
                  @SerializedName("VCode"            ) var VCode            : String? = null,
                  @SerializedName("DIS_NAME"         ) var DISNAME          : String? = null,
                  @SerializedName("TEH_NAME"         ) var TEHNAME          : String? = null,
                  @SerializedName("BLK_NAME"         ) var BLKNAME          : String? = null,
                  @SerializedName("VIL_NAME"         ) var VILNAME          : String? = null,
                  @SerializedName("Muraba"           ) var Muraba           : String? = null,
                  @SerializedName("Khewat"           ) var Khewat           : String? = null,
                  @SerializedName("Khatoni"          ) var Khatoni          : String? = null,
                  @SerializedName("Killa"            ) var Killa            : String? = null,
                  @SerializedName("RevKnl"           ) var RevKnl           : String? = null,
                  @SerializedName("RevMrl"           ) var RevMrl           : String? = null,
                  @SerializedName("SoilTypeID"       ) var SoilTypeID       : String? = null,
                  @SerializedName("IrrigatedID"      ) var IrrigatedID      : String? = null,
                  @SerializedName("IrrigationSource" ) var IrrigationSource : String? = null,
                  @SerializedName("latitude"         ) var latitude         : String? = null,
                  @SerializedName("longitude"        ) var longitude        : String? = null,
                  @SerializedName("picurl"           ) var picurl           : String? = null,
                  @SerializedName("CreatedOn"        ) var CreatedOn        : String? = null){

}