package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network

import com.google.gson.JsonObject
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.SearchResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyApis {


    @POST("api/User/sendotp")
    suspend fun sendOtp(@Body userid: JsonObject) : JsonObject
//    suspend fun sendOtp(@Body userid: JsonObject) : ResponseBody<User>

    companion object{
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor) : MyApis{


            val okHttpClient= OkHttpClient.Builder().addInterceptor(networkConnectionInterceptor)
                .build()
            return Retrofit.Builder()
                .baseUrl("http://117.240.196.238:8486/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApis::class.java)
        }
    }

    @POST("Login")
    @FormUrlEncoded
    suspend fun hitSubmitOtpApi(@Field ("grant_type") password:String,@Field("username") userid:String,
    @Field("password") otp:String): Response<AuthResponse>

    @FormUrlEncoded
    @POST("signup")
    suspend fun signup(@Field("name")name:String,@Field("email")email:String
    ,@Field("password")password:String):Response<AuthResponse>


    @GET("api/List?")
    suspend fun searchSample(@Query("sampleno")sample:String,@Header("Authorization") token:String):Response<SearchResponse>
}