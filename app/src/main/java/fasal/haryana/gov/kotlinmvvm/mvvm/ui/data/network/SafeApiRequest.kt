package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network

import fasal.haryana.gov.kotlinmvvm.mvvm.utils.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

/*just to avoid check response is success full every time we have created this class*/
abstract class SafeApiRequest {

    /*this is known as Generic funtions*/
    suspend fun <T :Any> apiRequest(call:suspend ()-> Response<T>): T {
        val response =call.invoke()

        if (response.isSuccessful){
            return response.body()!!
        }else {
            val error = response.errorBody()?.toString()
            val message =StringBuilder()

            /*fetching error message from error body , you can change your message param
            * as per your api name
            * */
            error?.let {
                try {
                    message.append(JSONObject(it).getString("error_description"))

                } catch (e: JSONException) {
                    message.append("\n")
                }
                message.append("Error code: ${response.code()}")

            }
            throw ApiException(message.toString())

        }
        }

}