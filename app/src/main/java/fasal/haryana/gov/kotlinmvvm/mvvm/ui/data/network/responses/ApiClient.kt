package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses

import android.text.TextUtils
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "http://117.240.196.238:8486/"

    //    private static final String BASE_URL = "https://botpengiun.com/";
    //    private static final String BASE_URL = "https://botpengiun.com";
    private const val USERNAME = ""
    private const val PASSWORD = ""
    private var mApiInterface: ApiInterface? = null

    //service before login
    val apiInterface: ApiInterface?
        get() = if (mApiInterface == null) setApiInterface() else mApiInterface

    /* if API interface is null than setApiInterface */
    private fun setApiInterface(): ApiInterface? {
        var mAuthToken: String? = ""
        val httpClient = OkHttpClient.Builder()
        val mBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        if (!TextUtils.isEmpty(USERNAME) && !TextUtils.isEmpty(PASSWORD)) mAuthToken =
            Credentials.basic(
                USERNAME, PASSWORD
            )
        if (!TextUtils.isEmpty(mAuthToken)) {
            val finalMAuthToken = mAuthToken
            val interceptor = Interceptor { chain ->
                val original = chain.request()
                val builder = original.newBuilder()
                    .header("Authorization", finalMAuthToken)
                val request = builder.build()
                chain.proceed(request)
            }
            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor)
                mBuilder.client(httpClient.build())
                mApiInterface = mBuilder.build().create(ApiInterface::class.java)
            }
        } else mApiInterface = mBuilder.build().create(ApiInterface::class.java)
        return mApiInterface
    }
}
