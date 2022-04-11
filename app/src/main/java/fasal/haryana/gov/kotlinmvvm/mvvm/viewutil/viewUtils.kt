package fasal.haryana.gov.kotlinmvvm.mvvm.viewutil

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.view.*

fun Context.showtoast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}

fun ProgressBar.show(){
    progress_bar.visibility =View.VISIBLE
}
fun ProgressBar.hide(){
    progress_bar.visibility= View.GONE
}