package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories

import com.google.gson.JsonObject
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities.AppDatabase
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.MyApis
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.SafeApiRequest
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse
import retrofit2.Response

/* dependency injection
* instead of creating instance of class we can inject it through constructor
* */
class UserRepository(private val apis: MyApis,
             private val db:AppDatabase
             ) :SafeApiRequest()
{


    /*here we are also creating instance of class in another class
       * this is not good practice*/
    suspend fun sendOtp(userid: String): JsonObject {
        val json = JsonObject()
        json.addProperty("userid",userid)
        return apis.sendOtp(json)
    }

    suspend fun submitOtp(userid: String,otp :String) :AuthResponse{
        return apiRequest { apis.hitSubmitOtpApi("password",userid,otp) }
//        return MyApis.invoke().hitSubmitOtpApi("password",userid,otp)
    }

    /*we are  calling/using App database in our User Repository class to perform fun on database*/


    suspend fun saveUser(user: AuthResponse)=db.getUserDao().upsert(user)



     fun getUser()=db.getUserDao().getUser()


    suspend fun userSignup(name:String,email:String,password:String):AuthResponse {
        return apiRequest { apis.signup(name,email,password) }
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