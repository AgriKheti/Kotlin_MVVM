package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import fasal.haryana.gov.kotlinmvvm.mvvm.utils.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(context: Context) :Interceptor{

    private val applicationcontext = context.applicationContext
    @RequiresApi(Build.VERSION_CODES.M)
    override fun intercept(chain: Interceptor.Chain): Response {


        if (!isInternetAvailable()){
            throw NoInternetException("Make sure you have an active internet connection")
        }else return  chain.proceed(chain.request())


    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun isInternetAvailable() :Boolean{
        var result = false
        val connectivityManager = applicationcontext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager.let {
            it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
                result=when{
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI)->true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)->true
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)-> true
                    else -> false
                }
            }
            return  result
        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            val networkCapabilities = connectivityManager.activeNetwork ?: return false
//            val actNw =
//                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
//            result = when {
//                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
//                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
//                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
//                else -> false
//            }
//        } else {
//            connectivityManager.run {
//                connectivityManager.activeNetworkInfo?.run {
//                    result = when (type) {
//                        ConnectivityManager.TYPE_WIFI -> true
//                        ConnectivityManager.TYPE_MOBILE -> true
//                        ConnectivityManager.TYPE_ETHERNET -> true
//                        else -> false
//                    }
//
//                }
//            }
//        }
//
//        return result
    }

}