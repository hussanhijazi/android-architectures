

package br.com.hussan.githubapi.data.local.db


import android.arch.persistence.room.RoomDatabase
import br.com.hussan.githubapi.data.model.User

/**
 * Main database description.
 */
@android.arch.persistence.room.Database(entities = arrayOf(User::class), version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun repoDao(): RepoDao
}
