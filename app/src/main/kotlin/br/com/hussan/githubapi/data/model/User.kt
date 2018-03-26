

package br.com.hussan.githubapi.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class User(@PrimaryKey
                @SerializedName("login")
                @ColumnInfo(name = "login")
                var login: String)