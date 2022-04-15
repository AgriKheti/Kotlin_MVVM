package fasal.haryana.gov.kotlinmvvm.mvvm.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import fasal.haryana.gov.kotlinmvvm.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_myaccount_layout.*

class MainActivity : AppCompatActivity() {

     var alertDialog: AlertDialog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        new_sample_tv.setOnClickListener {
            Intent(this, FarmerDetailsActivity::class.java).also {
                startActivity(it)
            }
        }
        search_sample_tv.setOnClickListener {
            Intent(this, SearchActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.account_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_account-> showAccountdetails()
            R.id.menu_logout -> logoutUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logoutUser() {
    }

    private fun showAccountdetails() {
        val viewGroup:ViewGroup =findViewById(android.R.id.content)

        val dialogview: View =LayoutInflater.from(this).inflate(R.layout.include_myaccount_layout,viewGroup
        ,false)

         val okbtn = dialogview.findViewById<Button>(R.id.ok_btn)
        val builder =AlertDialog.Builder(this)
        builder.setView(dialogview)
        okbtn.setOnClickListener { alertDialog?.dismiss() }
        alertDialog=builder.create()
        alertDialog!!.show()
    }
}