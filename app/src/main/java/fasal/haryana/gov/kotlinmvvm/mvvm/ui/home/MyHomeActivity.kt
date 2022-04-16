package fasal.haryana.gov.kotlinmvvm.mvvm.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import fasal.haryana.gov.kotlinmvvm.R
import kotlinx.android.synthetic.main.activity_my_home.*

class MyHomeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_home)

        setSupportActionBar(toolbar_home)

        val navcontroller= Navigation.findNavController(this,R.id.fragment_nav_home)
        NavigationUI.setupWithNavController(nav_view_home,navcontroller)
        /*it is for , so that the action bar titile change automatically*/
        NavigationUI.setupActionBarWithNavController(this,navcontroller
        ,drawer_layout)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this,R.id.fragment_nav_home)
            ,drawer_layout )
    }

}