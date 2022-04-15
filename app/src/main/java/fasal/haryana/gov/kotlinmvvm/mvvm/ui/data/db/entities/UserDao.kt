package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse


/*Data access object*/

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsert(user:AuthResponse):Long


   @Query("SELECT * FROM authresponse")
    fun getUser() : LiveData<AuthResponse>







//    @Query("SELECT * FROM user WHERE uid= $CURRENT_USER_ID")
//    fun getUser() :LiveData<User>
}