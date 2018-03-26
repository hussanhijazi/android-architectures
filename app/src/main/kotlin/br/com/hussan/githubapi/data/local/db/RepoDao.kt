

package br.com.hussan.githubapi.data.local.db

import android.arch.persistence.room.Dao

/**
 * Interface for database access on Repo related operations.
 */
@Dao
abstract class RepoDao//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    public abstract void insert(Repo... repos);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    public abstract void insertContributors(List<Contributor> contributors);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    public abstract void insertRepos(List<Repo> repositories);
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    public abstract long createRepoIfNotExists(Repo repo);
//
//    @Query("SELECT * FROM repo WHERE owner_login = :login AND name = :name")
//    public abstract LiveData<Repo> load(String login, String name);
//
//    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
//    @Query("SELECT login, avatarUrl, repoName, repoOwner, contributions FROM contributor "
//            + "WHERE repoName = :name AND repoOwner = :owner "
//            + "ORDER BY contributions DESC")
//    public abstract LiveData<List<Contributor>> loadContributors(String owner, String name);
//
//    @Query("SELECT * FROM Repo "
//            + "WHERE owner_login = :owner "
//            + "ORDER BY stars DESC")
//    public abstract LiveData<List<Repo>> loadRepositories(String owner);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    public abstract void insert(RepoSearchResult result);
//
//    @Query("SELECT * FROM RepoSearchResult WHERE query = :query")
//    public abstract LiveData<RepoSearchResult> search(String query);
//
//    public LiveData<List<Repo>> loadOrdered(List<Integer> repoIds) {
//        SparseIntArray order = new SparseIntArray();
//        int index = 0;
//        for (Integer repoId : repoIds) {
//            order.put(repoId, index++);
//        }
//        return Transformations.map(loadById(repoIds), repositories -> {
//            Collections.sort(repositories, (r1, r2) -> {
//                int pos1 = order.get(r1.id);
//                int pos2 = order.get(r2.id);
//                return pos1 - pos2;
//            });
//            return repositories;
//        });
//    }
//
//    @Query("SELECT * FROM Repo WHERE id in (:repoIds)")
//    protected abstract LiveData<List<Repo>> loadById(List<Integer> repoIds);
//
//    @Query("SELECT * FROM RepoSearchResult WHERE query = :query")
//    public abstract RepoSearchResult findSearchResult(String query);
