package br.com.hussan.githubapi.data.local.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.hussan.githubapi.data.model.Repo;

@Dao
public abstract class RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertRepos(List<Repo> repositories);

    @Query("SELECT * FROM Repo "
            + "WHERE lower(owner_login) = :owner "
            + "ORDER BY stars DESC")
    public abstract LiveData<List<Repo>> loadRepositories(String owner);

}
