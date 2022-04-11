package fasal.haryana.gov.kotlinmvvm.mvvm.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Coroutines{

    /*creating corotuine on main thread*/

    fun main(work: suspend (()-> Unit))=
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }
}