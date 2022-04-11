package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories

import com.google.gson.JsonObject
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities.User
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.MyApis
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {


    suspend fun sendOtp(userid: String):Response<User>{
        /*here we are also creating instance of class in another class
        * this is not good practice
        * */

        var json = JsonObject()
        json.addProperty("userid",userid)
        return MyApis.invoke().sendOtp(json)

    }



//    fun sendOtp(userid:String):LiveData<User>{
//
//        val loginResponse = MutableLiveData<User>()
//
//
//        MyApis.invoke().sendOtp(userid).enqueue(object: Callback<User>
//            {
//                override fun onResponse(call: Call<User>, response: Response<User>) {
//                    if (response.isSuccessful){
//                        loginResponse.value=response.body()!!
//                    }else{
//
////                        loginResponse.value= response.errorBody()!!
//                    }
//                }
//
//                override fun onFailure(call: Call<User>, t: Throwable) {
//                }
//
//            })
//        return loginResponse
//    }
}