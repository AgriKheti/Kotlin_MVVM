package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network

import com.google.gson.JsonObject
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApis {


    @POST("api/User/sendotp")
    suspend fun sendOtp(@Body userid: JsonObject) : JsonObject
//    suspend fun sendOtp(@Body userid: JsonObject) : ResponseBody<User>

    companion object{
        operator fun invoke() : MyApis{
            return Retrofit.Builder()
                .baseUrl("http://117.240.196.238:8486/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApis::class.java)
        }
    }

    @POST("Login")
    @FormUrlEncoded
    suspend fun hitSubmitOtpApi(@Field ("grant_type") password:String,@Field("username") userid:String,
    @Field("password") otp:String): Response<AuthResponse>
}