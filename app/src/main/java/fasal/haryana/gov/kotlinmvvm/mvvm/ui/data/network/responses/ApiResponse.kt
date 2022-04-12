package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses

import retrofit2.Response

interface ApiResponse<T> {
    fun onResponse(response: Response<T>,key:String)
    fun onError(t:Throwable ,key: String)
}