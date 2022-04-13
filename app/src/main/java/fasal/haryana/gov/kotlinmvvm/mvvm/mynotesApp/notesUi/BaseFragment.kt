package fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/*we have created a common base fragment class that extends the coroutines function
* Beacause in every fragment i need to use coroutine so we have define it in one common abstract class
* and inherit that class in every fragment where we want to access the coroutines
*
* */
abstract class BaseFragment :Fragment() , CoroutineScope{

    private lateinit var job:Job

    override val coroutineContext: CoroutineContext
        get() = job+Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job= Job()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}