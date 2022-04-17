package fasal.haryana.gov.kotlinmvvm.mvvm.preferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


private const val KEY_SAVEDAT="key_saveat"
class Preferences(context: Context) {



    private val appContext =context.applicationContext


    private val preferences: SharedPreferences get() = PreferenceManager.getDefaultSharedPreferences(appContext)


    fun savedSavedat(saveAt:String){
        preferences.edit().putString(KEY_SAVEDAT,saveAt)
            .apply()

    }

    fun getsavedValue():String? {
        return preferences.getString(KEY_SAVEDAT,null)
    }


}