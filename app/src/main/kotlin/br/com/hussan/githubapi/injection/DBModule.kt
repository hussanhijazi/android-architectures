

package br.com.hussan.githubapi.injection

import android.app.Application
import android.arch.persistence.room.Room
import br.com.hussan.githubapi.data.local.db.MyDatabase
import br.com.hussan.githubapi.data.local.db.RepoDao
import br.com.hussan.githubapi.data.local.db.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DBModule {
    @Singleton
    @Provides
    fun provideDb(app: Application): MyDatabase {
        return Room.databaseBuilder(app, MyDatabase::class.java, "Sample.db").build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: MyDatabase): UserDao {
        return db.userDao()
    }

    @Singleton
    @Provides
    fun provideRepoDao(db: MyDatabase): RepoDao {
        return db.repoDao()
    }
}
