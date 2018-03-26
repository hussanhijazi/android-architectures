

package br.com.hussan.githubapi.data.local.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import br.com.hussan.githubapi.data.model.User

import io.reactivex.Flowable

/**
 * Interface for database access for User related operations.
 */
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM users order by rowid desc limit 1")
    fun getLastQuery(): Flowable<User>

}
