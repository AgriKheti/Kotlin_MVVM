package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network

import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface MyApis {


    @POST("api/User/sendotp")
    fun sendOtp(@Body jsonObject: String) : Call<User>

    companion object{
        operator fun invoke() : MyApis{
            return Retrofit.Builder()
                .baseUrl("http://117.240.196.238:8486/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApis::class.java)
        }
    }
}