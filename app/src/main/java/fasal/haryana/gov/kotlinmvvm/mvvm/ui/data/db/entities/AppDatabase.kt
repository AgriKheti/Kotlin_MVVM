package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities

import android.content.Context
import androidx.room.*
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse


@Database(
    entities = [AuthResponse::class],
    version = 1
)

abstract class AppDatabase :RoomDatabase() {

    abstract fun getUserDao(): UserDao

    /*creating database */
    companion object{

        /* Volatile means it is immidaitely visible to all threads*/
        @Volatile
        private var instance:AppDatabase?=null
        /*to make sure we dont create two instance of our database*/
        private var LOCK=Any()

        
        /*pass the context to build database*/
        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance?:buildDatabase(context).also {
                /*assigning the value to instance that we recived from buildDatabse*/
                instance=it
            }
        }

        private fun buildDatabase(context: Context) =Room.databaseBuilder(context.applicationContext
        ,AppDatabase::class.java,"MydatabaseName.db").build()





    }

}