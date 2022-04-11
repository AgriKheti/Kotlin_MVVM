package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities.User
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.MyApis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {


    fun sendOtp(userid:String):LiveData<User>{

        val loginResponse = MutableLiveData<User>()


        MyApis.invoke().sendOtp(userid)
            .enqueue(object: Callback<User>
            {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful){
                        loginResponse.value=response.body()!!
                    }else{

//                        loginResponse.value= response.errorBody()!!
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                }

            })
        return loginResponse
    }
}