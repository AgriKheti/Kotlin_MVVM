package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network

import com.google.gson.JsonObject
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {


    @POST("api/User")
    fun callSendOtp(@Body jsonObject: JsonObject?): Call<JsonObject?>?

//    we can directly pass the model class while calling its value
//    fun callSendOtp(@Body jsonObject: JsonObject?): Call<AnimalModel>?


    @GET("entries")
    fun callanimalApi(): Call<JsonObject>?

    /*Crop Verification Apis*/
    @FormUrlEncoded
    @POST("Login")
    fun callVerifyOtp(
        @Field("username") userid: String?,
        @Field("password") otp: String?,
        @Field("grant_type") grant_type: String?
    ): Call<JsonObject?>?

    @GET("Tehsil/discode")
    fun getTehSil(
        @Query("DisCode") paramsMap: String?,
        @Header("Authorization") token: String?
    ): Call<JsonObject?>?

    @GET("Revenue")
    fun getCropList(
        @Query("SessionID") sessionId: String?,
        @Query("LandTypeID") LandTypeID: String?,
        @Header("Authorization") token: String?
    ): Call<JsonObject?>?

    @POST("Revenue/SaveCropDetails")
    fun saveCropList(
        @Body jsonObject: JsonObject?,
        @Header("Authorization") token: String?
    ): Call<JsonObject?>?

    @POST("Revenue/GetOwnerNames")
    fun getOwnName(
        @Body jsonObject: JsonObject?,
        @Header("Authorization") token: String?
    ): Call<JsonObject?>?

    @POST("FileUpload/byte")
    fun uplaodImageApi3(@Body jsonObject: JsonObject?): Call<JsonObject?>?

    @GET("Village/discode")
    fun getVillage(
        @Query("DisCode") paramsMap: String?,
        @Header("Authorization") token: String?
    ): Call<JsonObject?>?

    // upload image Api
    @GET("Revenue/AllotedVillage")
    fun getVillageAllowted(
        @Query("id") paramsMap: String?,
        @Header("Authorization") token: String?
    ): Call<JsonObject?>?

    // upload image Api
    @Multipart
    @POST("api/FileUpload/byte")
    fun uplaodImageApi(@Part file: MultipartBody.Part?): Call<JsonObject?>?

    //    @Multipart
    //    @POST("api/FileUpload/post")
    //    Call<JsonObject> uplaodImageApi2(@Part MultipartBody.Part file );
    //    @POST("api/FileUpload/byte")
    //    Call<JsonObject> uplaodImageApi3(@Body JsonObject jsonObject );
    //
    //
    @POST("api/List/mfmb")
    fun getFarmerDetails(
        @Body `object`: JsonObject?,
        @Header("Authorization") token: String?
    ): Call<JsonObject?>?

    @GET("api/Block/discode")
    fun getBlock(
        @Query("DisCode") paramsMap: String?,
        @Header("Authorization") token: String?
    ): Call<JsonObject?>?

    @POST("Revenue/GetMurabaByNVCODE")
    fun getMurrabaNo(
        @Body jsonObject: JsonObject?,
        @Header("Authorization") token: String?
    ): Call<JsonObject?>?

    @POST("Revenue/GetLandDetails")
    fun getRevenueNo(
        @Body jsonObject: JsonObject?,
        @Header("Authorization") token: String?
    ): Call<JsonObject?>?

    @GET("api/List")
    fun getIrriSource(
        @Query("irrigationID") paramsMap: String?,
        @Header("Authorization") token: String?
    ): Call<JsonObject?>?

    @POST
    fun setSample(
        @Body jsonObject: JsonObject?,
        @Header("Authorization") s: String?
    ): Call<JsonObject?>?

    @POST("api/RegisterSoil/registerland")
    fun submitLandDetails(
        @Body jsonObject: JsonObject?,
        @Header("Authorization") tokn: String?
    ): Call<JsonObject?>?

    @POST("api/RegisterSoil/registerfarmer")
    fun submitFarmerDetails(
        @Body jsonObject: JsonObject?,
        @Header("Authorization") s: String?
    ): Call<JsonObject?>? //   /////////////////////////////////////////
    //    // upload image Api
    //    @Multipart
    //    @POST("upload/")
    //    Call<JsonObject> uplaodImageApi(@Part MultipartBody.Part file, @Header("Authorization") String token);
    //
    ////    contact us
    //    @GET("setting")
    //    Call<JsonObject>callContactUs(@Header("Authorization") String token);
    //
    //    //  for user log in to the app
    //    @POST("auth/login/")
    //    Call<JsonObject> callLoginApii(@Body JsonObject jsonObject);
    //
    //    // edit user PROFILE_FRAGMENT
    //    @PUT("user/")
    //    Call<JsonObject> callEditProfileApi(@Header("Authorization") String token,@Body JsonObject jsonObject);
    //
    //    //    get user PROFILE_FRAGMENT Details
    //    @GET("user/")
    //    Call<JsonObject> callGetUserProfile(@Header("Authorization") String token);
    //
    //    //   for user registraion
    //    @POST("user/register/")
    //    Call<JsonObject> callSignUpUser(@Body JsonObject jsonObject);
    //
    //    //   for agent registraion
    //    @POST("user/register/agent/")
    //    Call<JsonObject> callSignUpAgent(@Body JsonObject jsonObject);
    //
    //    // genrate the otp to the mail
    //    @POST("user/sendOTP/")
    //    Call<JsonObject> callOtpReset(@Body JsonObject jsonObject);
    //
    //    //    change the password
    //    @PUT("user/changePassword/")
    //    Call<JsonObject> callChangePasswordApi(@Header("Authorization")String token, @Body JsonObject jsonObject);
    //    //call LOGIN_FRAGMENT via facebook
    //
    //    //  for HOME_FRAGMENT of the customerSide Category Api
    //    @GET("category")
    //    Call<JsonObject>callHomeApiForCategory(@Header("Authorization")String token);
    //
    //    // for user logged Out
    //    @POST("auth/logout/")
    //    Call<JsonObject> callLogOutApi(@Header("Authorization") String token, @Body JsonObject jsonObject);
    //
    //    // call subCategory Api
    //    @GET("subCategory")
    //     Call<JsonObject>callSubCategoryApi(@Header("Authorization")String token);
    //
    ////  call EmailValueForPasswordReset Edit Api
    //    @POST("user/newEmailSendOTP")
    //     Call<JsonObject>callEditEmailApi(@Header("Authorization")String token,@Body JsonObject jsonObject);
    //
    //    //    to verify the generated otp
    //    @POST("user/verifyOTP/{otp}/{email}")
    //    Call<JsonObject> callVerifyOtpApi(@Path("otp") String OtpSent, @Path("email") String email);
    //
    //    //    generate new password after forgot password
    //    @POST("user/newPassword/")
    //    Call<JsonObject> callNewPasswordApi(@Body JsonObject jsonObject);
    //
    //    @POST("auth/login/facebook/")
    //    Call<JsonObject> callFacebookLoginApi(@Header("Authorization")String token,@Body JsonObject mJsonObject);
    //
    //    // settings screen API
    //    @GET("setting/")
    //    Call<JsonObject> getTermsOfServices(@Header("Authorization") String token);
    //
    //    // earning screen API
    //    @GET("booking/earning/")
    //    Call<JsonObject> getMyEarning(@Query("agentId") String agentId,@Header("Authorization") String token);
    //
    //    // feedback API
    //    @POST("rating/")
    //    Call<JsonObject> hitFeedback(@Body JsonObject jsonObject,@Header("Authorization")String token);
    //
    //    //for braintree Token genraration
    //    @POST("brainTree/Token/")
    //    Call<JsonObject> calklBraintreeTokenGenration(@Header("Authorization")String token,@Body JsonObject jsonObject);
    //
    //    // to fetch all the braintree card
    //    @GET("brainTree/card")
    //    Call<JsonObject>callFetchCardApi(@Header("Authorization") String token, @Header("brainTreeId") String braintreeId);
    //
    //    // call save cardApi
    //    @POST("brainTree/card")
    //    Call<JsonObject>callSaveCardApi(@Header("brainTreeId") String braintreeId,@Header("Authorization") String token,@Body JsonObject jsonObject );
    //
    //    // delete card from braintree
    //    @HTTP(method = "DELETE", path = "brainTree/card/", hasBody = true)
    //    Call<JsonObject>callDeleteCardApi(@Header("Authorization")String token,@Body JsonObject jsonObject);
    //
    //    @GET("booking/")
    //    Call<JsonObject> hitBookingAPI(@Query("type") String type, @Header("Authorization") String token);
    //
    //    @GET("schedule/")
    //    Call<JsonObject> hitGetScheduleTime(@Header("Authorization") String token);
    //
    //    @GET("subCategory/getAvailableServices/")
    //    Call<JsonObject> hitTypesOfServicesAPI(@Header("Authorization") String token);
    //
    //    @GET("subCategory/list/{id}/")
    //    Call<JsonObject> hitSubCategoryAPI(@Path("id") String categoryID,@Header("Authorization") String token);
    //
    //    @POST("user/usersettings/")
    //    Call<JsonObject> hitNotificationAPI(@Body JsonObject status, @Header("Authorization") String token);
    //
    //    @GET("user/usersettings/")
    //    Call<JsonObject> checkNotificationStatusAPI(@Query("deviceId") String deviceId, @Header("Authorization") String token);
    //
    //    @POST("serviceAgentMapping/")
    //    Call<JsonObject> setServiceTypePriceAPI(@Body JsonObject jsonObject, @Header("Authorization") String token);
}