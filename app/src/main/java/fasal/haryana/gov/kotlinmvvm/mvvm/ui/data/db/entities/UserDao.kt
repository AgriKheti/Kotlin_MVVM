package fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse


/*Data access object*/

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsert(user:AuthResponse):Long


//   @Query("SELECT * FROM user")
//    fun getUser() :LiveData<User>







//    @Query("SELECT * FROM user WHERE uid= $CURRENT_USER_ID")
//    fun getUser() :LiveData<User>
}